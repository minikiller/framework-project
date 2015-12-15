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

/**
 * Created by sunlf on 2015/12/12.
 */
@RunWith(PaxExam.class)
public class AdminDaoServiceTest extends BaseTest {
    @Inject
    private IUserBeanDao userBeanDao;

    @Override
    @Configuration
    public Option[] config() {
        Option[] options = super.config();
        List<Option> ops = new ArrayList();//
        for (Option opt : options) {
            ops.add(opt);
        }
        Option entityOption = mavenBundle()
                .groupId("cn.com.rexen.kalix.admin")
                .artifactId("admin-entities")
                .version("1.0.0-SNAPSHOT").start();
        Option dtoOption = mavenBundle()
                .groupId("cn.com.rexen.kalix.admin")
                .artifactId("admin-dto")
                .version("1.0.0-SNAPSHOT").start();
        Option apiOption = mavenBundle()
                .groupId("cn.com.rexen.kalix.admin")
                .artifactId("admin-api")
                .version("1.0.0-SNAPSHOT").start();
        Option daoOption = mavenBundle()
                .groupId("cn.com.rexen.kalix.admin")
                .artifactId("admin-persist-jpa")
                .version("1.0.0-SNAPSHOT").start();

        ops.add(entityOption);
        ops.add(dtoOption);
        ops.add(apiOption);
        ops.add(daoOption);
        return ops.toArray(new Option[0]);
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
