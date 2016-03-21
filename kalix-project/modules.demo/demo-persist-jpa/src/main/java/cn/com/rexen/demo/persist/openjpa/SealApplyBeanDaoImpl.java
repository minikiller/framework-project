package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.ISealApplyBeanDao;
import cn.com.rexen.demo.entities.SealApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chenyanxu
 */
public class SealApplyBeanDaoImpl extends GenericDao<SealApplyBean, Long> implements ISealApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
