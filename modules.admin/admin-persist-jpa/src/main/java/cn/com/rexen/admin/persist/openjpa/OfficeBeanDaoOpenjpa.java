package cn.com.rexen.admin.persist.openjpa;

import cn.com.rexen.admin.api.dao.IOfficeBeanDao;
import cn.com.rexen.admin.entities.OfficeBean;
import cn.com.rexen.core.impl.persistence.GenericOpenJpaDao;

/**
 * @类描述：机构Dao实现类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午2:00
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public class OfficeBeanDaoOpenjpa extends GenericOpenJpaDao<OfficeBean, Long> implements IOfficeBeanDao {
}
