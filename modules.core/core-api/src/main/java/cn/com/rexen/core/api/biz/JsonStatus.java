package cn.com.rexen.core.api.biz;

/**
 * Created by sunlf on 2015/7/3.
 */
public class JsonStatus {
    Boolean success = false;
    Boolean failure = false;
    String msg;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

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
}
