package cn.com.rexen.couchdb.rest;

import cn.com.rexen.couchdb.api.biz.CouchdbJsonStatus;
import cn.com.rexen.couchdb.api.biz.ICouchdbService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.util.ObjectHelper;
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
    private ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());
    private CouchdbJsonStatus jsonStatus;

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

            //exchange.getIn().setHeader("Content-Type", "application/json;charset=utf-8");
            exchange.getIn().setHeader("Content-Type", "text/html;charset=utf-8");

            if (fileItem != null) {
                if(fileItem.getSize()>(10*1024*1024)){
                    jsonStatus = CouchdbJsonStatus.failureResult("文件过大（上限10MB）！");
                    exchange.getIn().setBody(jsonStatus);

                    return;
                }

                try {
                    String fileName = fileItem.getName();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    OutputStream out = new Base64OutputStream(stream);
                    IOUtils.copy(fileItem.getInputStream(), out);
                    String base64Str = stream.toString();
                    fileItem.getInputStream().close();
                    out.close();

                    response = couchdbService.addAttachment(base64Str,
                            fileName, fileItem.getContentType());
                    jsonStatus = CouchdbJsonStatus.successResult("上传文件成功！", response.getId(), response.getRev(), fileName, fileItem.getContentType(), fileItem.getSize());
                    jsonStatus.setAttachmentPath(couchdbService.getDBUrl()+response.getId()+"/"+fileName);
                    exchange.getIn().setBody(jsonStatus);
                } catch (Exception e) {
                    e.printStackTrace();
                    jsonStatus = CouchdbJsonStatus.failureResult("上传文件失败！异常为{" + e.toString() + "}");
                }
            }



        } catch (Exception e) {
            jsonStatus = CouchdbJsonStatus.failureResult("上传文件失败！异常为{" + e.toString() + "}");
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
