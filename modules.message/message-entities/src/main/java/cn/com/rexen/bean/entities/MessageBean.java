package cn.com.rexen.bean.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "workflow_message")
public class MessageBean extends PersistentEntity {
    /**
     * @describe 发送者
     * @validator 不能为空
     */
    private long senderId;
    /**
     * @describe 接收者
     * @validator 不能为空
     */
    private long receiverId;
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
     * @describe 消息是否已读
     * @validator 不能为空
     */
    private boolean read;
    /**
     * @describe 消息类别
     * @validator 不能为空
     */
    private int state;
    /**
     * @describe 消息标识
     * @validator 不能为空
     */
    private int sign;

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
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

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }
}
