package cn.com.rexen.core.api.web;

import cn.com.rexen.core.api.web.model.ApplicationBean;
import cn.com.rexen.core.api.web.model.MenuBean;
import cn.com.rexen.core.api.web.model.ModuleBean;
import cn.com.rexen.core.api.web.model.SystemBean;

import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2015/7/13.
 * osgi rest service
 */
public interface ISystemService {
    SystemBean getSystem();

    List<ApplicationBean> getApplicationList();

    List<ModuleBean> getModuleByApplication(String applicationId);

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
}
