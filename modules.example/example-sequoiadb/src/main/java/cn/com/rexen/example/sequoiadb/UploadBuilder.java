package cn.com.rexen.example.jdbc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import javax.activation.DataHandler;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/2.
 */
public class UploadBuilder extends RouteBuilder{
    @Override
    public void configure() throws Exception {
//        getContext().getProperties().put("CamelJettyTempDir", "target");

        from("jetty://http://localhost:8188/test").process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                Message in = exchange.getIn();
//                assertEquals("Get a wrong attachement size", 1, in.getAttachments().size());
                // The file name is attachment id
                Map<String,DataHandler> attachements=in.getAttachments();
                for(Map.Entry<String, DataHandler> dataHandler:attachements.entrySet()){
//                    dataHandler.getValue().
                }
                DataHandler data = in.getAttachment("NOTICE.txt");

                /*assertNotNull("Should get the DataHandle NOTICE.txt", data);
                // This assert is wrong, but the correct content-type (application/octet-stream)
                // will not be returned until Jetty makes it available - currently the content-type
                // returned is just the default for FileDataHandler (for the implentation being used)
                //assertEquals("Get a wrong content type", "text/plain", data.getContentType());
                assertEquals("Got the wrong name", "NOTICE.txt", data.getName());

                assertTrue("We should get the data from the DataHandle", data.getDataSource()
                        .getInputStream().available() > 0);*/

                // The other form date can be get from the message header
                exchange.getOut().setBody(in.getHeader("comment"));
            }

        });
    }
}
