package cn.com.rexen.tools.impl;

import cn.com.rexen.tools.Util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 */
public class AbstractGenernateImpl {
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

    protected Map<String, String> attributes;

    //递归确定模板文件以及对应的目标目录文件
    protected void findFiles(Map<File, File> result, File inputDir,
                             File outputDir) {
        for (File f : inputDir.listFiles()) {
            String name = f.getName();
            if (f.isDirectory()) {
                findFiles(result, f, new File(outputDir, name));
            } else {
                name = name.substring(0, name.length() - Util.inputSuffix.length());
                String javaFileName = javaFileMap.get(name);
                //判断是否为java文件
                if (javaFileName != null) {
                    File pd = new File(this.outputDir, JAVA_SOURCE_PATH + packageName.replaceAll("\\.", "/"));
//                    pd.mkdirs();
                    File javaFile = new File(pd, javaFileName);
                    result.put(f, javaFile);
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
