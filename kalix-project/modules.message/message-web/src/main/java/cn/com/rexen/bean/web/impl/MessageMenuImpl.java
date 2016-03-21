package cn.com.rexen.bean.web.impl;

import cn.com.rexen.bean.web.Const;
import cn.com.rexen.core.api.web.IMenu;

/**
 * 已发消息通知
 *
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class MessageMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return Const.MY_MESSAGE_MODULE_NAME;
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
    public String getText() {
        return "发件箱";
    }

    @Override
    public String getDescription() {
        return "发件箱";
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return "message/sender";
    }

    @Override
    public int getIndex() {
        return 10;
    }

    @Override
    public String getPermission() {
//        return Const.APPLICATION_NAME + ":" + getModuleId() + ":" + getId();
        return "";
    }


    @Override
    public String getIconCls() {
        return "x-fa fa-share";
    }
}
