package cn.com.rexen.tools.impl;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * 实体代码生成实现类
 */
public class EntitiesGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String beanFileName = "%sBean.java";
    String xmlFileName = "persistence.xml";
    String activatorFileName = "InitActivator.java";

    public EntitiesGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "entities");
        javaFileMap.put("Bean", String.format(beanFileName, beanName));
        javaFileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        javaFileMap.put("persistence.xml", "//META-INF//" + xmlFileName);
    }

    @Override
    public void genResources() {

    }


}
