package cn.com.rexen.core.api.web;


/**
 * Created by sunlf on 2015/7/13.
 */
public interface IMenu extends IBaseWebPage {
    boolean isLeaf();

    String getModuleId();

    String getParentMenuId();
}
