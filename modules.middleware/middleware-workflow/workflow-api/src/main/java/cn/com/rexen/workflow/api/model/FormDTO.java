package cn.com.rexen.workflow.api.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

/**
 * Created by sunlf on 2015/7/30.
 * 用于返回extjs的表单DTO
 */
public class FormDTO extends BaseDTO {
    private String formKey;
    private String processDefinitionId;
    private String componentClass;
    private String formClass;
    private String windowClass;

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(String componentClass) {
        this.componentClass = componentClass;
    }

    public String getFormClass() {
        return formClass;
    }

    public void setFormClass(String formClass) {
        this.formClass = formClass;
    }

    public String getWindowClass() {
        return windowClass;
    }

    public void setWindowClass(String windowClass) {
        this.windowClass = windowClass;
    }
}
