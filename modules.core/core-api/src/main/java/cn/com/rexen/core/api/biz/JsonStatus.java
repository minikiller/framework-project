package cn.com.rexen.core.api.biz;


//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * Created by sunlf on 2015/7/3.
 */
//@ApiModel(description = "A dummy bean ...")
public class JsonStatus {
    Boolean success = false;
    Boolean failure = false;
    String msg;

    private static JsonStatus jsonStatus = new JsonStatus();

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
    public static JsonStatus successResult(String msg) {
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
    public static JsonStatus failureResult(String msg) {
        jsonStatus.setMsg(msg);
        jsonStatus.setSuccess(false);
        jsonStatus.setFailure(true);
        return jsonStatus;
    }
}
