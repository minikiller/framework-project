package cn.com.rexen.tools.impl;

import cn.com.rexen.tools.Util;
import cn.com.rexen.tools.api.IGenerate;
import org.apache.maven.plugin.MojoExecutionException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.compiler.STException;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 */
public class ApiGenerateImpl extends AbstractGenernateImpl implements IGenerate {
    String serviceFileName = "I%sBeanService.java";
    String daoFileName = "I%sBeanDao.java";
    String activatorFileName = "InitActivator.java";


    public ApiGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        this.attributes = attributes;
        this.inputDir = inputDir;
        File target = new File(outputDir.getAbsolutePath() + "\\" + beanName.toLowerCase() + "-api");
        if (!target.exists())
            target.mkdirs();
        this.outputDir = target;

        javaFileMap.put("IBeanService", "//biz//" + String.format(serviceFileName, beanName));
        javaFileMap.put("IBeanDao", "//dao//" + String.format(daoFileName, beanName));
        javaFileMap.put("InitActivator", "//internal//+InitActivator.java");
    }

    @Override
    public void genJavaSource() throws MojoExecutionException {
        //处理api模板
        Map<File, File> apiFiles = new LinkedHashMap<File, File>();
        // looks like maven may change empty String to null?
        findFiles(apiFiles, new File(inputDir.getAbsolutePath() + "//api"), outputDir);
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

    @Override
    public void genResources() {

    }


}
