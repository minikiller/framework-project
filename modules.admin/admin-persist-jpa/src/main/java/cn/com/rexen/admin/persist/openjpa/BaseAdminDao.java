package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.impl.persistence.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by sunlf on 2015/10/26.
 */
public abstract class BaseAdminDao<T extends PersistentEntity, PK extends Serializable> extends GenericDao<T, PK> {
    @Override
    @PersistenceContext(unitName = "admin-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
