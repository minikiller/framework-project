package cn.com.rexen.bean.core.biz;

import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.bean.api.biz.IMessageBeanService;
import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
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

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }
    public MessageBeanServiceImpl() {
        super.init(MessageBean.class.getName());
    }

    @Override
    public JsonStatus getNewMessageCount() {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        String userName = this.getShiroService().getSubject().getPrincipal().toString();
        List countList = this.dao.find("select mb from MessageBean mb where mb.receiver=?1 and mb.read=1", userName);
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
        if (jsonStr == null) {
            jsonStr = "{\"receiver\":\"" + userBean.getId() + "\"}";
        } else {
            jsonStr = jsonStr.replace("}", ",\"receiver\":\"" + userBean.getId() + "\"}");
        }
        return super.getAllEntityByQuery(page, limit, jsonStr);
    }

    @Override
    public JsonData getSenderMessage(int page, int limit, String jsonStr) {
        String loginName = this.getShiroService().getSubject().getPrincipal().toString();
        UserBean userBean = userBeanService.getUserBeanByUsername(loginName);
        if (jsonStr == null) {
            jsonStr = "{\"sender\":\"" + userBean.getId() + "\"}";
        } else {
            jsonStr = jsonStr.replace("}", ",\"sender\":\"" + userBean.getId() + "\"}");
        }
        return super.getAllEntityByQuery(page, limit, jsonStr);
    }
}
