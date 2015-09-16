package cn.com.rexen.core.redis.mq;

public interface Callback {
    public void onMessage(String message);
}
