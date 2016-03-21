package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.entities.OrganizationBean;

/**
 * 机构管理DAO实现
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public class OrganizationBeanDaoImpl extends BaseAdminDao<OrganizationBean, Long> implements IOrganizationBeanDao {
    private final String className = OrganizationBean.class.getName();


    @Override
    public void removeOrg(Long orgId) {
        super.remove(orgId);
    }



    @Override
    public OrganizationBean getOrg(Long orgId) {
        return super.get(orgId);
    }

    @Override
    public OrganizationBean saveOrg(OrganizationBean org) {
        return super.save(org);
    }

}
