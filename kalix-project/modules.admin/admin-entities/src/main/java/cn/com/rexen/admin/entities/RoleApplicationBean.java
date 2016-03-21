package cn.com.rexen.admin.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 角色应用关联实体类
 * @author majian <br/>
 *         date:2015-8-4
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_role_application")
@Inheritance(strategy = InheritanceType.JOINED)
//@XmlRootElement
public class RoleApplicationBean extends PersistentEntity {
    /**
     * 应用.
     */
    private long applicationId;
    /**
     * 角色.
     */
    private long roleId;


    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
