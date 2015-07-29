package cn.com.rexen.admin.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 角色用户关联实体类
 * @author majian <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_role_user")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class RoleUserBean extends PersistentEntity {
    /**
     * 用户.
     */
    private long userId;
    /**
     * 角色.
     */
    private long roleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
