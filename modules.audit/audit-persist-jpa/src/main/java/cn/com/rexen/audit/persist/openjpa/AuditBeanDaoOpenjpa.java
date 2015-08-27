package cn.com.rexen.audit.persist.openjpa;

import cn.com.rexen.audit.api.dao.IAuditBeanDao;
import cn.com.rexen.audit.entities.AuditBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

import java.util.UUID;

/**
 * @类描述：审计管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class AuditBeanDaoOpenjpa extends GenericOpenJpaDao<AuditBean, Long> implements IAuditBeanDao {
    private String uuid;

    public AuditBeanDaoOpenjpa() {
        uuid = UUID.randomUUID().toString();
    }
}
