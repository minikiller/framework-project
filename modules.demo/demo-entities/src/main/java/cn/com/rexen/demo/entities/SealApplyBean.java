package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.WorkflowEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author chenyanxu
 *         印章申请业务类
 */
@Entity
@Table(name = "sys_seal_apply")
public class SealApplyBean extends WorkflowEntity {
    //申请部门
    private String department;
    //申请时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyDate;
    //用印数
    private Integer usageCount;
    //印章类别
    private Integer sealType;
    //经办人
    private String operator;
    //备注
    private String remark;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date date) {
        this.applyDate = date;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    public Integer getSealType() {
        return sealType;
    }

    public void setSealType(Integer sealType) {
        this.sealType = sealType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
