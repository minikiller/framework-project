package cn.com.rexen.workflow.api.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

/**
 * Created by sunlf on 2015/8/1.
 * 流程实例历史DtO
 */
public class HistoricProcessInstanceDTO extends BaseDTO {
    private String processDefinitionId;//流程id
    private String startUserId;//启动用户id
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String businessKey;//业务主键
    private String status;//当前状态  结束 进行中
    private String processInstanceId;//流程实例id
    private String entityId;//业务实体id

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
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

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
