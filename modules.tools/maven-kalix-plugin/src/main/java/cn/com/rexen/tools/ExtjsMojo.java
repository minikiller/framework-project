package cn.com.rexen.tools;

import cn.com.rexen.tools.api.IGenerate;
import cn.com.rexen.tools.impl.*;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaType;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;
import java.util.List;

/**
 * Created by sunlf on 2015/9/18.
 *
 * @goal extjs
 * @phase compile
 * @threadSafe
 */
public class ExtjsMojo extends AbstractBaseKalixMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.docBuilder = new JavaProjectBuilder();
        for (String r : sources) {
            docBuilder.addSourceTree(new File(r));
        }
        // first, find input directory and files it contains
        if (!inputDir.exists()) {
            throw new MojoExecutionException("Input directory '" + inputDir.getAbsolutePath() + "' does not exist");
        }

        //create extjs code generate
        IGenerate extjsGenerate = new ExtjsGenerateImpl(attributes, inputDir, outputDir);

        String result = getModelFields(extjsGenerate);
        attributes.put("ModelFields",result);
        result = getValidators(extjsGenerate);
        attributes.put("Validators",result);
        result = getGridItems(extjsGenerate);
        attributes.put("GridItems",result);
        result = getSearchFormItems(extjsGenerate);
        attributes.put("SearchFormItems",result);
        result = getViewWindowItems(extjsGenerate);
        attributes.put("ViewWindowItems",result);
        result = getWindowItems(extjsGenerate);
        attributes.put("WindowItems",result);

        extjsGenerate.setAttributes(attributes);

        extjsGenerate.genJavaSource();
    }

    private String getModelFields(IGenerate extjsGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("");
        List<JavaField> fields = extjsGenerate.getClassFields();
        String fieldName;
        String fieldType;//获取字段类型
        DocletTag fieldTag;//@describe
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldType = field.getType().getValue();
            fieldTag = field.getTagByName("describe"); // @describe

            resultBuffer.append("\t{\r\n");
            resultBuffer.append("\tname:'" + fieldName + "',\r\n");
            if(fieldType.equals("String")) {
                resultBuffer.append("\ttype: 'string'\r\n");
            }else if(fieldType.equals("Date")){
                resultBuffer.append("\ttype: 'date'\r\n");
            }else if(fieldType.equals("List")){
                resultBuffer.append("\ttype: 'list'\r\n");
            }else if(fieldType.equals("Integer") || fieldType.equals("int")){
                resultBuffer.append("\ttype: 'int'\r\n");
            }else {
                resultBuffer.append("\ttype: 'object'\r\n");
            }

            resultBuffer.append("\t},");
        }
        resultBuffer.delete(resultBuffer.length() -1, resultBuffer.length());
        return resultBuffer.toString();
    }
    private String getValidators(IGenerate extjsGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("\tvalidators: {\r\n");
        List<JavaField> fields = extjsGenerate.getClassFields();
        String fieldName;
        DocletTag fieldTag,fieldValidatorTag;//@describe,@validator
        int a;
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldTag = field.getTagByName("describe"); // @describe
            fieldValidatorTag = field.getTagByName("validator"); // @validator
            if(fieldValidatorTag != null){
                resultBuffer.append("\t\t"+fieldName);
                resultBuffer.append(":[{\r\n");
                resultBuffer.append("\t\t\ttype:'" + "presence" + "',\r\n");
                resultBuffer.append("\t\t\tmessage:'" + fieldTag.getValue() + fieldValidatorTag.getValue() + "'\r\n");
                resultBuffer.append("\t\t}],\r\n");
            }
        }
        resultBuffer.delete(resultBuffer.length() - 3, resultBuffer.length());
        resultBuffer.append("\r\n\t}");
        return resultBuffer.toString();
    }
    private String getGridItems(IGenerate extjsGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("");
        List<JavaField> fields = extjsGenerate.getClassFields();
        String fieldName;
        DocletTag fieldTag,fieldValidatorTag;//@describe,@validator
        int a;
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldTag = field.getTagByName("describe"); // @describe
            resultBuffer.append("\t{\r\n");
            resultBuffer.append("\t\ttext:'" + fieldTag.getValue() + "',\r\n");
            resultBuffer.append("\t\tdataIndex:'" + fieldName + "'");
            if(field.getType().getValue().equals("Date")){
                resultBuffer.append(",\r\n");
                resultBuffer.append("\t\txtype:'datecolumn',\r\n");
                resultBuffer.append("\t\tformat:'Y-m-d'");
            }
            resultBuffer.append("\r\n\t},\r\n");
        }
        return resultBuffer.toString();
    }
    private String getSearchFormItems(IGenerate extjsGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("");
        List<JavaField> fields = extjsGenerate.getClassFields();
        String fieldName;
        DocletTag fieldTag,fieldValidatorTag;//@describe,@validator
        int a;
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldTag = field.getTagByName("describe"); // @describe
            resultBuffer.append("\t{\r\n");
            resultBuffer.append("\t\txtype:'" + "textfield" + "',\r\n");
            resultBuffer.append("\t\tfieldLabel:'" + fieldTag.getValue() + "',\r\n");
            resultBuffer.append("\t\tlabelAlign:'right',\r\n");
            resultBuffer.append("\t\tlabelWidth:60,\r\n");
            resultBuffer.append("\t\twidth:200,\r\n");
            resultBuffer.append("\t\tname:'" + fieldName + "'\r\n");
            resultBuffer.append("\t}\r\n");
        }
        return resultBuffer.toString();
    }
    private String getViewWindowItems(IGenerate extjsGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("\t\t{\r\n");
        List<JavaField> fields = extjsGenerate.getClassFields();
        String fieldName;
        DocletTag fieldTag,fieldValidatorTag;//@describe,@validator
        int a;
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldTag = field.getTagByName("describe"); // @describe
            fieldValidatorTag = field.getTagByName("validator"); // @validator
            //if(fieldValidatorTag != null){
                resultBuffer.append("\t\tfieldLabel:'" + fieldTag.getValue() + "',\r\n");
                resultBuffer.append("\t\tallowBlank:false,\r\n");
                if(field.getType().equals("Date")){
                    resultBuffer.append("\t\txtype:false,\r\n");
                    resultBuffer.append("\t\tformat: 'Y-m-d',\r\n");
                }
                resultBuffer.append("\t\tbind: {\r\n");
                resultBuffer.append("\t\t\tvalue: '{rec." +fieldName+ "}'\r\n");
                resultBuffer.append("\t\t},\r\n");
            //}
        }
        resultBuffer.delete(resultBuffer.length() - 3,resultBuffer.length());
        resultBuffer.append("\r\n\t}");
        return resultBuffer.toString();
    }
    private String getWindowItems(IGenerate extjsGenerate) throws MojoExecutionException{
        return getViewWindowItems(extjsGenerate);
    }
}
