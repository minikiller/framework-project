package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.security.IUserLoginService;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.DateUtil;
import cn.com.rexen.core.util.SerializeUtil;
import cn.com.rexen.core.util.StringUtils;
import cn.com.rexen.workflow.api.biz.ITaskService;
import cn.com.rexen.workflow.api.model.JsonData;
import cn.com.rexen.workflow.api.model.TaskDTO;
import cn.com.rexen.workflow.api.util.WorkflowUtil;
import cn.com.rexen.workflow.core.DozerHelper;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/7/31.
 * 任务服务的实现类
 */
public class TaskServiceImpl implements ITaskService {
    private TaskService taskService;
    private RuntimeService runtimeService;
    private HistoryService historyService;
    private JsonData jsonData = new JsonData();
    private IUserLoginService userLoginService;
    private IRoleBeanService roleBeanService;

    /**
     * 获得工作流任务列表
     *
     * @return
     */
    @Override
    public JsonData getTasks(int page, int limit, String jsonStr) {
        //获得当前登陆用户
        String userName = userLoginService.getLoginName();
        List<TaskDTO> taskDTOList;
        List<Task> taskGroupList;//获得用户组的任务列表
        List<Task> taskUserList;//获得基于用户的任务列表
        List<String> roleBeanList = roleBeanService.getRoleNameListByLoginName(userName);
        if (StringUtils.isNotEmpty(jsonStr)) {
            Map map = SerializeUtil.json2Map(jsonStr);
            String taskName = (String) map.get("name");
            Assert.notNull(taskName);
            taskGroupList = taskService
                    .createTaskQuery().taskCandidateGroupIn(roleBeanList)
                    .taskNameLike("%" + taskName + "%").orderByTaskCreateTime().desc()
                    .listPage((page - 1) * limit, limit);
            taskUserList = taskService
                    .createTaskQuery().taskAssignee(userName)
                    .taskNameLike("%" + taskName + "%").orderByTaskCreateTime().desc()
                    .listPage((page - 1) * limit, limit);
        } else {
            taskGroupList = taskService
                    .createTaskQuery().taskCandidateGroupIn(roleBeanList)
                    .orderByTaskCreateTime().desc()
                    .listPage((page - 1) * limit, limit);
            taskUserList = taskService
                    .createTaskQuery().taskAssignee(userName)
                    .orderByTaskCreateTime().desc()
                    .listPage((page - 1) * limit, limit);
        }
        taskGroupList.addAll(taskUserList);
        if (taskGroupList != null) {
            Mapper mapper = new DozerBeanMapper();
            taskDTOList = DozerHelper.map(mapper, taskGroupList, TaskDTO.class);
            jsonData.setTotalCount(taskGroupList.size());
            //获得业务实体id
            for (TaskDTO dto : taskDTOList) {
                ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(dto.getProcessInstanceId()).singleResult();
                if (processInstance != null) {
                    dto.setEntityId(WorkflowUtil.getBizId(processInstance.getBusinessKey()));
                    dto.setBusinessKey(processInstance.getBusinessKey());
                } else {
                    HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(dto.getProcessInstanceId()).singleResult();
                    if (historicProcessInstance != null) {
                        dto.setEntityId(WorkflowUtil.getBizId(historicProcessInstance.getBusinessKey()));
                        dto.setBusinessKey(processInstance.getBusinessKey());
                    }
                }
                if (dto.getDuration() != null)
                    dto.setDuration(DateUtil.formatDuring(Long.parseLong(dto.getDuration())));
            }
            jsonData.setData(taskDTOList);
        }
        return jsonData;
    }

    /**
     * 获得流程启动用户id
     *
     * @param processInstanceId 流程实例id
     * @return
     */
    public String getStartUserName(String processInstanceId) {
        HistoricProcessInstance historicProcessInstance;
        historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String userName = historicProcessInstance.getStartUserId();
        return userName;
    }

    @Override
    public JsonStatus delegateTask(String taskIds, String userId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {

            jsonStatus.setSuccess(true);
            String[] taskId = taskIds.split(":");
            for (String id : taskId) {
                taskService.claim(id, userLoginService.getLoginName());
                taskService.delegateTask(id, userId);
            }
            jsonStatus.setMsg("委托任务处理成功！");
            return jsonStatus;
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("委托任务处理失败！");
        }
        return jsonStatus;

    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setUserLoginService(IUserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    public void setRoleBeanService(IRoleBeanService roleBeanService) {
        this.roleBeanService = roleBeanService;
    }
}
