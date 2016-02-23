package cn.com.rexen.bean;

import java.util.Date;

/**
 * Created by zangyanming on 2016/2/19.
 */
public class MessageBean {
    /**
     * @describe 发送者
     * @validator 不能为空
     */
    private String sender;
    /**
     * @describe 接收者
     * @validator 不能为空
     */
    private String receiver;
    /**
     * @describe 消息类别
     * @validator 不能为空
     */
    private String category;
    /**
     * @describe 消息标题
     * @validator 不能为空
     */
    private String title;
    /**
     * @describe 消息内容
     * @validator 不能为空
     */
    private String content;
    /**
     * @describe 消息发送时间
     * @validator 不能为空
     */
    private Date send_timestamp;
    /**
     * @describe 消息是否已读
     * @validator 不能为空
     */
    private int read;
    /**
     * @describe 消息类别
     * @validator 不能为空
     */
    private int message_state;
    /**
     * @describe 消息标识
     * @validator 不能为空
     */
    private int sign;
}
