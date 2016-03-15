package cn.com.rexen.duty.api.dao;

import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.duty.entities.DutyUserBean;

/**
 * Created by zangyanming on 2016/3/15.
 */
public interface IDutyUserBeanDao extends IGenericDao<DutyUserBean, Long> {
    void deleteByDutyId(long depId, long id);

    long findDutyIdByUserId(long depid, long userId);
}