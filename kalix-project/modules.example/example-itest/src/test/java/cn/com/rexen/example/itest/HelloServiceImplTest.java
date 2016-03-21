package cn.com.rexen.example.itest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.service.cm.ConfigurationAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.OptionUtils.combine;

/**
 * HelloServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮ���� 10, 2015</pre>
 */
@RunWith(PaxExam.class)
public class HelloServiceImplTest extends BaseTest {

    private static Logger LOG = LoggerFactory.getLogger(HelloServiceImplTest.class);

    @Inject
    private HelloService helloService;

    @Inject
    private ConfigurationAdmin configAdminService;

    @Configuration
    public Option[] config() {

        return options(
                combine(baseConfig(),mavenBundle()
                        .groupId("cn.com.rexen.kalix.example")
                        .artifactId("example-itest")
                        .version("1.0.0-SNAPSHOT").start()));
    }

    /**
     * Method: getMessage()
     */
    @Test
    public void testGetMessage() throws Exception {
        assertEquals("Hello Pax!", helloService.getMessage());
    }

    @Test
    public void testConfigAdminService() throws Exception {
        LOG.info("starting test");
        org.osgi.service.cm.Configuration configuration = configAdminService.createFactoryConfiguration("de.nierbeck.microservices.karaf.calculator");

        Dictionary<String, Object> dictionary = configuration.getProperties();
        if (dictionary == null) {
            dictionary = new Hashtable<String, Object>();
        }

        dictionary.put("institute", "JavaBank");
        dictionary.put("fee", "1500");
        LOG.info("updating configuration");

        configuration.setBundleLocation(null);
        configuration.update(dictionary);
    }

} 
