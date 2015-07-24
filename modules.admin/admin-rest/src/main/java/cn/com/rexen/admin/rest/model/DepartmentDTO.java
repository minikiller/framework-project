package cn.com.rexen.admin.rest.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 部门模型类
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public class DepartmentDTO extends BaseDTO {
    private String name; //名称
    private String text; //名称
    private String code; //代码
    private String centerCode; //中心代码
    private boolean leaf; //是否是叶子节点
    private long parentId; //父节点
    private int orgId;  // 所属机构
    private String parentName; //父节点名称
    private List<DepartmentDTO> children=new ArrayList<DepartmentDTO>();


    private Date creationDate;// 创建日期
    private String createBy;    // 创建者
    private String updateBy;    // 更新者
    private Date updateDate; //更新日期


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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


    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

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

    public List<DepartmentDTO> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentDTO> children) {
        this.children = children;
    }
}
