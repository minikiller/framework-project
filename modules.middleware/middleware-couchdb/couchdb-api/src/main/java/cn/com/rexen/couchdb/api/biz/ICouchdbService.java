package cn.com.rexen.couchdb.api.biz;

import cn.com.rexen.couchdb.entities.CouchdbAttachBean;
import org.lightcouch.Attachment;
import org.lightcouch.Document;
import org.lightcouch.Response;

/**
 * @类描述：
 * @创建人：xukexin
 * @创建时间：2014/10/31 13:18
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface ICouchdbService {
    /**
     * 添加附件到couchdb数据库
     *
     * @param value
     * @param key
     * @param type
     * @return
     */
    Response addAttachment(String value, String key, String type);

    /**
     * 移除附件
     *
     * @param couchdbAttachBean
     * @return
     */
    boolean deleteAttach(CouchdbAttachBean couchdbAttachBean);

    /**
     * 修改附件内容
     *
     * @param couchdbAttachBean
     * @param value
     * @param type
     * @return
     */
    String updateAttach(CouchdbAttachBean couchdbAttachBean, String value, String type);

    /**
     * 获取文档对象
     *
     * @param couchdbAttachBean
     * @return
     */
    Document getDocumentByIdAndRev(CouchdbAttachBean couchdbAttachBean);

    /**
     * 获取附件对象
     *
     * @param couchdbAttachBean
     * @return
     */
    Attachment getAttachmentByIdAndRev(CouchdbAttachBean couchdbAttachBean);

}
