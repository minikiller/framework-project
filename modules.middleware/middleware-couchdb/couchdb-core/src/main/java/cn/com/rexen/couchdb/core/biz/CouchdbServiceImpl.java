package cn.com.rexen.couchdb.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.util.ConfigUtil;
import cn.com.rexen.couchdb.api.biz.ICouchdbService;
import org.lightcouch.Attachment;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Document;
import org.lightcouch.Response;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class CouchdbServiceImpl implements ICouchdbService {
    private final CouchDbClient dbClient;
    private String db_name = (String) ConfigUtil.getConfigProp("DB_NAME", "CouchDBConfig");
    private String protocol = (String) ConfigUtil.getConfigProp("PROTOCOL", "CouchDBConfig");
    private String ip = (String) ConfigUtil.getConfigProp("IP", "CouchDBConfig");
    private int port = Integer.parseInt((String) ConfigUtil.getConfigProp("PORT", "CouchDBConfig"));
    private String user = (String) ConfigUtil.getConfigProp("USER", "CouchDBConfig");
    private String password = (String) ConfigUtil.getConfigProp("PASSWORD", "CouchDBConfig");

    public CouchdbServiceImpl() {
        dbClient = new CouchDbClient(db_name, true, protocol, ip, port, user, password);
    }

    @Override
    public Response addAttachment(String value, String key, String type) {
        Attachment attachment = new Attachment();
        Document document = new Document();
        Response response = null;
        try {
            attachment.setContentType(type);
            attachment.setData(value);
            document.addAttachment(key, attachment);
            response = dbClient.save(document);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 移除附件
     *
     * @return
     */
    @Override
    public JsonStatus deleteAttach(String id, String rev) {
        Response response = null;

        try{
            response = dbClient.remove(id, rev);

            return JsonStatus.successResult("");
        }catch (Exception e){
            e.printStackTrace();

            return JsonStatus.failureResult("");

        }
    }

    @Override
    public String getDBUrl() {
        return dbClient.getDBUri().toString();
    }

//    @Override
//    public String updateAttach(CouchdbAttachBean couchdbAttachBean, String value, String type) {
//        Response response = new Response();
//        try {
//
//            Document document = getDocumentByIdAndRev(couchdbAttachBean);
//            Attachment attachment = getAttachmentFromDocument(couchdbAttachBean, document);
//            attachment.setData(value);
//            attachment.setContentType(type);
//            document.addAttachment(couchdbAttachBean.getOtherName(), attachment);
//            dbClient.update(document);   } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return response.getRev();
//    }
//
//    @Override
//    public Document getDocumentByIdAndRev(CouchdbAttachBean couchdbAttachBean) {
//        Document document = new Document();
//        try {
//            document = dbClient.find(Document.class, couchdbAttachBean.getCouchdbAttachId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return document;
//    }
//
//    @Override
//    public Attachment getAttachmentByIdAndRev(CouchdbAttachBean couchdbAttachBean) {
//        return getAttachmentFromDocument(couchdbAttachBean, getDocumentByIdAndRev(couchdbAttachBean));
//    }
//
//    /**
//     * 根据Document获取Attachment
//     *
//     * @param couchdbAttachBean
//     * @param document
//     * @return
//     */
//    private Attachment getAttachmentFromDocument(CouchdbAttachBean couchdbAttachBean, Document document) {
//        Attachment attachment = new Attachment();
//        if (document != null) {
//            Map<String, Attachment> map = document.getAttachments();
//            attachment = map.get(couchdbAttachBean.getOtherName());
//        }
//        return attachment;
//    }

}
