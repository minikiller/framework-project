package cn.com.rexen.kalix.dashboard.core.biz;

import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.kalix.dashboard.api.biz.IDashboardBeanService;
import cn.com.rexen.kalix.dashboard.api.dao.IDashboardBeanDao;
import cn.com.rexen.kalix.dashboard.entities.DashboardBean;

/**
 * Created by chenyanxu on 2016/5/18.
 */
public class DashboardBeanServiceImpl extends ShiroGenericBizServiceImpl<IDashboardBeanDao,DashboardBean> implements IDashboardBeanService {
}
