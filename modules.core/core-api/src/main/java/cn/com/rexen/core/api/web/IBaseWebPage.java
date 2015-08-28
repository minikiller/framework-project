package cn.com.rexen.core.api.web;

/**
 * Created by sunlf on 2015/7/13.
 * 所有web页面的用于extjs的基础接口
 */
public interface IBaseWebPage {
    String getId();

    //    标题
    String getTitle();

    //    描述
    String getDescription();

    //    图标
    String getIcon();

    //    Extjs组件类名称
    String getComponentClass();

    //    显示的顺序
    int getIndex();

    //返回权限
    String getPermission();

}
