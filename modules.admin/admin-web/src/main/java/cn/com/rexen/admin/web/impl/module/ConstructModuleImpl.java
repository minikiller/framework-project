package cn.com.rexen.admin.web.impl.module;

import cn.com.rexen.admin.web.impl.Const;
import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.api.web.IModule;

import java.util.List;

/**
 * 组织结构模块
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ConstructModuleImpl implements IModule {
    @Override
    public List<IMenu> getMenus() {
        return null;
    }

    @Override
    public String getApplicationId() {
        return Const.APP_NAME;
    }

    @Override
    public String getId() {
        return "constructModule";
    }

    @Override
    public String getText() {
        return "组织结构";
    }

    @Override
    public String getDescription() {
        return "组织结构";
    }

    @Override
    public String getIcon() {
        return "resources/images/wrench.png";
    }

    @Override
    public String getRouteId() {
        return null;
    }

    @Override
    public int getIndex() {
        return 5;
    }

    @Override
    public String getPermission() {
        return Const.APP_NAME + ":" + getId();
    }

    @Override
    public String getIconCls() {
        return "iconfont icon-organization";
    }

    @Override
    public boolean isExpanded() {
        return false;
    }

    @Override
    public boolean isSelectable() {
        return false;
    }
}
