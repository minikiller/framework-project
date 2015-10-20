package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IAboutBeanDao;
import cn.com.rexen.admin.entities.AboutBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * 项目名称:  urgent-project
 * 类描述:    系统版本Dao实现类
 * 创建人:    sunlf
 * 创建时间:  2014/8/7 15:57
 * 修改人:    sunlf
 * 修改时间:  2014/8/7 15:57
 * 修改备注:  [说明本次修改内容]
 */
public class AboutBeanDaoOpenjpa extends GenericOpenJpaDao<AboutBean, Long> implements IAboutBeanDao {
}
