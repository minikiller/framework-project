package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author chenyanxu
 *         印章申请业务类
 */
@Entity
@Table(name = "demo_seal_apply")
public class SealApplyBean extends WorkflowEntity {
    //申请部门
    private String department;
    //用印数
    private Integer usageCount;
    //印章类别
    private Integer sealType;
    //部门负责人
    private String departmentHead;
    //分公司负责人
    private String filialeHead;
    //法律顾问
    private String counsel;
    //总经理
    private String generalManager;
    //印章专管员
    private String sealAdministrator;
    //审批修改
    private String modify;

    //备注
    private String remark;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getFilialeHead() {
        return filialeHead;
    }

    public void setFilialeHead(String filialeHead) {
        this.filialeHead = filialeHead;
    }

    public String getCounsel() {
        return counsel;
    }

    public void setCounsel(String counsel) {
        this.counsel = counsel;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getSealAdministrator() {
        return sealAdministrator;
    }

    public void setSealAdministrator(String sealAdministrator) {
        this.sealAdministrator = sealAdministrator;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }
}
