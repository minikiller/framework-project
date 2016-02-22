package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 消息通知
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
        return Const.MY_WORKING_MODULE_NAME;
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
        return "消息通知";
    }

    @Override
    public String getDescription() {
        return "消息通知列表";
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return Const.APPLICATION_NAME + "/Message";
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
        return "x-fa fa-envelope";
    }
}
