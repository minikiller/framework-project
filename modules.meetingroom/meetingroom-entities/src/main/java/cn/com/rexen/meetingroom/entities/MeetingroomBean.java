package cn.com.rexen.meetingroom.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "sys_meetingroom")
public class MeetingroomBean extends PersistentEntity {
    /**
     * @describe 会议室名称
     */
    private String name;
    /**
     * @describe 会议室地址
     */
    private String address;
    /**
     * @describe 容纳人数
     */
    private Integer capacity;
    /**
     * @describe 会议室设备说明
     */
    private String equipment;
    /**
     * @describe 会议室描述
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
