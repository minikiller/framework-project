package cn.com.rexen.couchdb.rest;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.couchdb.api.biz.ICouchdbAttachBeanService;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.fileupload.FileItem;

/**
 * 处理附件，写入到couchdb
 */
public class AttachmentProcessor implements Processor {
    private ICouchdbAttachBeanService couchdbAttachBeanService;
    private JsonStatus jsonStatus = null;

    public void setCouchdbAttachBeanService(ICouchdbAttachBeanService couchdbAttachBeanService) {
        this.couchdbAttachBeanService = couchdbAttachBeanService;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        try {
            Message message = exchange.getIn();
            FileItem item = (FileItem) message.getBody();
            String main_id = exchange.getIn().getHeader(Const.MAIN_ID, String.class);
            Assert.notNull(main_id);
            couchdbAttachBeanService.saveAttach(new Long(main_id), item);
            jsonStatus = JsonStatus.successResult("上传文件成功！");
            exchange.getIn().setBody(jsonStatus);
        } catch (Exception e) {
            jsonStatus = JsonStatus.failureResult("上传文件失败！异常为{" + e.toString() + "}");
            exchange.getOut().setBody(jsonStatus);
            e.printStackTrace();
        }

//        System.out.println(message);
    }
}
