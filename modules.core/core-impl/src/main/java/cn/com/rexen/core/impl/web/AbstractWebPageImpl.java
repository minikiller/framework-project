package cn.com.rexen.core.impl.web;

import cn.com.rexen.core.api.web.IBaseWebPage;

/**
 * 菜单的抽象类
 */
public abstract class AbstractWebPageImpl implements IBaseWebPage {
    protected String id;
    protected String title;
    protected String icon;
    protected String componentClass;
    protected int index;
    protected String permission;
    protected String description;

    @Override
    public String getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(String componentClass) {
        this.componentClass = componentClass;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
