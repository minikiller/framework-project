package cn.com.rexen.meetingroom.web.impl;

import cn.com.rexen.core.api.web.IMenu;

public class MeetingroomMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return "sysWorkFlowModule";
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "meetingroomMenu";
    }

    @Override
    public String getDescription() {
        return "会议室管理";
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
        return "会议室管理";
    }

    @Override
    public String getRouteId() {
        return "app/meetingroom";
    }

    @Override
    public String getPermission() {
        return "workflow:sysWorkFlowModule:meetingroomMenu";
    }
}
