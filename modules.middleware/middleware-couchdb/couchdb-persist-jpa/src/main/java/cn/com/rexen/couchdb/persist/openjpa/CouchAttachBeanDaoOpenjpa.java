package cn.com.rexen.couchdb.persist.openjpa;


import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;
import cn.com.rexen.couchdb.api.dao.ICouchdbAttachBeanDao;
import cn.com.rexen.couchdb.entities.CouchdbAttachBean;

/**
 * Created by dell on 14-1-16.
 */
public class CouchAttachBeanDaoOpenjpa extends GenericOpenJpaDao<CouchdbAttachBean, Long> implements ICouchdbAttachBeanDao {

}
