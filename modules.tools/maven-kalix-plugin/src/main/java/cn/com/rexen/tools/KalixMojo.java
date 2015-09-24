package cn.com.rexen.tools;

import cn.com.rexen.tools.api.IGenerate;
import cn.com.rexen.tools.impl.*;
import com.thoughtworks.qdox.JavaDocBuilder;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import java.io.File;

/**
 * Created by sunlf on 2015/9/18.
 *
 * @goal create-all
 * @phase compile
 * @threadSafe
 */
public class KalixMojo extends AbstractBaseKalixMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.docBuilder = new JavaDocBuilder();
        for (String r : sources) {
            docBuilder.addSourceTree(new File(r));
        }
        // first, find input directory and files it contains
        if (!inputDir.exists()) {
            throw new MojoExecutionException("Input directory '" + inputDir.getAbsolutePath() + "' does not exist");
        }
        //create api code generate
        IGenerate apiGenerate = new ApiGenerateImpl(attributes, inputDir, outputDir);
        apiGenerate.genJavaSource();
        //create entities code generate
        IGenerate entitiesGenerate = new EntitiesGenerateImpl(attributes, inputDir, outputDir);
        entitiesGenerate.genJavaSource();
        //create dao code generate
        IGenerate daoGenerate = new DaoGenerateImpl(attributes, inputDir, outputDir);
        daoGenerate.genJavaSource();
        //create core code generate
        IGenerate coreGenerate = new CoreGenerateImpl(attributes, inputDir, outputDir);
        coreGenerate.genJavaSource();
        //create rest code generate
        IGenerate restGenerate = new RestGenerateImpl(attributes, inputDir, outputDir);
        restGenerate.genJavaSource();
        //create web code generate
        IGenerate webGenerate = new WebGenerateImpl(attributes, inputDir, outputDir);
        webGenerate.genJavaSource();
        //create extjs code generate
        IGenerate extjsGenerate = new ExtjsGenerateImpl(attributes, inputDir, outputDir);
        extjsGenerate.genJavaSource();
    }
}
