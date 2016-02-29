package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.core.Const;
import cn.com.rexen.bean.entities.MessageBean;
import com.google.gson.Gson;
import org.activiti.engine.impl.util.json.JSONObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * 工作流中的消息进行监听处理类,负责把工作流的进度发送给启动者。
 * Created by sunlf on 2016/2/23.
 */
public class WorkFlowStarterEventImpl extends BaseWorkflowEvent implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        String json = (String) event.getProperty("body");
        JSONObject taskJson = new JSONObject(json);
        String receiverid = (String) taskJson.get("startUserId");
        String processDefinitionId = (String) taskJson.get("processDefinitionId");
        String content = String.format("%s,您好！\r\n  您有一个待办流程请尽快处理！流程号为%s。", receiverid, processDefinitionId);

        MessageBean messageBean = saveMessageBean(receiverid, content, "审批任务进度提醒");
        dao.save(messageBean);
        //add msg to stack
        Gson gson = new Gson();
        stackService.publish(String.format(Const.POLLING_TOPIC_FORMAT, receiverid), gson.toJson(messageBean), day);
    }

}
