package cn.com.rexen.example.couchdb;

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
 * Created by jianghailong on 15/6/24.
 */
public class MultipartUploaderProcessor implements Processor {

    private ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());

    @Override
    public void process(Exchange exchange) throws Exception {
        HttpServletRequest request = ObjectHelper.cast(HttpServletRequest.class,
                exchange.getIn().getHeader(Exchange.HTTP_SERVLET_REQUEST));
        if (!ServletFileUpload.isMultipartContent(request)) {
            // TODO no multipart/form-data uploader
        }
        ServletRequestContextWrapper wrapper = new ServletRequestContextWrapper(request);
        wrapper.setInputStream(exchange.getIn().getBody(InputStream.class));
        List<FileItem> items = uploader.parseRequest(wrapper);
        if (items.isEmpty()) {
            // TODO no multipart/form-data uploader
        }

        for (FileItem item : items) {
            if (!item.isFormField()) {
                prepareResponseMessage(exchange, item);
//                exchange.getOut().setHeader("fileItem",item);
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
