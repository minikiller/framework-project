package cn.com.rexen.bean.web.impl;

import cn.com.rexen.core.api.web.IMenu;

public class MessageMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "constructModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "messageMenu";
    }

    @Override
    public String getDescription() {
        return "消息管理";
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public int getIndex() {
        return 50;
    }


    @Override
    public String getIconCls() {
        return "x-fa fa-cutlery";
    }

    @Override
    public String getText() {
        return "消息管理";
    }

    @Override
    public String getRouteId() {
        return "app/message";
    }

    @Override
    public String getPermission() {
        return "admin:constructModule:messageMenu";
    }
}
