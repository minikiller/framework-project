package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 流程定义菜单
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class ProcessDefinitionMenuImpl implements IMenu {
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
        return "processDefinitionMenu";
    }

    @Override
    public String getText() {
        return "流程定义管理";
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
        return Const.APPLICATION_NAME + "/processdefinition";
    }

    @Override
    public int getIndex() {
        return 10;
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
