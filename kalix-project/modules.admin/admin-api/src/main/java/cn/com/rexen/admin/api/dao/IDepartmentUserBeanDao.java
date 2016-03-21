package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.DepartmentUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 部门用户关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IDepartmentUserBeanDao extends IGenericDao<DepartmentUserBean, Long> {
    void deleteByDepartmentId(long id);

    long findDepartmentIdByUserId(long userId);
}
