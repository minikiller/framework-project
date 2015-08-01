package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.workflow.api.biz.ITaskService;
import cn.com.rexen.workflow.api.model.JsonData;
import cn.com.rexen.workflow.api.model.TaskDTO;
import cn.com.rexen.workflow.core.DozerHelper;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.List;

/**
 * Created by sunlf on 2015/7/31.
 * 任务服务的实现类
 */
public class TaskServiceImpl implements ITaskService {
    private TaskService taskService;
    private JsonData jsonData = new JsonData();

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 获得工作流任务列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public JsonData getTasks(String userId) {
        List<TaskDTO> taskDTOList;
        List<Task> taskList = taskService
                .createTaskQuery()
                .taskAssignee(userId).orderByTaskCreateTime().desc()
                .list();

        if (taskList != null) {
            Mapper mapper = new DozerBeanMapper();
            taskDTOList = DozerHelper.map(mapper, taskList, TaskDTO.class);
            jsonData.setTotalCount(taskDTOList.size());
            jsonData.setData(taskDTOList);
        }
        return jsonData;
    }
}
