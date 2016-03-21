package cn.com.rexen.duty.dao;

import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.duty.api.dao.IDutyUserBeanDao;
import cn.com.rexen.duty.entities.DutyUserBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by zangyanming on 2016/3/15.
 */
public class DutyUserBeanDaoImpl extends GenericDao<DutyUserBean, Long> implements IDutyUserBeanDao {
    @Override
    @PersistenceContext(unitName = "duty-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    @Override
    public void deleteByDutyId(long depId, long id) {
        super.updateNativeQuery("delete from sys_duty_user where depId = " + depId + " and dutyId=" + id);
    }

    @Override

    public long findDutyIdByUserId(long depId, long userId) {
        List<DutyUserBean> dutyUserBeanList = findByNativeSql("select * from sys_duty_user where userId=" + userId, DutyUserBean.class, null);
        if (dutyUserBeanList != null && dutyUserBeanList.size() > 0) {
            return dutyUserBeanList.get(0).getDutyId();
        }
        return 0;
    }
}
