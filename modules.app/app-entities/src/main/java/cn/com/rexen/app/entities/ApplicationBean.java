package cn.com.rexen.app.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 应用模型类
 * @author majian <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_application")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class ApplicationBean extends PersistentEntity {
    @NotNull(message = "'名称'是必填项")
    private String name;   // 名称
    @NotNull(message = "'登录名'是必填项")
    private String remark;   // 备注
    @NotNull(message = "'代码'是必填项")
    private String code; //代码
    private String location; //地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ApplicationBean() {

    }

}
