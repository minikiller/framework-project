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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSend_timestamp() {
        return send_timestamp;
    }

    public void setSend_timestamp(Date send_timestamp) {
        this.send_timestamp = send_timestamp;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getMessage_state() {
        return message_state;
    }

    public void setMessage_state(int message_state) {
        this.message_state = message_state;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
