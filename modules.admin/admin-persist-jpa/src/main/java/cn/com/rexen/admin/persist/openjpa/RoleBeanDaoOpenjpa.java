package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

import javax.persistence.Query;
import java.util.List;

/**
 * @类描述：角色dao实现类
 * @创建人：sunlf
 * @创建时间：2014-04-03 下午6:32
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class RoleBeanDaoOpenjpa extends GenericOpenJpaDao<RoleBean, Long> implements IRoleBeanDao {
    private final String className = RoleBean.class.getName();
    @Override
    public List<String> getRoleNameList() {
        /*List<RoleBean> roleBeanList=super.getAll(RoleBean.class.getName());
        if(roleBeanList!=null){
            roleNameList=new ArrayList<String>();
            for(RoleBean roleBean:roleBeanList){
                roleNameList.add(roleBean.getName());
            }
        }*/
        final Query query = entityManager.createQuery("select c.name from RoleBean c ");
        final List<String> resultList = query.getResultList();
        return resultList;
    }


    @Override
    public void removeRole(Long roleId) {
        super.remove(className, roleId);
    }

    @Override
    public RoleBean getRole(String roleName) {
        RoleBean roleBean = this.findUnique("select u from RoleBean u where u.name=?1", roleName);
        return roleBean;
    }

    @Override
    public RoleBean getRole(Long roleId) {
        return super.get(className, roleId);
    }

    @Override
    public RoleBean saveRole(RoleBean role) {
        return super.save(role);
    }


    @Override
    public List<String> getRoleNameList(UserBean userBean) {
        final Query query = this.createQuery("select d.name from RoleBean d inner join d.userList t   where t.id = ?1", userBean.getId());
        final List<String> resultList = query.getResultList();
        return resultList;
    }
}
