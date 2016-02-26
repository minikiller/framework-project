package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.entities.MessageBean;
import com.google.gson.Gson;
import org.activiti.engine.impl.util.json.JSONObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * 工作流中的消息进行监听处理类
 * 负责把消息发送给相关流程处理人
 * Created by zangyanming on 2016/2/23.
 */
public class WorkFlowMessageEventImpl extends BaseWorkflowEvent implements EventHandler {
    @Override
    public void handleEvent(Event event) {
        String json = (String) event.getProperty("body");
        JSONObject taskJson = new JSONObject(json);
        String receiver = (String)taskJson.get("assignee");
        String processDefinitionId = (String) taskJson.get("processDefinitionId");
        String content = String.format("%s,您好！\r\n  您有一个待办流程请尽快处理！流程号为%s。", receiver, processDefinitionId);

        MessageBean messageBean = saveMessageBean(receiver, content, "待办任务");

        dao.save(messageBean);
        Gson gson = new Gson();
        stackService.publish("workflow.message." + receiver, gson.toJson(messageBean), 0);
    }


}
