package cn.com.rexen.tools;

import cn.com.rexen.tools.api.IGenerate;
import cn.com.rexen.tools.impl.ApiGenerateImpl;
import cn.com.rexen.tools.impl.EntitiesGenerateImpl;
import com.thoughtworks.qdox.JavaDocBuilder;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 *
 * @goal testing
 * @phase compile
 * @threadSafe
 */
public class KalixMojo extends AbstractMojo {
    /**
     * @parameter expression="${project}"
     * @required
     * @readonly
     * @since 1.0
     */
    MavenProject project;
    /**
     * Sources
     *
     * @parameter
     * @required
     */
    List<String> sources;
    /**
     * @parameter default-value="target/generated-sources/kalix"
     * @required
     */
    File outputDir;
    JavaDocBuilder docBuilder;
    /**
     * Input root directory
     *
     * @parameter expression="${stringtemplate.inputDir}"
     * @required
     */
    private File inputDir;

    /**
     * We can also define attributes for ST to use. These are defined as
     * a Map in pom.xml
     *
     * @parameter
     */
    private Map<String, String> attributes;


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
        IGenerate apiGenerate = new ApiGenerateImpl(attributes, inputDir, outputDir);
        apiGenerate.genJavaSource();

        IGenerate entitiesGenerate = new EntitiesGenerateImpl(attributes, inputDir, outputDir);
        entitiesGenerate.genJavaSource();
    }
}