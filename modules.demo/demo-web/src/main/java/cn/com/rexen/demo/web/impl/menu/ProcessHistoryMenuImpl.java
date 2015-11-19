package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 流程历史列表
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ProcessHistoryMenuImpl implements IMenu {
    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String getModuleId() {
        return Const.MODULE_NAME;
    }

    @Override
    public String getParentMenuId() {
        return null;
    }

    @Override
    public String getId() {
        return "processHistoryMenu";
    }

    @Override
    public String getText() {
        return "流程历史列表";
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
        return Const.APPLICATION_NAME + "/processhistory";
    }

    @Override
    public int getIndex() {
        return 20;
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
