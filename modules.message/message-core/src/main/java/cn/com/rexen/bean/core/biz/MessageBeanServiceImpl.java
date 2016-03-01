package cn.com.rexen.bean.core.biz;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.bean.api.biz.IMessageBeanService;
import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.core.Const;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.system.IStackService;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;

import java.util.List;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class MessageBeanServiceImpl extends ShiroGenericBizServiceImpl<IMessageBeanDao, MessageBean> implements IMessageBeanService {
    private IUserBeanService userBeanService;
    private IStackService stackService;

    public MessageBeanServiceImpl() {
        super.init(MessageBean.class.getName());
    }

    @Override
    public JsonStatus getNewMessageCount() {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        List countList = this.dao.find("select mb from MessageBean mb where mb.receiverId=?1 and mb.read=false", userBean.getId());
        if (countList != null) {
            jsonStatus.setTag(String.valueOf(countList.size()));
        } else {
            jsonStatus.setTag("0");
        }

        return jsonStatus;
    }

    @Override
    public JsonData getReceiverMessage(int page, int limit, String jsonStr) {
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        String userId = String.valueOf(userBean.getId());
        if (jsonStr == null) {
            jsonStr = "{\"receiverId\":\"" + userId + "\"}";
        } else {
            jsonStr = jsonStr.replace("}", ",\"receiverId\":\"" + userId + "\"}");
        }
        return super.getAllEntityByQuery(page, limit, jsonStr);
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
    public JsonStatus saveAllEntities(MessageBean messageBean) {
        JsonStatus jsonStatus = new JsonStatus();
        long receiverids = messageBean.getReceiverId();
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        long userId = userBean.getId();
        try {
            jsonStatus.setSuccess(true);
            messageBean.setSenderId(userId);
            MessageBean newMessageBean = messageBean;
            /*String[] ids = receiverids.split(":");
            for (int i = 0; i < ids.length; i++) {
                newMessageBean.setReceiverId(ids[i]);
                saveEntity(newMessageBean);
            }*/
            jsonStatus.setTag("");
            return jsonStatus;
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setTag("");
            return jsonStatus;
        }
    }

    @Override
    public JsonStatus getPollingMessage() {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            jsonStatus.setSuccess(true);
            String loginName = this.getShiroService().getSubject().getPrincipal().toString();
            UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
            String topic = String.format(Const.POLLING_TOPIC_FORMAT, String.valueOf(userBean.getId()));
            jsonStatus.setTag(stackService.consume(topic));
            return jsonStatus;
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setTag("");
            return jsonStatus;
        }
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setStackService(IStackService stackService) {
        this.stackService = stackService;
    }

}
