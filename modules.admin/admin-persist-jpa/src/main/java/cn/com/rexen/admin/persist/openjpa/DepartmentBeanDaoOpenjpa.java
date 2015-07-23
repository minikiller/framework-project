package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IDepartmentBeanDao;
import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 部门管理DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class DepartmentBeanDaoOpenjpa extends GenericOpenJpaDao<DepartmentBean, Long> implements IDepartmentBeanDao {
    private final String className = DepartmentBean.class.getName();


    @Override
    public void remove(Long orgId) {
        super.remove(className, orgId);
    }



    @Override
    public DepartmentBean get(Long orgId) {
        return super.get(className, orgId);
    }

    @Override
    public DepartmentBean save(DepartmentBean bean) {
        return super.save(bean);
    }

}
