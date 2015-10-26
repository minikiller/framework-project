package <packageName>.dao;

import <packageName>.api.dao.I<beanName>BeanDao;
import <packageName>.entities.<beanName>Bean;
import cn.com.rexen.core.impl.persistence.GenericDao;

import java.util.UUID;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class <beanName>BeanDaoImpl extends GenericOpenJpaDao\<<beanName>Bean, Long> implements I<beanName>BeanDao {
    private String uuid;

    public <beanName>BeanDaoImpl() {
        uuid = UUID.randomUUID().toString();
    }
}
