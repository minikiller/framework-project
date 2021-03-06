package cn.com.rexen.core.api.web;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.web.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/7/13.
 * osgi rest service
 */
public interface ISystemService {
    SystemBean getSystem();

    /**
     * 返回所有应用
     * @return
     */
    List<ApplicationBean> getApplicationList();

    /**
     * 返回指定应用下模块列表
     * @param applicationId
     * @return
     */
    List<ModuleBean> getModuleByApplication(String applicationId);

    /**
     * 返回指定模块下菜单
     * @param moduleId
     * @return
     */
    MenuBean getMenuByModule(String moduleId);

    /**
     * 判断按钮权限
     * 生成JSON如下:
     *    [{
     *        permission:"admin:sysModule:permissionControl:userMenu:add",
     *        status:true
     *    }]
     * @param permission
     * @return
     */
    Map getButtonsByPermission(String permission);

    /**
     * 获得登录组件信息
     * @return
     */
    LoginBean getLogin();

    /**
     * 获取用户偏好
     */
    Map getUserPreferences();
    /**
     * 设置用户偏好
     */
    JsonStatus setUserPreferences(String key, String value);
}
