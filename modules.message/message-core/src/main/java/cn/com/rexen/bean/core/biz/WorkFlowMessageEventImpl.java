package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import org.activiti.engine.impl.util.json.JSONObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import java.util.Date;

/**
 * 工作流中的消息进行监听处理类
 * Created by zangyanming on 2016/2/23.
 */
public class WorkFlowMessageEventImpl implements EventHandler {
    IMessageBeanDao dao;

    public void setDao(IMessageBeanDao dao) {
        this.dao = dao;
    }

    @Override
    public void handleEvent(Event event) {
        String json = (String) event.getProperty("body");
        JSONObject taskJson = new JSONObject(json);
        String receiver = (String)taskJson.get("assignee");
        String processDefinitionId = (String) taskJson.get("processDefinitionId");
        String content = String.format("%s,您好！\r\n  您有一个代办流程请尽快处理！流程号为%s。", receiver, processDefinitionId);

        MessageBean messageBean = new MessageBean();
        messageBean.setSender("系统管理员");
        messageBean.setReceiver(receiver);
        messageBean.setCategory("assignment");
        messageBean.setTitle("待办任务");
        messageBean.setContent(content);
        messageBean.setSend_timestamp(new Date());
        messageBean.setRead(1);//未读的新消息
        messageBean.setMessage_state(1);
        messageBean.setSign(0);

        dao.save(messageBean);
    }
}
