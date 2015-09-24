package cn.com.rexen.tools.impl;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * 前台extjs代码生成实现类
 */
public class ExtjsGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String beanFileName = "%sBeanDaoOpenjpa.java";
    String xmlFileName = "blueprint.xml";
    String activatorFileName = "InitActivator.java";

    public ExtjsGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "extjs");
        javaFileMap.put("BeanDaoOpenjpa", "//" + moduleName + String.format(beanFileName, beanName));
        javaFileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        javaFileMap.put("blueprint.xml", "//resources//OSGI-INF//blueprint//" + xmlFileName);
    }

    @Override
    public void genResources() {

    }


}
