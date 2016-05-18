package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.WorkflowEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：用车申请管理
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "demo_car")
@Inheritance(strategy = InheritanceType.JOINED)
public class CarApplyBean extends WorkflowEntity {
    private String department;//申请部门
    private String reason;//用车事由
    private Integer usageCount; //乘车人数
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginDate;//用车时段,开始时间
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyDate;//用车时段,开始时间
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;//用车时段，结束时间
    private String address;//用车起始地点
    private boolean city;//是否市内用车
    private String operatorPhone;//申请人联系电话
    private String depUser;//申请部门负责人签字
    private String managerUser;//副校级领导审核
    private String schoolUser;//校务部签字
    private String schoolManagerUser;//校务部主管领导审批（市外）

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCity() {
        return city;
    }

    public void setCity(boolean city) {
        this.city = city;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getDepUser() {
        return depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(String managerUser) {
        this.managerUser = managerUser;
    }

    public String getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(String schoolUser) {
        this.schoolUser = schoolUser;
    }

    public String getSchoolManagerUser() {
        return schoolManagerUser;
    }

    public void setSchoolManagerUser(String schoolManagerUser) {
        this.schoolManagerUser = schoolManagerUser;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }
}
