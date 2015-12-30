package cn.com.rexen.app.core;

import cn.com.rexen.app.api.biz.IPluginBeanService;
import cn.com.rexen.app.api.dao.IPluginBeanDao;
import cn.com.rexen.app.entities.PluginBean;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

/**
 * 插件服务实现
 *
 * @author sunlf <br/>
 *         date:2015-10-27
 * @version 1.0.0
 */
public class PluginBeanServiceImpl extends GenericBizServiceImpl<IPluginBeanDao, PluginBean> implements IPluginBeanService {
    public PluginBeanServiceImpl() {
        super.init(PluginBean.class.getName());
    }
}