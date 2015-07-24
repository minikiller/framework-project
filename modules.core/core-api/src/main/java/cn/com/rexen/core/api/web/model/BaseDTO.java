package cn.com.rexen.core.api.web.model;

/**
 * 数据传输模型基类
 * 用于JSON数据
 * @author majian <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
public abstract class BaseDTO {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
