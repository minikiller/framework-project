package cn.com.rexen.workflow.api.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

/**
 * Created by sunlf on 2015/8/4.
 * 历史活动节点信息
 */
public class HistoricActivityInstanceDTO extends BaseDTO {
    private String activityName;
    private String assignee;
    private String startTime;
    private String endTime;
    private String comment;
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
