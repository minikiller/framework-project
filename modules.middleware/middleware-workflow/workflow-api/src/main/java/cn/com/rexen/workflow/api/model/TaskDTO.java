package cn.com.rexen.workflow.api.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

/**
 * Created by sunlf on 2015/7/31.
 * 任务DTO
 */
public class TaskDTO extends BaseDTO {
    private String name;//任务名称
    private String description;//任务描述
    private String assignee;//执行人
    private String createTime;//创建时间
    private String processInstanceId;//流程实例id

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
