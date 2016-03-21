package cn.com.rexen.bean.web.impl;

import cn.com.rexen.bean.web.Const;
import cn.com.rexen.core.api.web.IMenu;

/**
 * 已发消息通知
 *
 * @author zangyanming <br/>
 *         date:2016-2-26
 * @version 1.0.0
 */
public class ReceiverMessageMenuImpl implements IMenu {
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
        return "messageReceiverMenu";
    }

    @Override
    public String getText() {
        return "收件箱";
    }

    @Override
    public String getDescription() {
        return "收件箱";
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return "message/receiver";
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public String getPermission() {
//        return Const.APPLICATION_NAME + ":" + getModuleId() + ":" + getId();
        return "";
    }


    @Override
    public String getIconCls() {
        return "x-fa fa-inbox";
    }
}
