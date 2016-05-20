package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 会议申请
 *
 * @author zangyanming <br/>
 *         date:2016-5-18
 * @version 1.0.0
 */
public class MeetingApplyMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return Const.WORKFLOW_BIZ_MODULE_NAME;
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "meetingApplyMenu";
    }

    @Override
    public String getText() {
        return "会议室使用申请";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public String getRouteId() {
        return "demo/MeetingApply";
    }

    @Override
    public int getIndex() {
        return 70;
    }

    @Override
    public String getPermission() {
//        return Const.APPLICATION_NAME + ":" + getModuleId() + ":" + getId();
        return "";
    }

    @Override
    public String getIconCls() {
        return "fa fa-users";
    }
}
