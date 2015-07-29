package cn.com.rexen.admin.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 工作组角色实体类
 * @author majian <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_workGroup_role")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class WorkGroupRoleBean extends PersistentEntity {
    /**
     * 角色.
     */
    private long roleId;
    /**
     * 工作组.
     */
    private long groupId;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
