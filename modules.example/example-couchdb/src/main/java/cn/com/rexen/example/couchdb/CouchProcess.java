package cn.com.rexen.example.couchdb;
import org.apache.camel.Processor;
import org.apache.camel.Message;
import org.apache.camel.Exchange;
/**
 * Created by sunlf on 2015/10/8.
 */
public class CouchProcess implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Message message=exchange.getIn();
        System.out.println(message);
    }
}
