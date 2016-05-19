package cn.com.rexen.demo.entities;

import cn.com.rexen.core.api.persistence.WorkflowEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zangyanming
 *         会议申请业务类
 */
@Entity
@Table(name = "demo_meeting")
public class MeetingApplyBean extends WorkflowEntity {
    //申请部门
    private String department;
    //会议地点
    private String meetingPlace;
    //会议名称
    private String meetingTopic;
    //宣传需求（企划中心）
    private Integer requirement;
    //主持人
    private String host;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd W", timezone = "GMT+8")
    private Date meetingDate;//会议日期
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;//会议时段,开始时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date endTime;//会议时段，结束时间
    //星期几
    private String weekOfDate;
    //参会人员
    private String participant;
    //出席人数
    private Integer attendance;
    //设备要求
    private String equipmentRequirement;
    //联系人（安全责任人）
    private String securityPerson;
    //联系人电话
    private String securityTel;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getMeetingTopic() {
        return meetingTopic;
    }

    public void setMeetingTopic(String meetingTopic) {
        this.meetingTopic = meetingTopic;
    }

    public Integer getRequirement() {
        return requirement;
    }

    public void setRequirement(Integer requirement) {
        this.requirement = requirement;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getWeekOfDate() {
        return weekOfDate;
    }

    public void setWeekOfDate(String weekOfDate) {
        this.weekOfDate = weekOfDate;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public String getEquipmentRequirement() {
        return equipmentRequirement;
    }

    public void setEquipmentRequirement(String equipmentRequirement) {
        this.equipmentRequirement = equipmentRequirement;
    }

    public String getSecurityPerson() {
        return securityPerson;
    }

    public void setSecurityPerson(String securityPerson) {
        this.securityPerson = securityPerson;
    }

    public String getSecurityTel() {
        return securityTel;
    }

    public void setSecurityTel(String securityTel) {
        this.securityTel = securityTel;
    }
}
