package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.dto.model.query.UserDTO;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.web.model.QueryDTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 14-1-16.
 */

public class UserBeanDaoImpl extends BaseAdminDao<UserBean, Long> implements IUserBeanDao {
    private final String className = UserBean.class.getName();

    /**
     * Constructor that sets the entity to User.class.
     */
    public UserBeanDaoImpl() {
//        super.setEntityManager(UserBean.class);
    }

    @Override
    public JsonData getUserList(int page,int limit) {
        log.debug("get user info");
        return super.getAll(page,limit,className);
    }

    @Override
    public UserBean saveUser(UserBean user) {
        return super.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        super.remove(className, userId);
    }

    @Override
    public UserBean getUser(Long userId) {
        return super.get(className, userId);
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public UserBean getUser(String username) {
        UserBean user = this.findUnique("select u from UserBean u where u.loginName=?1", username);
        return user;
    }

    @Override
    public void updateUserLoginInfo(long id, String loginIp) {
        this.update("update UserBean u set u.loginIp=?1, u.loginDate=?2 where u.id = ?3", loginIp, new Date(), id);
    }

    @Override
    public CriteriaQuery buildCriteriaQuery(QueryDTO queryDTO) {
        UserDTO userDTO = (UserDTO) queryDTO;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserBean> criteriaQuery = criteriaBuilder.createQuery(UserBean.class);
        Root<UserBean> from = criteriaQuery.from(UserBean.class);
        EntityType<UserBean> userBean_ = from.getModel(); //实体元数据
        List<Predicate> predicatesList = new ArrayList<Predicate>();

        if (userDTO.getName() != null && !userDTO.getName().trim().isEmpty()) {
            SingularAttribute<UserBean, String> name = (SingularAttribute<UserBean, String>) userBean_.getSingularAttribute("name");
            predicatesList.add(criteriaBuilder.like(from.get(name), "%" + userDTO.getName() + "%"));
        }
        if (userDTO.getLoginName() != null && !userDTO.getLoginName().trim().isEmpty()) {
            SingularAttribute<UserBean, String> loginName = (SingularAttribute<UserBean, String>) userBean_.getSingularAttribute("loginName");
            predicatesList.add(criteriaBuilder.like(from.get(loginName), "%" + userDTO.getLoginName() + "%"));
        }
        if (userDTO.getAvailable() != -1) {
            SingularAttribute<UserBean, Integer> available = (SingularAttribute<UserBean, Integer>) userBean_.getSingularAttribute("available");
            predicatesList.add(criteriaBuilder.equal(from.get(available), userDTO.getAvailable()));
        }
        criteriaQuery.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        CriteriaQuery select = criteriaQuery.select(from);
        return select;
    }


}
