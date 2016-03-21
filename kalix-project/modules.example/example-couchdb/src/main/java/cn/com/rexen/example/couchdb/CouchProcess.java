package cn.com.rexen.example.couchdb;
import cn.com.rexen.couchdb.api.biz.ICouchdbAttachBeanService;
import org.apache.camel.Processor;
import org.apache.camel.Message;
import org.apache.camel.Exchange;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

/**
 * Created by sunlf on 2015/10/8.
 */
public class CouchProcess implements Processor {
    private ICouchdbAttachBeanService couchdbAttachBeanService;

    public void setCouchdbAttachBeanService(ICouchdbAttachBeanService couchdbAttachBeanService) {
        this.couchdbAttachBeanService = couchdbAttachBeanService;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Message message=exchange.getIn();
        FileItem  item = (FileItem) message.getBody();
        couchdbAttachBeanService.saveAttach(123,item);
        System.out.println(message);
    }
}
