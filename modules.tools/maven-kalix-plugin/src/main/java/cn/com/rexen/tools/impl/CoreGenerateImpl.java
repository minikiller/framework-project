package cn.com.rexen.tools.impl;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * Core代码生成实现类
 */
public class CoreGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String beanFileName = "%sBeanServiceImpl.java";
    String xmlFileName = "blueprint.xml";
    String activatorFileName = "InitActivator.java";

    public CoreGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "core");
        javaFileMap.put("BeanServiceImpl",  "//" + moduleName + "//biz//" +String.format(beanFileName, beanName));
        javaFileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        javaFileMap.put("blueprint.xml", "//OSGI-INF//blueprint//" + xmlFileName);
    }

    @Override
    public void genResources() {

    }


}
