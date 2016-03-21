package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.MessageBean;
import cn.com.rexen.core.api.biz.IBizService;

import java.util.List;

/**
 * @类描述：系统消息服务接口类
 * @创建人： sunlingfeng
 * @创建时间：2014/9/25
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface IMessageBeanService extends IBizService<MessageBean> {
    List<MessageBean> query(MessageBean bean);
}
