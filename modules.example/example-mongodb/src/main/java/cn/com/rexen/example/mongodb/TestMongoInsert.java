package cn.com.rexen.example.sequoiadb;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by sunlf on 2015/8/25.
 */
public class TestMongoInsert {

    /* @EndpointInject(uri = "direct:insert", context="mongodb-camel")
     private ProducerTemplate template;
 */
//    @Produce
    private ProducerTemplate template;

    public void setTemplate(ProducerTemplate template) {
        this.template = template;
    }

    public void insert() throws Exception {
       /* CamelContext context=new DefaultCamelContext();
        *//*context.addRoutes(createRoute());
        context.start();*//*
        ProducerTemplate template= context.createProducerTemplate();*/
//        template.requestBodyAndHeader("direct:insert", "{\"fruits\": [\"apple123\", \"banana123\", \"papaya\"], \"veggie\": \"broccoli\", \"_id\": \"testInsertJsonString1234\"}", "CamelMongoDbCollection", "hello");

        template.requestBodyAndHeader("direct:insert", null, "CamelMongoDbCollection", "hello");
//        template.requestBodyAndHeader("direct:insert", "{\"_id\": \"testInsertJsonString1234\"}", "CamelMongoDbCollection","hello");

//        template.sendBody("test");
//        template.send();
    }

    private RoutesBuilder createRoute() {
        return new RouteBuilder() {
            public void configure() throws Exception {
                from("direct:insert").to("mongodb://mongo?database={{mongodb.database}}&collection={{metadata.collection}}&operation=insert");
            }
        };

    }
}
