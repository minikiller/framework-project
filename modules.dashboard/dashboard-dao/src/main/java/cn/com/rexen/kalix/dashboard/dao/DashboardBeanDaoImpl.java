package cn.com.rexen.kalix.dashboard.dao;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.kalix.dashboard.api.dao.IDashboardBeanDao;
import cn.com.rexen.kalix.dashboard.entities.DashboardBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chenyanxu on 2016/5/18.
 */
public class DashboardBeanDaoImpl extends GenericDao<DashboardBean,Long> implements IDashboardBeanDao {
    @Override
    @PersistenceContext(unitName = "dashboard-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
