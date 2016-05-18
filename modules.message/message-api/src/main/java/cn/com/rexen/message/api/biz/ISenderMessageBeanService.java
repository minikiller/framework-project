package cn.com.rexen.message.api.biz;

import cn.com.rexen.message.entities.SenderMessageBean;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;

/**
 * @类描述：应用服务接口.
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface ISenderMessageBeanService extends IBizService<SenderMessageBean> {
    //在此添加新的业务方法
    JsonData getSenderMessage(int page, int limit, String jsonStr);

    JsonStatus saveAllEntities(SenderMessageBean senderMessageBean);
}
