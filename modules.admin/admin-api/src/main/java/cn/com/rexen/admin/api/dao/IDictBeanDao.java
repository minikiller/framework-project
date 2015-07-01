package cn.com.rexen.admin.api.dao;

import com.daren.admin.entities.DictBean;
import com.daren.core.api.persistence.IGenericDao;

import java.util.List;

/**
 * @类描述：字典dao接口类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:57
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public interface IDictBeanDao extends IGenericDao<DictBean, Long> {
    List<DictBean> getDictList(String type);
}
