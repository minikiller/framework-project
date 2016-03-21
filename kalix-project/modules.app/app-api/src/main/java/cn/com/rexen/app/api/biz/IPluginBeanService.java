package cn.com.rexen.app.api.biz;

import cn.com.rexen.app.entities.PluginBean;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;

import java.util.Map;

/**
 * 插件服务接口.
 *
 * @author sunlf <br/>
 *         date:2015-12-30
 * @version 1.0.0
 */
public interface IPluginBeanService extends IBizService<PluginBean> {
    JsonStatus startPlugin(String key);

    JsonStatus stopPlugin(String key);

    Map getPluginStatus(String pluginIds);
}
