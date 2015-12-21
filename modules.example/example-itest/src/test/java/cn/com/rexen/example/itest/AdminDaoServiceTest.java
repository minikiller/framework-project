package cn.com.rexen.example.itest;

import cn.com.rexen.admin.api.dao.IUserBeanDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.OptionUtils.combine;

/**
 * Created by sunlf on 2015/12/12.
 */
@RunWith(PaxExam.class)
public class AdminDaoServiceTest extends BaseTest {
    @Inject
    private IUserBeanDao userBeanDao;

    @Configuration
    public Option[] config() {
        return options(
                combine(baseConfig(),mavenBundle()
                        .groupId("cn.com.rexen.kalix.admin")
                        .artifactId("admin-entities")
                        .version("1.0.0-SNAPSHOT").start(),
                        mavenBundle()
                                .groupId("cn.com.rexen.kalix.admin")
                                .artifactId("admin-dto")
                                .version("1.0.0-SNAPSHOT").start(),
                        mavenBundle()
                                .groupId("cn.com.rexen.kalix.admin")
                                .artifactId("admin-api")
                                .version("1.0.0-SNAPSHOT").start(),
                        mavenBundle()
                                .groupId("cn.com.rexen.kalix.admin")
                                .artifactId("admin-persist-jpa")
                                .version("1.0.0-SNAPSHOT").start()));
        }

    /**
     * Method: getMessage()
     */
    @Test
    public void testInsertUser() throws Exception {
        assertNotNull(userBeanDao);
        //assertEquals("Hello Pax!", helloService.getMessage());
    }

}
