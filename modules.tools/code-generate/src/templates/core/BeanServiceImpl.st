package <packageName>.core.biz;

import <packageName>.api.biz.I<beanName>BeanService;
import <packageName>.api.dao.I<beanName>BeanDao;
import <packageName>.entities.<beanName>Bean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;

import java.util.List;
import java.util.UUID;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class <beanName>BeanServiceImpl extends GenericBizServiceImpl implements I<beanName>BeanService {
    private I<beanName>BeanDao <pomName>BeanDao;

    private JsonStatus jsonStatus = new JsonStatus();

    private String uuid;

    public <beanName>BeanServiceImpl() {
        uuid = UUID.randomUUID().toString();
    }

    public void set<beanName>BeanDao(I<beanName>BeanDao <pomName>BeanDao) {
        this.<pomName>BeanDao = <pomName>BeanDao;
        super.init(<pomName>BeanDao, <beanName>Bean.class.getName());
    }


}
