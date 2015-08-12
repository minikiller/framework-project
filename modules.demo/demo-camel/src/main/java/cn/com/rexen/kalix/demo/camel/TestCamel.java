package cn.com.rexen.kalix.demo.camel;

import org.apache.camel.*;
import org.apache.camel.component.file.FileComponent;
import org.apache.camel.component.log.LogComponent;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @类描述：测试camel
 * @创建人： sunlingfeng
 * @创建时间：2014/11/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class TestCamel {
    private CamelContext camel;

    public TestCamel() throws Exception {
        // create the camel context that is the "heart" of Camel
        camel = new DefaultCamelContext();

        // add the log component
        camel.addComponent("log", new LogComponent());
        //camel.addComponent("http",new HttpCo);


        // start Camel
        camel.start();
    }

    private void sendToCamelLog(String name) {
        try {
            // get the log component
            Component component = camel.getComponent("log");

            // create an endpoint and configure it.
            // Notice the URI parameters this is a common practice in Camel to configure
            // endpoints based on URI.
            // com.mycompany.part2 = the log category used. Will log at INFO level as default
            Endpoint endpoint = component.createEndpoint("log:com.mycompany.part2");

            // create an Exchange that we want to send to the endpoint
            Exchange exchange = endpoint.createExchange();
            // set the in message payload (=body) with the name parameter
            exchange.getIn().setBody(name);

            // now we want to send the exchange to this endpoint and we then need a producer
            // for this, so we create and start the producer.
            Producer producer = endpoint.createProducer();
            producer.start();
            // process the exchange will send the exchange to the log component, that will process
            // the exchange and yes log the payload
            producer.process(exchange);

            // stop the producer, we want to be nice and cleanup
            producer.stop();


        } catch (Exception e) {
            // we ignore any exceptions and just rethrow as runtime
            throw new RuntimeException(e);

        }
    }

    private void sendToCamelFile(String incidentId, String name) {
        try {
            // get the file component
            Component component = camel.getComponent("file");

            // create an endpoint and configure it.
            // Notice the URI parameters this is a common pratice in Camel to configure
            // endpoints based on URI.
            // file://target instructs the base folder to output the files. We put in the target folder
            // then its actumatically cleaned by mvn clean
            Endpoint endpoint = component.createEndpoint("file://target");

            // create an Exchange that we want to send to the endpoint
            Exchange exchange = endpoint.createExchange();
            // set the in message payload (=body) with the name parameter
            exchange.getIn().setBody(name);

            // now a special header is set to instruct the file component what the output filename
            // should be
            exchange.getIn().setHeader(FileComponent.FILE_EXCHANGE_FILE, "incident-" + incidentId + ".txt");

            // now we want to send the exchange to this endpoint and we then need a producer
            // for this, so we create and start the producer.
            Producer producer = endpoint.createProducer();
            producer.start();
            // process the exchange will send the exchange to the file component, that will process
            // the exchange and yes write the payload to the given filename
            producer.process(exchange);

            // stop the producer, we want to be nice and cleanup
            producer.stop();
        } catch (Exception e) {
            // we ignore any exceptions and just rethrow as runtime
            throw new RuntimeException(e);
        }
    }


}
