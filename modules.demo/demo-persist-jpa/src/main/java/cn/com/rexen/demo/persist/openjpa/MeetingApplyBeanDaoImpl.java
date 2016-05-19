package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.IMeetingApplyBeanDao;
import cn.com.rexen.demo.entities.MeetingApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class MeetingApplyBeanDaoImpl extends GenericDao<MeetingApplyBean, Long> implements IMeetingApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
