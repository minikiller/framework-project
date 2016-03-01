package cn.com.rexen.bean.core.biz;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.bean.api.biz.IMessageBeanService;
import cn.com.rexen.bean.api.biz.ISenderMessageBeanService;
import cn.com.rexen.bean.api.dao.ISenderMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.bean.entities.SenderMessageBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class SenderMessageBeanServiceImpl extends ShiroGenericBizServiceImpl<ISenderMessageBeanDao, SenderMessageBean> implements ISenderMessageBeanService {
    private IUserBeanService userBeanService;
    private IMessageBeanService messageBeanService;

    public SenderMessageBeanServiceImpl() {
        super.init(SenderMessageBean.class.getName());
    }

    @Override
    public JsonData getSenderMessage(int page, int limit, String jsonStr) {
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        String userId = String.valueOf(userBean.getId());
        if (jsonStr == null) {
            jsonStr = "{\"senderId\":\"" + userId + "\"}";
        } else {
            jsonStr = jsonStr.replace("}", ",\"senderId\":\"" + userId + "\"}");
        }
        return super.getAllEntityByQuery(page, limit, jsonStr);
    }

    @Override
    public JsonStatus saveAllEntities(SenderMessageBean senderMessageBean) {
        JsonStatus jsonStatus = new JsonStatus();
        String receiverIds = senderMessageBean.getReceiverIds();
        String receiverNames = senderMessageBean.getReceiverNames();
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        long senderId = userBean.getId();
        try {
            jsonStatus.setSuccess(true);
            senderMessageBean.setSenderId(senderId);
            String[] ids = receiverNames.split(":");//要修改的
            for (int i = 0; i < ids.length; i++) {
                MessageBean newMessageBean = new MessageBean();
                newMessageBean.setSenderId(senderId);
                newMessageBean.setReceiverId(Long.parseLong(ids[i]));
                newMessageBean.setCategory(senderMessageBean.getCategory());
                newMessageBean.setTitle(senderMessageBean.getTitle());
                newMessageBean.setContent(senderMessageBean.getContent());
                newMessageBean.setRead(false);
                newMessageBean.setState(0);
                // 保存收件信息
                messageBeanService.saveEntity(newMessageBean);
            }
            // 保存发件信息
            saveEntity(senderMessageBean);

            jsonStatus.setTag("SenderMessageBeanServiceImpl.java:saveAllEntities异常");
            return jsonStatus;
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setTag("");
            jsonStatus.setMsg("");
            return jsonStatus;
        }
    }

    public IUserBeanService getUserBeanService() {
        return userBeanService;
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public IMessageBeanService getMessageBeanService() {
        return messageBeanService;
    }

    public void setMessageBeanService(IMessageBeanService messageBeanService) {
        this.messageBeanService = messageBeanService;
    }
}
