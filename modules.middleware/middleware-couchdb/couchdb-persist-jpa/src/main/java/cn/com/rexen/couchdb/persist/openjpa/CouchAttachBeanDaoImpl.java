package cn.com.rexen.couchdb.persist.openjpa;


import cn.com.rexen.core.impl.persistence.GenericDao;
import cn.com.rexen.couchdb.api.dao.ICouchdbAttachBeanDao;
import cn.com.rexen.couchdb.entities.CouchdbAttachBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dell on 14-1-16.
 */
public class CouchAttachBeanDaoImpl extends GenericDao<CouchdbAttachBean, Long> implements ICouchdbAttachBeanDao {
    @Override
    @PersistenceContext(unitName = "couchdb-cm")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
