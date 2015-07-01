package cn.com.rexen.admin.entities;

import com.daren.core.api.persistence.PersistentEntity;
import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * @类描述：角色实现类
 * @创建人：sunlf
 * @创建时间：2014-04-26 上午11:07
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "sys_role")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class RoleBean extends PersistentEntity {
    @NotNull(message = "'角色名称'是必填项")
    private String name;    // 角色名称
    private String remark;  //角色备注
    @XmlTransient
    private List<UserBean> userList = Lists.newArrayList(); // 拥有用户列表
    private List<PermissionBean> permissionList = Lists.newArrayList(); // 拥有菜单列表

    public RoleBean() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }


    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("id")
    public List<UserBean> getUserList() {
        return userList;
    }


    public void setUserList(List<UserBean> userList) {
        this.userList = userList;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_role_permission", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    @OrderBy("id")
    public List<PermissionBean> getPermissionList() {
        return permissionList;
    }


    public void setPermissionList(List<PermissionBean> permissionList) {
        this.permissionList = permissionList;
    }
}
