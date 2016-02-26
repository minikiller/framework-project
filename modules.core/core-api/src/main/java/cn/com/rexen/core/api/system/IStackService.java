package cn.com.rexen.core.api.system;

import cn.com.rexen.core.api.IService;

/**
 * Created by sunlf on 2016-02-26.
 * 堆栈服务接口类
 */
public interface IStackService extends IService {
    /**
     * 发布消息到队列
     *
     * @param topic   topic
     * @param msgJson JSON 格式的消息
     */
    void publish(String topic, String msgJson);
    /**
     * 读取消息队列
     * @param topic   topic
     */
    String consume(String topic);
}
