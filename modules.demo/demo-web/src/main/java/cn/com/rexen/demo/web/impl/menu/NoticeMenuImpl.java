package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 公告菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class NoticeMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return Const.WORKFLOW_MODULE_NAME;
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "noticeMenu";
    }

    @Override
    public String getText() {
        return "流程演示管理";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getIcon() {
        return "admin/resources/images/building.png";
    }

    @Override
    public String getRouteId() {
        return "demo/Notice";
    }

    @Override
    public int getIndex() {
        return 30;
    }

    @Override
    public String getPermission() {
        return Const.APPLICATION_NAME + ":" + getModuleId() + ":" + getId();
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-file-o";
    }
}
