package cn.com.rexen.bean.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：消息管理
 * @创建人：zangyanming
 * @创建时间：2016-02-19
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "Kalix_message")
public class MessageBean extends PersistentEntity {
    /**
     * @describe 发送者
     */
    private String sender;

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @describe 接收者
     */
    private String receiver;

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @describe 消息类别
     */
    private String category;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @describe 消息主题
     */
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @describe 消息内容
     */
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @describe 发送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date send_timestamp;

    public Date getSend_timestamp() {
        return this.send_timestamp;
    }

    public void setSend_timestamp(Date send_timestamp) {
        this.send_timestamp = send_timestamp;
    }

    /**
     * @describe 是否已读
     */
    private int read;

    public int getRead() {
        return this.read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    /**
     * @describe 消息状态
     */
    private int message_state;

    public int getMessage_state() {
        return this.message_state;
    }

    public void setMessage_state(int message_state) {
        this.message_state = message_state;
    }

    /**
     * @describe 消息标识
     */
    private int sign;

    public int getSign() {
        return this.sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }


}
