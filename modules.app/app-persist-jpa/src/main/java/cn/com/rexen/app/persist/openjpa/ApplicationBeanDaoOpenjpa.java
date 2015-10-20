package cn.com.rexen.app.persist.openjpa;

import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 应用DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */

public class ApplicationBeanDaoOpenjpa extends GenericOpenJpaDao<ApplicationBean, Long> implements IApplicationBeanDao {
    private final String className = ApplicationBean.class.getName();

}
