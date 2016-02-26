package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.core.api.system.IStackService;

import java.util.Date;

/**
 * Created by sunlf on 2016/2/26.
 * 工作流消息处理抽象类
 */
public abstract class BaseWorkflowEvent {
    protected IMessageBeanDao dao;
    protected IStackService stackService;
    protected static final int day = 24 * 60 * 60;
    protected static final String TOPIC_FORMAT = "workflow.message.%s";

    public void setDao(IMessageBeanDao dao) {
        this.dao = dao;
    }

    public void setStackService(IStackService stackService) {
        this.stackService = stackService;
    }

    protected MessageBean saveMessageBean(String receiver, String content, String title) {
        MessageBean messageBean = new MessageBean();
        messageBean.setSender("系统管理员");
        messageBean.setReceiver(receiver);
        messageBean.setCategory("assignment");
        messageBean.setTitle(title);
        messageBean.setContent(content);
        messageBean.setSend_timestamp(new Date());
        messageBean.setRead(1);//未读的新消息
        messageBean.setMessage_state(1);
        messageBean.setSign(0);
        return messageBean;
    }
}
