package cn.com.rexen.bean.core.biz;

import cn.com.rexen.audit.api.dao.IAuditBeanDao;
import org.activiti.engine.impl.util.json.JSONObject;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * 工作流中的消息进行监听处理类
 * Created by zangyanming on 2016/2/23.
 */
public class WorkFlowMessageEventImpl implements EventHandler {
    IAuditBeanDao dao;

    public void setDao(IAuditBeanDao dao) {
        this.dao = dao;
    }

    @Override
    public void handleEvent(Event event) {
        String json = (String) event.getProperty("body");
        JSONObject taskJson = new JSONObject(json);
        taskJson.get("assignee");

    }
}
