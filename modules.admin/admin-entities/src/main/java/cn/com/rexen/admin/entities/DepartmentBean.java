package cn.com.rexen.admin.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 部门实体类
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
@Entity
@Table(name = "sys_department")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class DepartmentBean extends PersistentEntity {
    private String name; //名称
    private String code; //代码
    private String centerCode; //中心代码
    private int isLeaf; //是否是叶子节点
    private long parentId; //父节点
    private int orgId;  // 归属机构


    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(int isLeaf) {
        this.isLeaf = isLeaf;
    }

}
