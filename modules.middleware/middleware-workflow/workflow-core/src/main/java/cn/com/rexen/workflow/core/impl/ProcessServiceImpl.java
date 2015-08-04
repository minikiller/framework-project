package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.workflow.api.biz.IProcessService;
import cn.com.rexen.workflow.api.model.HistoricActivityInstanceDTO;
import cn.com.rexen.workflow.api.model.HistoricProcessInstanceDTO;
import cn.com.rexen.workflow.api.model.JsonData;
import cn.com.rexen.workflow.api.model.ProcessDefinitionDTO;
import cn.com.rexen.workflow.core.DozerHelper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.List;

/**
 * Created by sunlf on 2015/7/30.
 */
public class ProcessServiceImpl implements IProcessService {
    private transient RepositoryService repositoryService;
    private HistoryService historyService;
    private TaskService taskService;
    private JsonData jsonData = new JsonData();

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    /**
     * 获得流程定义列表
     *
     * @return
     */
    @Override
    public JsonData getProcessDefinition() {

        List<ProcessDefinitionDTO> processDefinitionDTOList = null;
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().latestVersion().list();
        if (processDefinitionList != null) {
            Mapper mapper = new DozerBeanMapper();
            processDefinitionDTOList = DozerHelper.map(mapper, processDefinitionList, ProcessDefinitionDTO.class);
            jsonData.setTotalCount(processDefinitionDTOList.size());
            jsonData.setData(processDefinitionDTOList);
        }
        return jsonData;
    }


    /**
     * 暂停流程定义
     *
     * @param key
     * @return
     */
    public JsonStatus suspendProcessDefinition(String key) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            RepositoryService repositoryService = processEngine.getRepositoryService();*/

            repositoryService.suspendProcessDefinitionByKey(key);
            jsonStatus.setMsg("暂停流程成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("暂停流程失败");
        }
        return jsonStatus;
    }

    /**
     * 获得流程历史列表
     *
     * @return
     */
    @Override
    public JsonData getProcessHistory() {
        List<HistoricProcessInstanceDTO> historicProcessDTOList = null;
        List<HistoricProcessInstance> processHistoryList = historyService.createHistoricProcessInstanceQuery()
                .orderByProcessInstanceStartTime().desc().list();
        if (processHistoryList != null) {
            Mapper mapper = new DozerBeanMapper();
            historicProcessDTOList = DozerHelper.map(mapper, processHistoryList, HistoricProcessInstanceDTO.class);
            //设置流程状态
            for (HistoricProcessInstanceDTO dto : historicProcessDTOList) {
                if (dto.getEndTime() != null)
                    dto.setStatus("结束");
                else
                    dto.setStatus("进行中");
            }
            jsonData.setTotalCount(historicProcessDTOList.size());
            jsonData.setData(historicProcessDTOList);
        }
        return jsonData;

    }

    /**
     * 获得流程历史节点信息
     *
     * @param historyProcessId
     * @return
     */
    @Override
    public JsonData getHistoricActivity(String historyProcessId) {
        List<HistoricActivityInstanceDTO> historicActivityDTOList;
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery().processInstanceId(historyProcessId).list();
        for (int i = list.size(); i > 0; i--) {
            if (null == list.get(i - 1).getTaskId()) {
                list.remove(i - 1);
            }
        }


        if (list != null) {
            Mapper mapper = new DozerBeanMapper();
            historicActivityDTOList = DozerHelper.map(mapper, list, HistoricActivityInstanceDTO.class);
            for (HistoricActivityInstanceDTO historicActivityInstance : historicActivityDTOList) {
                List<Comment> commentList = taskService.getTaskComments(historicActivityInstance.getTaskId());
                String str = "";
                for (Comment comment : commentList) {
                    str = comment.getFullMessage() + str + " ";
                }
                historicActivityInstance.setComment(str);
            }

            jsonData.setTotalCount(historicActivityDTOList.size());
            jsonData.setData(historicActivityDTOList);
        }
        return jsonData;
    }

    /**
     * 启动流程定义
     *
     * @param key
     * @return
     */
    public JsonStatus activateProcessDefinition(String key) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            /*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            RepositoryService repositoryService = processEngine.getRepositoryService();*/
            repositoryService.activateProcessDefinitionByKey(key);
            jsonStatus.setMsg("启动流程成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("启动流程失败");
        }
        return jsonStatus;
    }
}
