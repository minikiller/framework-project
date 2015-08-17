package cn.com.rexen.core.api.web;

import java.util.List;

/**
 * Created by sunlf on 2015/7/13.
 */
public interface IApplication extends IBaseWebPage {
    /**
     * 返回模块列表
     * @return
     */
    List<IModule> getModules();
}
