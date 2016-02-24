package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.ICarApplyBeanDao;
import cn.com.rexen.demo.entities.CarApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class CarApplyBeanDaoImpl extends GenericDao<CarApplyBean, Long> implements ICarApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
