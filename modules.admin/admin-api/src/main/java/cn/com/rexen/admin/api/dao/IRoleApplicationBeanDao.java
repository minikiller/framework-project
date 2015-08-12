package cn.com.rexen.admin.api.dao;

import cn.com.rexen.admin.entities.RoleApplicationBean;
import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.core.api.persistence.IGenericDao;

import java.util.List;

/**
 * 角色应用关联DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public interface IRoleApplicationBeanDao extends IGenericDao<RoleApplicationBean, Long> {
    /**
     * 根据角色ID删除所有关联
     * @param id
     */
    public void deleteByRoleId(long id);

    /**
     * 返回指定角色下所有与应用的关联
     * @param id
     * @return
     */
    public List<RoleApplicationBean> getRoleApplicationsByRoleId(long id);
}
