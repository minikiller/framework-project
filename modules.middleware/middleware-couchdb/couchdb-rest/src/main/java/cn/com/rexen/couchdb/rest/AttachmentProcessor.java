package cn.com.rexen.couchdb.rest;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.couchdb.api.biz.ICouchdbService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.util.ObjectHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.lightcouch.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 处理附件，写入到couchdb
 */
public class AttachmentProcessor implements Processor {
    private ICouchdbService couchdbService;
    private JsonStatus jsonStatus = null;
    private ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());

    @Override
    public void process(Exchange exchange) throws Exception {
        try {
            HttpServletRequest request = ObjectHelper.cast(HttpServletRequest.class, exchange.getIn().getHeader(Exchange.HTTP_SERVLET_REQUEST));

            if (!ServletFileUpload.isMultipartContent(request)) {
                throw new RuntimeException("Invalid Multipart Content request!");
            }

            uploader.setHeaderEncoding("utf-8");

            ServletRequestContextWrapper wrapper = new ServletRequestContextWrapper(request);
            wrapper.setInputStream(exchange.getIn().getBody(InputStream.class));
            List<FileItem> items = uploader.parseRequest(wrapper);
            if (items.isEmpty()) {
                throw new RuntimeException("Invalid Multipart/form-data Content, file item is empty!");
            }

            FileItem fileItem = null;

            if (items.size() == 1) {
                fileItem = items.get(0);
            }

            Response response = null;

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            OutputStream out = new Base64OutputStream(stream);
            IOUtils.copy(fileItem.getInputStream(), out);

            String base64Str = stream.toString();
            fileItem.getInputStream().close();
            out.close();

            if (fileItem != null) {
                try {
                    String fileName = fileItem.getName();

                    response = couchdbService.addAttachment(Base64.encodeBase64String(fileItem.get()),
                            fileName, fileItem.getContentType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            jsonStatus = JsonStatus.successResult("上传文件成功！");
            exchange.getIn().setBody(jsonStatus);
            exchange.getIn().setHeader("Content-Type", "text/xml;charset=UTF-8");
        } catch (Exception e) {
            jsonStatus = JsonStatus.failureResult("上传文件失败！异常为{" + e.toString() + "}");
            exchange.getOut().setBody(jsonStatus);
            e.printStackTrace();
        }
    }

    public ICouchdbService getCouchdbService() {
        return couchdbService;
    }

    public void setCouchdbService(ICouchdbService couchdbService) {
        this.couchdbService = couchdbService;
    }


    public static final class ServletRequestContextWrapper extends ServletRequestContext {

        public InputStream inputStream;

        public ServletRequestContextWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public InputStream getInputStream() {
            return inputStream;
        }

        public void setInputStream(InputStream inputStream) {
            this.inputStream = inputStream;
        }
    }
}
