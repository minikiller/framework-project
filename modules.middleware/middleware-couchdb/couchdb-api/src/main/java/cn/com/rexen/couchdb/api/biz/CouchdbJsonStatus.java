package cn.com.rexen.couchdb.api.biz;


/**
 * Created by GISCYX on 2015/11/27.
 */
public class CouchdbJsonStatus  {
    private String attachmentId;
    private String attachmentRev;
    private String attachmentType;
    private long attachmentSize;
    private String attachmentName;
    private String attachmentPath;
    Boolean success = false;
    Boolean failure = false;
    String msg;

    private static CouchdbJsonStatus jsonStatus = new CouchdbJsonStatus();

    //    @ApiModelProperty(value = "an identifier", required = true)
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    //    @ApiModelProperty(value = "an identifier", required = true)
    public Boolean getFailure() {
        return failure;
    }

    public void setFailure(Boolean failure) {
        this.failure = failure;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回成功json状态
     *
     * @param msg
     * @return
     */
    public static CouchdbJsonStatus successResult(String msg,String id,String rev,String name,String type,long size) {
        jsonStatus.setMsg(msg);
        jsonStatus.setAttachmentId(id);
        jsonStatus.setAttachmentRev(rev);
        jsonStatus.setAttachmentType(type);
        jsonStatus.setAttachmentSize(size);
        jsonStatus.setAttachmentName(name);
        jsonStatus.setSuccess(true);
        jsonStatus.setFailure(false);
        return jsonStatus;
    }

    /**
     * 返回失败json状态
     *
     * @param msg
     * @return
     */
    public static CouchdbJsonStatus failureResult(String msg) {
        jsonStatus.setMsg(msg);
        jsonStatus.setAttachmentId("");
        jsonStatus.setAttachmentRev("");
        jsonStatus.setAttachmentType("");
        jsonStatus.setAttachmentSize(0);
        jsonStatus.setAttachmentName("");
        jsonStatus.setSuccess(false);
        jsonStatus.setFailure(true);
        return jsonStatus;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentRev() {
        return attachmentRev;
    }

    public void setAttachmentRev(String attachmentRev) {
        this.attachmentRev = attachmentRev;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public long getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(long attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
