package cn.com.rexen.kalix.tooltip.dao;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.kalix.tooltip.api.dao.IToolTipBeanDao;
import cn.com.rexen.kalix.tooltip.entities.ToolTipBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chenyanxu on 2016/5/18.
 */
public class ToolTipBeanDaoImpl extends GenericDao<ToolTipBean,Long> implements IToolTipBeanDao {
    @Override
    @PersistenceContext(unitName = "tooltip-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
