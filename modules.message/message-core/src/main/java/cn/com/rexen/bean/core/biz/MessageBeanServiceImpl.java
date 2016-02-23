package cn.com.rexen.bean.core.biz;

import cn.com.rexen.bean.api.biz.IMessageBeanService;
import cn.com.rexen.bean.api.dao.IMessageBeanDao;
import cn.com.rexen.bean.entities.MessageBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class MessageBeanServiceImpl extends GenericBizServiceImpl<IMessageBeanDao, MessageBean> implements IMessageBeanService {
    private JsonStatus jsonStatus = new JsonStatus();

    public MessageBeanServiceImpl() {
        super.init(MessageBean.class.getName());
    }
}
