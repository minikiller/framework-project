package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IDepartmentBeanDao;
import cn.com.rexen.admin.entities.DepartmentBean;

/**
 * 部门管理DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class DepartmentBeanDaoImpl extends BaseAdminDao<DepartmentBean, Long> implements IDepartmentBeanDao {
    private final String className = DepartmentBean.class.getName();

}
