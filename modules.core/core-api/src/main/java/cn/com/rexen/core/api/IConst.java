package cn.com.rexen.core.api;

import cn.com.rexen.core.util.ConfigUtil;

/**
 * 系统常量定义
 * Created by sunlingfeng on 2014/8/21.
 */
public class IConst {
    public final static String URGENT_WICKET_APPLICATION_NAME = "daren.project.urgent"; //应急系统
    public final static String SYSTEM_WICKET_APPLICATION_NAME = "daren.project.system";//系统配置
    public final static String EXAMPLE_WICKET_APPLICATION_NAME = "daren.project.example";//例子
    public final static String GOVERNMENT_WICKET_APPLICATION_NAME = "daren.project.government";//政务
    public final static String COMPANY_WICKET_APPLICATION_NAME = "daren.project.company";//企业用户
    public final static String GIS_WICKET_APPLICATION_NAME = "daren.project.gis";//gis 系统
    public final static String DEMO__WICKET_APPLICATION_NAME = "daren.project.demo";
    public final static String COOPERATE_WICKET_APPLICATION_NAME = "daren.project.cooperate";
    public final static String VIDEO_WICKET_APPLICATION_NAME = "daren.project.video";//video 系统
    /*public final static String OFFICE_WEB_PATH_READ = "http://localhost:8080/tempfile/";
    public final static String OFFICE_WEB_PATH_WRITE = "D:/apache-tomcat/webapps/uploadfile/";
    public final static String OFFICE_WEB_PATH_TEMP = "D:/apache-tomcat/webapps/tempfile/";*/
    /*public final static String XT_OFFICE_WEB_PATH_WRITE = "D:/tomcat7-9-16/webapps/uploadfile/";
    public final static String XT_OFFICE_WEB_PATH_READ = "http://192.168.1.80:8080/uploadfile/";*/
    /*四平路径配置
    public final static String XT_OFFICE_WEB_PATH_WRITE = "E:\\web\\tomcat_7.0.27_8687\\webapps\\uploadfile\\";
    public final static String XT_OFFICE_WEB_PATH_READ = "http://192.168.1.106:8080/uploadfile/";
    //release config
    public final static String OFFICE_WEB_PATH_READ = "http://202.98.7.181:8687/tempfile/";
    public final static String OFFICE_WEB_PATH_WRITE = "E:\\web\\tomcat_7.0.27_8687\\webapps\\uploadfile\\";
    public final static String OFFICE_WEB_PATH_TEMP = "E:\\web\\tomcat_7.0.27_8687\\webapps\\tempfile\\";*/

    public final static String UPLOAD_CONFIG_FILE_NAME = "ConfigUpload";
    public final static String CONFIG_VIEDO_FILE_NAME = "ConfigVideo";

    public final static String TOMCAT_PATH = ConfigUtil.getConfigProp("TOMCAT_PATH", UPLOAD_CONFIG_FILE_NAME);//"D:\\java-develop\\apache-tomcat-7.0.53";
    public final static String XT_OFFICE_WEB_PATH_WRITE = TOMCAT_PATH + "\\webapps\\uploadfile\\";
    public final static String OFFICE_WEB_PATH_WRITE = TOMCAT_PATH + "\\webapps\\uploadfile\\";
    public final static String OFFICE_WEB_PATH_TEMP = TOMCAT_PATH + "\\webapps\\tempfile\\";

    public final static String TOMCAT_URL = ConfigUtil.getConfigProp("TOMCAT_URL", UPLOAD_CONFIG_FILE_NAME);//"http://202.111.175.224:8080";
    //public final static String XT_OFFICE_WEB_PATH_READ = "http://202.98.7.181:8687/uploadfile/";
    public final static String XT_OFFICE_WEB_PATH_READ = TOMCAT_URL + "/uploadfile/";
    //release config
    public final static String OFFICE_WEB_PATH_READ = TOMCAT_URL + "/tempfile/";
    public final static String PROJECT_WICKET_APPLICATION_NAME = "project.daren.com";
}
