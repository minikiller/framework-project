package cn.com.rexen.kalix.osgi.api;

import java.util.Map;

/**
 * Created by lenovo on 2015/12/2.
 */
public class BundleJsonStatus {
    private static BundleJsonStatus jsonStatus = new BundleJsonStatus();
    Boolean success = false;
    Boolean failure = false;
    Map<String, Boolean> appStatus = null;
    String msg;

    /**
     * 返回成功json状态
     *
     * @param msg
     * @return
     */
    public static BundleJsonStatus successResult(String msg) {
        jsonStatus.setMsg(msg);
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
    public static BundleJsonStatus failureResult(String msg) {
        jsonStatus.setMsg(msg);
        jsonStatus.setSuccess(false);
        jsonStatus.setFailure(true);
        return jsonStatus;
    }

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

    public Map<String, Boolean> getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Map<String, Boolean> appStatus) {
        this.appStatus = appStatus;
    }
}
