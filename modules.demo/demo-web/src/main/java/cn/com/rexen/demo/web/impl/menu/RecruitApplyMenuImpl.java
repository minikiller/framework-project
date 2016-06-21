package cn.com.rexen.demo.web.impl.menu;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.demo.web.Const;

/**
 * 用车申请
 *
 * @author sunlf <br/>
 *         date:2016-2-24
 * @version 1.0.0
 */
public class RecruitApplyMenuImpl implements IMenu {
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
        return "recruitApplyMenu";
    }

    @Override
    public String getText() {
        return "用工招聘申请";
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
        return "demo/RecruitApply";
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
        return "iconfont icon-public-car";
    }
}
