package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 机构管理DAO实现
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public class OrganizationBeanDaoOpenjpa extends GenericOpenJpaDao<OrganizationBean, Long> implements IOrganizationBeanDao {
    private final String className = OrganizationBean.class.getName();


    @Override
    public void removeOrg(Long orgId) {
        super.remove(className, orgId);
    }



    @Override
    public OrganizationBean getOrg(Long orgId) {
        return super.get(className, orgId);
    }

    @Override
    public OrganizationBean saveOrg(OrganizationBean org) {
        return super.save(org);
    }

}
