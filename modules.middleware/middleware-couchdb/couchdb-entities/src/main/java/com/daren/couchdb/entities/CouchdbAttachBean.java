package cn.com.rexen.couchdb.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @类描述：主表和附件关联couchdb管理
 * @创建人：xukexin
 * @创建时间：2014/10/29
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "couchdb_attach")
public class CouchdbAttachBean extends PersistentEntity {

    private long mainId;                //主表id
    private String couchdbAttachId;     //couchdb中的附件id
    private String couchdbAttachRev;    //couchdb中的附件版本号
    private String attachName;          //附件名称
    private String attachType;          //附件类型
    private long attachSize;            //附件大小
    private String attachPath;          //附件路径
    private String otherName;           //别名

    public CouchdbAttachBean() {

    }

    public long getMainId() {
        return mainId;
    }

    public void setMainId(long mainId) {
        this.mainId = mainId;
    }

    public String getCouchdbAttachId() {
        return couchdbAttachId;
    }

    public void setCouchdbAttachId(String couchdbAttachId) {
        this.couchdbAttachId = couchdbAttachId;
    }

    public String getCouchdbAttachRev() {
        return couchdbAttachRev;
    }

    public void setCouchdbAttachRev(String couchdbAttachRev) {
        this.couchdbAttachRev = couchdbAttachRev;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public long getAttachSize() {
        return attachSize;
    }

    public void setAttachSize(long attachSize) {
        this.attachSize = attachSize;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }
}
