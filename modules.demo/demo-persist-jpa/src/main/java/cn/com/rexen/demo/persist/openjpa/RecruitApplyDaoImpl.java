package cn.com.rexen.demo.persist.openjpa;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.demo.api.dao.IRecruitApplyDao;
import cn.com.rexen.demo.entities.RecruitApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zangyanming on 2016/6/15.
 */
public class RecruitApplyDaoImpl extends GenericDao<RecruitApplyBean, Long> implements IRecruitApplyDao {
    @Override
    @PersistenceContext(unitName = "demo-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
