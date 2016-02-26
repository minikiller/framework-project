package cn.com.rexen.core.redis.mq;

import cn.com.rexen.core.api.system.IStackService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by sunlf on 2016-02-26.
 * redis 实现的消息队列
 */
public class RedisStackServiceImpl implements IStackService {
    private JedisPool jedisPool;

    @Override
    public void publish(String topic, String msgJson) {

    }

    @Override
    public String consume(String topic) {
        return null;
    }

    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

}
