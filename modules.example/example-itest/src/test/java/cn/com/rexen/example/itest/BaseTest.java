package cn.com.rexen.example.itest;

import org.ops4j.pax.exam.ConfigurationManager;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.cm.ConfigurationAdminOptions;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.ops4j.pax.exam.options.MavenUrlReference;

import java.io.File;

import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

/**
 * Created by sunlf on 2015/12/11.
 * <groupId>cn.com.rexen.tools</groupId>
 <artifactId>assembly</artifactId>
 */
public abstract class BaseTest {
    public Option[] config() {
        MavenArtifactUrlReference karafUrl = maven()
                .groupId("cn.com.rexen.tools")
                .artifactId("assembly")
                .version("1.0.0-SNAPSHOT")
                .type("zip");//
        /*MavenArtifactUrlReference karafUrl = maven()
                .groupId("org.apache.karaf")
                .artifactId("apache-karaf")
                .version(karafVersion())
                .type("zip");*/

        MavenUrlReference karafStandardRepo = maven()
                .groupId("org.apache.karaf.features")
                .artifactId("standard")
                .version(karafVersion())
                .classifier("features")
                .type("xml");
        MavenUrlReference kalixRepo = maven()
                .groupId("cn.com.rexen.kalix")
                .artifactId("karaf-features")
                .version("1.0.0-SNAPSHOT")
                .classifier("features")
                .type("xml");
        return new Option[]{
//                KarafDistributionOption.debugConfiguration("5005", true),
                karafDistributionConfiguration()
                        .frameworkUrl(karafUrl)
                        .unpackDirectory(new File("target", "exam"))
                        .useDeployFolder(false),
                keepRuntimeFolder(),
//                configureConsole().ignoreLocalConsole(),
                features(karafStandardRepo, "wrap"),
                features(kalixRepo, "kalix"),
//                add datasource
                ConfigurationAdminOptions.factoryConfiguration("org.ops4j.datasource-kalix")
                        .put("osgi.jdbc.driver.name", "PostgreSQL JDBC Driver-pool-xa")
                        .put("serverName", "localhost")
                        .put("databaseName", "test")
                        .put("portNumber", "5432")
                        .put("user", "postgres")
                        .put("password", "123456")
                        .put("dataSourceName", "jdbc/ds")
                        .asOption()
        };
    }

    public static String karafVersion() {
        ConfigurationManager cm = new ConfigurationManager();
        String karafVersion = cm.getProperty("pax.exam.karaf.version", "4.0.3");
        return karafVersion;
    }
}
