package cn.com.rexen.tools.impl;

import cn.com.rexen.core.util.Assert;
import cn.com.rexen.tools.Util;
import cn.com.rexen.tools.api.IGenerate;
import org.apache.maven.plugin.MojoExecutionException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.compiler.STException;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 */
public abstract class AbstractGenernateImpl implements IGenerate {
    public final static String encoding = "UTF-8";
    public final static String JAVA_SOURCE_PATH = "\\src\\main\\java\\";
    public final static String RESOURCES_SOURCE_PATH = "src\\main\\resources";
    //处理java类的map
    public Map<String, String> javaFileMap = new HashMap<>();
    protected String packageName;
    protected String beanName;
    protected String pomName;
    protected Map<File, File> files;
    protected File inputDir, outputDir;
    protected String moduleName;

    protected Map<String, String> attributes;

    public AbstractGenernateImpl(Map<String, String> attributes, File inputDir, File outputDir, String moduleName) {
        this.attributes = attributes;
        this.inputDir = inputDir;
        beanName = attributes.get("beanName");
        Assert.notNull(beanName);
        packageName = attributes.get("packageName");
        Assert.notNull(packageName);
        pomName = attributes.get("pomName");
        Assert.notNull(pomName);
        File target = new File(outputDir.getAbsolutePath() + "\\" + beanName.toLowerCase() + "-" + moduleName);
        if (!target.exists())
            target.mkdirs();
        this.outputDir = target;
        this.moduleName = moduleName;

    }

    @Override
    public void genJavaSource() throws MojoExecutionException {
        //处理api模板
        Map<File, File> apiFiles = new LinkedHashMap<File, File>();
        // looks like maven may change empty String to null?
        Assert.notNull(moduleName);
        findFiles(apiFiles, new File(inputDir.getAbsolutePath() + "//" + moduleName), outputDir);
        for (Map.Entry<File, File> fileEntry : apiFiles.entrySet()) {
            File inputFile = fileEntry.getKey();
            File outputFile = fileEntry.getValue();
            String input = Util.readFile(inputFile, encoding);
            ST stringTemplate;
            try {
                stringTemplate = new ST(input);
                if (attributes != null) {
                    for (Map.Entry<String, String> attrEntry : attributes.entrySet()) {
                        stringTemplate.add(attrEntry.getKey(), attrEntry.getValue());
                    }
                }
                String output = stringTemplate.render();
                Util.writeFile(outputFile, encoding, output);
            } catch (STException e) {
                throw new MojoExecutionException("Problem when trying to process input template '"
                        + inputFile.getAbsolutePath() + "': " + e.getMessage(), e);
            }
        }
    }

    //递归确定模板文件以及对应的目标目录文件
    private void findFiles(Map<File, File> result, File inputDir,
                             File outputDir) {
        CharSequence javaChar = "java";
        CharSequence resourceChar = "xml";
        for (File f : inputDir.listFiles()) {
            String name = f.getName();
            if (f.isDirectory()) {
                findFiles(result, f, new File(outputDir, name));
            } else {
                name = name.substring(0, name.length() - Util.inputSuffix.length());
                String javaFileName = javaFileMap.get(name);
                //判断是否为java文件
                if (javaFileName != null) {
                    //处理java类型的文件
                    if (javaFileName.contains(javaChar)) {
                        File pd = new File(this.outputDir, JAVA_SOURCE_PATH + packageName.replaceAll("\\.", "/"));
                        File javaFile = new File(pd, javaFileName);
                        result.put(f, javaFile);
                    }
                    //处理资源类型的文件
                    else if (javaFileName.contains(resourceChar)) {
                        File pd = new File(this.outputDir, RESOURCES_SOURCE_PATH);
                        File javaFile = new File(pd, javaFileName);
                        result.put(f, javaFile);
                    }

                } else {
                    if (!outputDir.exists()) {
                        outputDir.mkdirs();
                    }
                    result.put(f, new File(outputDir, name));
                }

            }
        }
    }
}
