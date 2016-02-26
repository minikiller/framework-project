package cn.com.rexen.bean.api.biz;

import cn.com.rexen.bean.entities.MessageBean;
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
public interface IMessageBeanService extends IBizService<MessageBean> {
    //在此添加新的业务方法
    JsonStatus getNewMessageCount();

    JsonData getReceiverMessage(int page, int limit, String jsonStr);

    JsonData getSenderMessage(int page, int limit, String jsonStr);

    /**
     * 获得轮询的消息
     */
    JsonStatus getPollingMessage();
}
