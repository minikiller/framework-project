package cn.com.rexen.tools.impl;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * 前台菜单注册服务代码生成实现类
 */
public class WebGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String beanFileName = "%sMenuImpl.java";
    String xmlFileName = "%s-web.xml";
    String activatorFileName = "InitActivator.java";

    public WebGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "web");
        javaFileMap.put("MenuImpl", "//" + moduleName +"//impl//"+ String.format(beanFileName, beanName));
        javaFileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        javaFileMap.put("web.xml", "//OSGI-INF//blueprint//" + String.format(xmlFileName, beanName));
    }

    @Override
    public void genResources() {

    }


}
