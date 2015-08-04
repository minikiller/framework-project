package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.RoleApplicationBean;
import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

/**
 * 角色应用关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IRoleApplicationBeanDao extends IGenericDao<RoleApplicationBean, Long> {
    public void deleteByRoleId(long id);
}
