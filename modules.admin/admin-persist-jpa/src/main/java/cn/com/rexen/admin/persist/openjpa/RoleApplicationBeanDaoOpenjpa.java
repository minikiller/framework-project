package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IRoleApplicationBeanDao;
import cn.com.rexen.admin.api.dao.IRoleUserBeanDao;
import cn.com.rexen.admin.entities.RoleApplicationBean;
import cn.com.rexen.admin.entities.RoleUserBean;
import cn.com.rexen.admin.entities.WorkGroupUserBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 角色应用DAO实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class RoleApplicationBeanDaoOpenjpa extends GenericOpenJpaDao<RoleApplicationBean, Long> implements IRoleApplicationBeanDao {
    private final String className = RoleApplicationBean.class.getName();

    @Override
    public void deleteByRoleId(long id) {
        super.updateNativeQuery("delete from sys_role_application where roleId="+id);
    }
}
