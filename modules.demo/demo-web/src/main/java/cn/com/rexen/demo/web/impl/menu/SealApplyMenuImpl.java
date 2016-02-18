package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 公告菜单
 *
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class SealApplyMenuImpl implements IMenu {
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
        return "sealApplyMenu";
    }

    @Override
    public String getText() {
        return "印章使用申请";
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
        return "demo/SealApply";
    }

    @Override
    public int getIndex() {
        return 40;
    }

    @Override
    public String getPermission() {
        return Const.APPLICATION_NAME + ":" + getModuleId() + ":" + getId();
    }

    @Override
    public String getIconCls() {
        return "x-fa fa-calendar";
    }
}
