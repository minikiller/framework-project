package cn.com.rexen.tools.api;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Created by sunlf on 2015/9/18.
 */
public interface IGenerate {
    //创建java source目录
    void genJavaSource() throws MojoExecutionException;

    //创建resources目录
    void genResources();

}
