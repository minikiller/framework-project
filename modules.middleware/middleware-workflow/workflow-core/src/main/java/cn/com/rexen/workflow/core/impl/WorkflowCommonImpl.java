package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.workflow.api.biz.IWorkflowCommon;
import cn.com.rexen.workflow.api.model.BizDataDTO;
import cn.com.rexen.workflow.api.model.FormDTO;
import cn.com.rexen.workflow.api.web.IFormHandler;
import cn.com.rexen.workflow.core.manager.FormManager;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

/**
 * Created by sunlf on 2015/7/30.
 */
public class WorkflowCommonImpl implements IWorkflowCommon {
    private FormService formService;
    private RepositoryService repositoryService;

    @Override
    public FormDTO getForm(Task task) {
        FormDTO formDTO = new FormDTO();
        //获得流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
        //获得任务form数据
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        IFormHandler formHandler = FormManager.getInstall().findFormByKey(processDefinition.getKey(), taskFormData.getFormKey());

        return formDTO;
    }

    @Override
    public BizDataDTO getBizData(String processDefinitionId) {
        BizDataDTO bizDataDTO = new BizDataDTO();
        return bizDataDTO;
    }
}
