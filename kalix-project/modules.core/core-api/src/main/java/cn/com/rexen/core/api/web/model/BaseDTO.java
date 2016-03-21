package cn.com.rexen.core.api.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据传输模型基类
 * 用于JSON数据
 * @author majian <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
public abstract class BaseDTO implements Serializable {
    protected long id = -1;

    protected Date creationDate;// 创建日期
    protected String createBy;    // 创建者
    protected String updateBy;    // 更新者
    protected Date updateDate; //更新日期
    protected long version;

    public BaseDTO() {
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
