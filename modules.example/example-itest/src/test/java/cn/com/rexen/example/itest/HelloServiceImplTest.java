package cn.com.rexen.example.itest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;

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

    @Override
    @Configuration
    public Option[] config() {
        Option[] options = super.config();
        List<Option> ops = new ArrayList();//
        Option option = mavenBundle()
                .groupId("cn.com.rexen.kalix.example")
                .artifactId("example-itest")
                .version("1.0.0-SNAPSHOT").start();
        for (Option opt : options) {
            ops.add(opt);
        }
        ops.add(option);
        return ops.toArray(new Option[0]);
    }

    /**
     * Method: getMessage()
     */
    @Test
    public void testGetMessage() throws Exception {
        assertEquals("Hello Pax!", helloService.getMessage());
    }


} 
