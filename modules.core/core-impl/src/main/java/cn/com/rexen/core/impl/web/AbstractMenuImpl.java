package cn.com.rexen.core.impl.web;

import cn.com.rexen.core.api.web.IMenu;

/**
 * WebPage的抽象类
 */
public abstract class AbstractMenuImpl extends AbstractWebPageImpl implements IMenu {
    protected boolean leaf;
    protected String moduleId;
    protected String parentMenuId;


    @Override
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Override
    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    @Override
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
