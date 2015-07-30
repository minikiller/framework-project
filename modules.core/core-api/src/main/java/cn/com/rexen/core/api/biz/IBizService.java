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

    /**
     * 删除前执行函数.
     * @param id
     * @param status
     */
    public void beforeDeleteEntity(Long id,JsonStatus status);

    /**
     * 删除后执行函数
     * @param id
     * @param status
     */
    public void afterDeleteEntity(Long id,JsonStatus status);

    /**
     * 是否执行删除.
     * @param entityId
     * @param status
     * @return
     */
    public boolean isDelete(Long entityId,JsonStatus status);

    /**
     * 删除实体.
     * @param entityId
     * @return
     */
    public JsonStatus deleteEntity(long entityId);

    /**
     * 执行删除.
     * @param entityId
     * @param jsonStatus
     */
    public void doDelete(long entityId,JsonStatus jsonStatus);

    /**
     * 保存前执行.
     * @param entity
     * @param status
     */
    public void beforeSaveEntity(T entity,JsonStatus status);

    /**
     * 保存后执行.
     * @param entity
     * @param status
     */
    public void afterSaveEntity(T entity,JsonStatus status);

    /**
     * 是否保存.
     * @param entity
     * @param status
     * @return
     */
    public boolean isSave(T entity,JsonStatus status);

    /**
     * 保存实体.
     * @param entity
     * @return
     */
    public JsonStatus saveEntity(T entity);

    /**
     * 执行保存.
     * @param entity
     * @param jsonStatus
     */
    public void doSave(T entity,JsonStatus jsonStatus);

    /**
     * 更新前执行.
     * @param entity
     * @param status
     */
    public void beforeUpdateEntity(T entity,JsonStatus status);

    /**
     * 更新后执行.
     * @param entity
     * @param status
     */
    public void afterUpdateEntity(T entity,JsonStatus status);

    /**
     * 是否更新.
     * @param entity
     * @param status
     * @return
     */
    public boolean isUpdate(T entity,JsonStatus status);

    /**
     * 更新实体.
     * @param entity
     * @return
     */
    public JsonStatus updateEntity(T entity);

    /**
     * 执行更新.
     * @param entity
     * @param jsonStatus
     */
    public void doUpdate(T entity,JsonStatus jsonStatus);

    Object saveEntityAndReturn(PersistentEntity entity);

    public JsonData getAllEntity(int pageNumber, int pageSize);

    public List getAllEntity();

    public T getEntity(long entityId);

}
