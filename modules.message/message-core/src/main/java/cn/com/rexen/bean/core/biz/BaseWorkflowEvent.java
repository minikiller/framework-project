package cn.com.rexen.bean.core.biz;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.core.api.system.IStackService;

/**
 * Created by sunlf on 2016/2/26.
 * 工作流消息处理抽象类
 */
public abstract class BaseWorkflowEvent {
    protected IMessageBeanDao dao;
    protected IStackService stackService;
    protected IUserBeanService userBeanService;
    protected static final int day = 24 * 60 * 60 * 1000;
    protected static final int ADMIN_USER_ID = 5601;

    protected MessageBean saveMessageBean(long receiverId, String content, String title) {
        MessageBean messageBean = new MessageBean();
        messageBean.setSenderId(ADMIN_USER_ID);
        messageBean.setReceiverId(receiverId);
        messageBean.setCategory("4");//1、消息；2、建议；3、警告；4、分配；
        messageBean.setTitle(title);
        messageBean.setContent(content);
        messageBean.setRead(false);//未读的消息
        messageBean.setState(1);
        messageBean.setSign(0);
        return messageBean;
    }

    public void setDao(IMessageBeanDao dao) {
        this.dao = dao;
    }

    public void setStackService(IStackService stackService) {
        this.stackService = stackService;
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }
}
