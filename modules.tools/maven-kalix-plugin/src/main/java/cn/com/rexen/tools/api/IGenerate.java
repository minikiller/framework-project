package cn.com.rexen.tools.api;

import com.thoughtworks.qdox.model.JavaField;
import org.apache.maven.plugin.MojoExecutionException;

import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 */
public interface IGenerate {
    //创建java source目录
    void genJavaSource() throws MojoExecutionException;

    //创建resources目录
    void genResources();

    //重新设置attributes
    void setAttributes(Map<String, String> attributes);

    //获取实体类的fields
    List<JavaField> getClassFields() throws MojoExecutionException;
}
