package cn.com.rexen.core.api.web;

import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 */
public interface IModule extends IBaseWebPage {
    List<IMenu> getMenus();

    String getApplicationId();
}