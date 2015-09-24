package cn.com.rexen.tools.impl;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * API 接口代码生成实现类
 */
public class ApiGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String serviceFileName = "I%sBeanService.java";
    String daoFileName = "I%sBeanDao.java";
    String activatorFileName = "InitActivator.java";

    public ApiGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "api");
        javaFileMap.put("IBeanService", "//" + moduleName + "//biz//" + String.format(serviceFileName, beanName));
        javaFileMap.put("IBeanDao", "//" + moduleName + "//dao//" + String.format(daoFileName, beanName));
        javaFileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
    }

    @Override
    public void genResources() {

    }


}
