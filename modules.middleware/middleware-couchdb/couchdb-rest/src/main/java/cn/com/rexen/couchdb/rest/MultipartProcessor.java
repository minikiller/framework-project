package cn.com.rexen.couchdb.rest;

import cn.com.rexen.core.util.Assert;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.util.ObjectHelper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * 处理文件上传的camel的processor
 */
public class MultipartProcessor implements Processor {

    private ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpServletRequest request = ObjectHelper.cast(HttpServletRequest.class,
                exchange.getIn().getHeader(Exchange.HTTP_SERVLET_REQUEST));
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new RuntimeException("Invalid Multipart Content request!");
        }
        ServletRequestContextWrapper wrapper = new ServletRequestContextWrapper(request);
        //读取必须输入的mainId属性
        String main_id = request.getParameter(Const.MAIN_ID);
        Assert.notNull(main_id, "[mainId] - this argument is required; it must not be null");
        exchange.getOut().setHeader(Const.MAIN_ID, main_id);

        wrapper.setInputStream(exchange.getIn().getBody(InputStream.class));
        List<FileItem> items = uploader.parseRequest(wrapper);
        if (items.isEmpty()) {
            throw new RuntimeException("Invalid Multipart/form-data Content, file item is empty!");
        }

        for (FileItem item : items) {
            if (!item.isFormField()) {
                prepareResponseMessage(exchange, item);
                exchange.getOut().setBody(item);
            } else {
                exchange.getOut().setHeader(item.getFieldName(), item.getString("UTF-8"));
            }
        }

    }

    private void prepareResponseMessage(Exchange exchange, FileItem storageItem) {
        exchange.getOut().setHeader(Exchange.FILE_CONTENT_TYPE, storageItem.getContentType());
        exchange.getOut().setHeader(Exchange.FILE_NAME, storageItem.getName());
        exchange.getOut().setHeader(Exchange.FILE_LENGTH, storageItem.getSize());
    }

    public static final class ServletRequestContextWrapper extends ServletRequestContext {

        public InputStream inputStream;

        public ServletRequestContextWrapper(HttpServletRequest request) {
            super(request);
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public InputStream getInputStream() {
            return inputStream;
        }
    }
}
