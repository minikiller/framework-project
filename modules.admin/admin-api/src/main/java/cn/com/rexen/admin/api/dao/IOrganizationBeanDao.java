package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

import java.util.List;

/**
 * 机构管理DAO接口
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public interface IOrganizationBeanDao extends IGenericDao<OrganizationBean, Long> {


    /**
     * 获得机构.
     * @param orgId
     * @return
     */
    OrganizationBean getOrg(Long orgId);

    /**
     * 删除一个机构.
     *
     * @param orgId 机构ID
     */
    void removeOrg(Long orgId);


    /**
     * 保存机构.
     *
     * @param org the object to be saved
     * @return the persisted User object
     */
    OrganizationBean saveOrg(OrganizationBean org);
}
