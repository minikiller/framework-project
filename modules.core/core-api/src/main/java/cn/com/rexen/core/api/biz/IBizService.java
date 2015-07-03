package cn.com.rexen.core.api.biz;

import cn.com.rexen.core.api.IService;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;

import java.util.List;

/**
 * @类描述： 对外业务服务的根接口
 * @创建人：sunlf
 * @创建时间：2014-3-27 下午1:01:59
 * @修改人：sunlf
 * @修改时间：2014-3-27 下午1:01:59
 * @修改备注：
 */


public interface IBizService<T extends PersistentEntity> extends IService {

    public void deleteEntity(long entityId);

    public void saveEntity(T entity);

    Object saveEntityAndReturn(PersistentEntity entity);

    public JsonData getAllEntity(int pageNumber, int pageSize);

    public List getAllEntity();

    public T getEntity(long entityId);

}
