package cn.com.rexen.app.persist.openjpa;

import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.api.dao.IFunctionBeanDao;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.app.entities.FunctionBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 功能DAO接口
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */

public class FunctionBeanDaoOpenjpa extends GenericOpenJpaDao<FunctionBean, Long> implements IFunctionBeanDao {
    private final String className = FunctionBean.class.getName();

}
