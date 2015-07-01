package cn.com.rexen.admin.entities;

import com.daren.core.api.persistence.PersistentEntity;
import com.google.common.collect.Lists;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;


/**
 * @类描述：用户实体实现类
 * @创建人：sunlf
 * @创建时间：2014-04-26 上午11:10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "sys_user")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class UserBean extends PersistentEntity {

    private String relateId;      //关联隐患排查id
    private String jgdm;          //机构代码
    private String qyid = "";       //企业id
    @NotNull(message = "'登录名'是必填项")
    private String loginName;   // 登录名
    @NotNull(message = "'姓名'是必填项")
    private String name;        // 姓名
    @NotNull(message = "'密码'是必填项")
    private String password;    // 密码
    @NotNull(message = "'邮箱'是必填项")
    private String email;       // 邮箱
    private String phone;       // 电话
    @NotNull(message = "'手机'是必填项")
    private String mobile;      // 手机
    private String loginIp;    // 最后登陆IP
    private Date loginDate;    // 最后登陆日期
    private int is_ent_user;   //是否是企业用户：0-否；1-是
    private int available = 1;     //用户是否有效：0-无效；1-有效
    @XmlTransient
    private List<RoleBean> roleList = Lists.newArrayList(); // 拥有角色列表

    public UserBean() {

    }

    public String getRelateId() {
        return relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getLoginName() {
        return loginName;
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    public String getQyid() {
        return qyid;
    }

    public void setQyid(String qyid) {
        this.qyid = qyid;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getIs_ent_user() {
        return is_ent_user;
    }

    public void setIs_ent_user(int is_ent_user) {
        this.is_ent_user = is_ent_user;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {
                    "user_id", "role_id"})})
    @OrderBy("id")
    public List<RoleBean> getRoleList() {
        return roleList;
    }


    public void setRoleList(List<RoleBean> roleList) {
        this.roleList = roleList;
    }

}
