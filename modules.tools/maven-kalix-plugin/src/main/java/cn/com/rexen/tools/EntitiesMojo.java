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
 * @goal entities
 * @phase compile
 * @threadSafe
 */
public class EntitiesMojo extends AbstractBaseKalixMojo {

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

        //create entities code generate
        IGenerate entitiesGenerate = new EntitiesGenerateImpl(attributes, inputDir, outputDir);
        String result = getSetCreate(entitiesGenerate);
        attributes.put("classBody",result);

        entitiesGenerate.setAttributes(attributes);

        entitiesGenerate.genJavaSource();

    }

    private String getSetCreate(IGenerate entitiesGenerate) throws MojoExecutionException{
        StringBuffer resultBuffer = new StringBuffer("");
        List<JavaField> fields = entitiesGenerate.getClassFields();
        String fieldName;
        JavaType fieldType;//获取字段类型
        DocletTag fieldTag;//describe
        for (JavaField field : fields){
            fieldName = field.getName();
            fieldType = field.getType();
            fieldTag = field.getTagByName("describe"); // @describe


            resultBuffer.append("\t/**\r\n\t*@describe " + fieldTag.getValue() + "\r\n\t*/\r\n");
            resultBuffer.append("\tprivate " + fieldType.getValue() + " " + fieldName + ";\r\n");

            //getter
            if(fieldType.getValue().equals("boolean")) {
                resultBuffer.append("\tpublic " + fieldType.getValue() + " is" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            }else{
                resultBuffer.append("\tpublic " + fieldType.getValue() + " get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            }
            resultBuffer.append("(){\r\n");
            resultBuffer.append("\t\treturn this." + fieldName + ";\r\n");
            resultBuffer.append("\t}\r\n\r\n");

            //setter
            resultBuffer.append("\tpublic void set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            resultBuffer.append("(" + fieldType.getValue() + " " + fieldName + ") {\r\n");
            resultBuffer.append("\t\tthis." + fieldName + " = " + fieldName + ";\r\n");
            resultBuffer.append("\t}\r\n\r\n");
        }
        return resultBuffer.toString();
    }
}
