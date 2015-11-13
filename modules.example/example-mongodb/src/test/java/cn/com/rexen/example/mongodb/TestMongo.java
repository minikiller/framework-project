package cn.com.rexen.example.jdbc;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

/**
 * Created by sunlf on 2015/8/25.
 */
public class TestMongo extends CamelBlueprintTestSupport {


    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/camel-mongodb.xml";
    }

    @Test
    public void insert() throws Exception {
        /*CamelContext context=new DefaultCamelContext();
        context.addRoutes(createRoute());
        context.start();
        ProducerTemplate template= context.createProducerTemplate();*/
        TestMongoInsert testMongoInsert = new TestMongoInsert();
        testMongoInsert.insert();
//        template.sendBody("direct:insert","{\"fruits\": [\"apple\", \"banana\", \"papaya\"], \"veggie\": \"broccoli\", \"_id\": \"testInsertJsonString\"}");
//        template.send();
    }


}
