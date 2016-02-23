package cn.com.rexen.workflow.engine;

import cn.com.rexen.core.util.JNDIHelper;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.impl.util.json.JSONObject;
import org.activiti.engine.task.Task;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by sunlf on 2016-02-22.
 * 自定义事件监听，监听任务分配
 */
public class MessageEvent implements ActivitiEventListener {
    private TaskService taskService;
    private List<Task> taskList;
    private EventAdmin eventAdmin;

    public MessageEvent() {
        try {
            taskService = JNDIHelper.getJNDIServiceForName("org.activiti.engine.TaskService");
            eventAdmin = JNDIHelper.getJNDIServiceForName("org.osgi.service.event.EventAdmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEvent(ActivitiEvent event) {
        switch (event.getType()) {
            case TASK_ASSIGNED:
                postMessageEvent(event);
                break;
            default:
                System.out.println("Event received: " + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    /**
     * 发送 osgi event
     * @param event
     */
    private void postMessageEvent(ActivitiEvent event) {
        JSONObject taskJson=new JSONObject();
        String processDefinitionId = event.getProcessDefinitionId();
        String processInstanceId = event.getProcessInstanceId();
        String executionId = event.getExecutionId();
        taskList = taskService.createTaskQuery().processDefinitionId(processDefinitionId)
                .processInstanceId(processInstanceId).executionId(executionId).list();
        for (Task task : taskList) {
            String assignee = task.getAssignee();
            taskJson.put("assignee",assignee);
            taskJson.put("processDefinitionId", processDefinitionId);
            taskJson.put("processInstanceId", processInstanceId);
            taskJson.put("executionId", executionId);
            System.out.println("A task " + assignee + " is assigned!");
            //添加相关内容到消息体
            Dictionary properties = new Hashtable();
            properties.put("body", taskJson.toString());
            Event osgi_event = new Event("cn/com/rexen/engine/message", properties);
            eventAdmin.postEvent(osgi_event);
        }

    }
}
