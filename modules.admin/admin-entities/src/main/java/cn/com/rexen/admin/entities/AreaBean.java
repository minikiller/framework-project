/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package cn.com.rexen.admin.entities;

import cn.com.rexen.core.api.persistence.PersistentEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @类描述：区域实体类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:49
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "sys_area")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public class AreaBean extends PersistentEntity {

    private static final long serialVersionUID = 1L;
    private AreaBean parent;    // 父级编号
    private int isLeaf; //是否是子节点
    @Length(min = 1, max = 255)
    private long parentId; // 父级编号
    @NotNull(message = "'区域编码'是必填项")
    private String code;    // 区域编码
    @NotNull(message = "'中心代码'是必填项")
    private String centerCode;    // 中心代码
    @NotNull(message = "'区域名称'是必填项")
    private String name;    // 区域名称
    private String type;    // 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
    private String jd;      //经度
    private String wd;      //纬度

    private List<AreaBean> childList = new ArrayList<>();    // 拥有子区域列表

    public AreaBean() {
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

    @Transient
    public static void sortList(List<AreaBean> list, List<AreaBean> sourcelist, String parentId) {
        /*for (int i=0; i<sourcelist.size(); i++){
            AreaBean e = sourcelist.get(i);
			if (e.getParent()!=null && e.getParent().getId()!=null
					&& e.getParent().getId().equals(parentId)){
				list.add(e);
				// 判断是否还有子节点, 有则继续获取子节点
				for (int j=0; j<sourcelist.size(); j++){
					AreaBean childe = sourcelist.get(j);
					if (childe.getParent()!=null && childe.getParent().getId()!=null
							&& childe.getParent().getId().equals(e.getId())){
						sortList(list, sourcelist, e.getId());
						break;
					}
				}
			}
		}*/
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @NotNull
    public AreaBean getParent() {
        return parent;
    }

    public void setParent(AreaBean parent) {
        this.parent = parent;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 1, max = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Length(min = 0, max = 100)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    @OrderBy(value = "code")
    public List<AreaBean> getChildList() {
        return childList;
    }

    public void setChildList(List<AreaBean> childList) {
        this.childList = childList;
    }



    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    @Override
    public String toString() {
        return getName();
    }
}