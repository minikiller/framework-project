package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.IWorkFlowBeanDao;
import cn.com.rexen.demo.entities.WorkFlowBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class WorkFlowBeanDaoImpl extends GenericDao<WorkFlowBean, Long> implements IWorkFlowBeanDao {
    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
