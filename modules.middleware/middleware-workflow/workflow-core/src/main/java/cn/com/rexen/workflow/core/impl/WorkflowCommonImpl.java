package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.workflow.api.biz.IWorkflowCommon;
import cn.com.rexen.workflow.api.model.BizDataDTO;
import cn.com.rexen.workflow.api.model.FormDTO;
import cn.com.rexen.workflow.api.util.WorkflowUtil;
import cn.com.rexen.workflow.api.web.IBizDataHandler;
import cn.com.rexen.workflow.api.web.IFormHandler;
import cn.com.rexen.workflow.core.manager.BizDataManager;
import cn.com.rexen.workflow.core.manager.FormManager;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by sunlf on 2015/7/30.
 */
public class WorkflowCommonImpl implements IWorkflowCommon {
    private FormService formService;
    private RepositoryService repositoryService;
    private TaskService taskService;

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public FormDTO getForm(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        //获得流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
        //获得任务form数据
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        IFormHandler formHandler = FormManager.getInstall().findFormByKey(processDefinition.getKey(), taskFormData.getFormKey());
        Mapper mapper = new DozerBeanMapper();
        FormDTO formDTO = mapper.map(formHandler, FormDTO.class);

        return formDTO;
    }

    @Override
    public BizDataDTO getBizData(String processDefinitionId) {
        IBizDataHandler bizDataHandler = BizDataManager.getInstall().findPanelByKey(WorkflowUtil.getProcessKey(processDefinitionId));
        Mapper mapper = new DozerBeanMapper();
        BizDataDTO bizDataDTO = mapper.map(bizDataHandler, BizDataDTO.class);
        return bizDataDTO;
    }
}
