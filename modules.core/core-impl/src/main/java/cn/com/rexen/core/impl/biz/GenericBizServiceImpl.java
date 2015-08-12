package cn.com.rexen.core.impl.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.web.model.QueryDTO;
import cn.com.rexen.core.util.Assert;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @类描述： 对外服务的抽象接口实现, 封装了基本的对数据库的操作
 * @创建人：sunlf
 * @创建时间：2014-3-27 下午1:01:59
 * @修改人：sunlf
 * @修改时间：2014-3-27 下午1:01:59
 * @修改备注：
 */
public abstract class GenericBizServiceImpl<T extends IGenericDao> implements IBizService {
    protected final Logger log = Logger.getLogger(getClass());
    private T dao;
    private String entityClassName;


    @Override
    public void doDelete(long entityId,JsonStatus jsonStatus) {
        dao.remove(entityClassName, entityId);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("删除成功！");
    }

    @Override
    public void doSave(PersistentEntity entity,JsonStatus jsonStatus) {
        dao.save(entity);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("新增成功！");
    }

    @Override
    public void doUpdate(PersistentEntity entity,JsonStatus jsonStatus) {
        dao.save(entity);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("修改成功！");
    }

    @Override
    public void beforeDeleteEntity(Long id, JsonStatus status) {

    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {

    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        return true;
    }

    @Override
    @ApiOperation(value = "删除实体", httpMethod = "DELETE", response = JsonStatus.class, notes = "add user")
    public JsonStatus deleteEntity(@ApiParam(required = true, name = "entityId", value = "信息json数据") long entityId) {
        log.debug("remove entity of " + entityClassName + ";PK is " + entityId);
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (isDelete(entityId, jsonStatus)) {
                beforeDeleteEntity(entityId, jsonStatus);
                doDelete(entityId,jsonStatus);
                afterDeleteEntity(entityId, jsonStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("删除失败！");
        }
        return jsonStatus;
    }

    @Override
    public void beforeSaveEntity(PersistentEntity entity, JsonStatus status) {

    }

    @Override
    public void afterSaveEntity(PersistentEntity entity, JsonStatus status) {

    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        return true;
    }


    @Override
    public JsonStatus saveEntity(PersistentEntity entity) {

        log.debug("save entity of " + entityClassName);
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if(isSave(entity,jsonStatus)) {
                beforeSaveEntity(entity, jsonStatus);
                doSave(entity,jsonStatus);
                afterSaveEntity(entity, jsonStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg( "新增失败！");
        }
        return jsonStatus;

    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {

    }

    @Override
    public void afterUpdateEntity(PersistentEntity entity, JsonStatus status) {

    }

    @Override
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        return true;
    }

    @Override
    public JsonStatus updateEntity(PersistentEntity entity) {

        log.debug("update entity of " + entityClassName);
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if(isUpdate(entity,jsonStatus)) {
                beforeUpdateEntity(entity, jsonStatus);
                doUpdate(entity,jsonStatus);
                afterUpdateEntity(entity, jsonStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg( "修改失败！");
        }
        return jsonStatus;
    }


    @Override
    public Object saveEntityAndReturn(PersistentEntity entity) {
        return dao.save(entity);
    }

    @Override
    public CriteriaQuery buildCriteriaQuery(QueryDTO queryDTO) {
        return null;
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Assert.notNull(queryDTO,"查询条件不能为空.");
        return dao.getAll(queryDTO.getPage(),queryDTO.getLimit(),entityClassName,buildCriteriaQuery(queryDTO));
    }

    @Override
    public JsonData getAllEntity(@ApiParam(required = true, name = "pageNumber", value = "用户信息json数据") int pageNumber,
                                 @ApiParam(required = true, name = "pageSize", value = "用户信息json数据") int pageSize) {
        return dao.getAll(pageNumber, pageSize, entityClassName);
    }

    @Override
    public List getAllEntity() {
        return dao.getAll(entityClassName);
    }

    @Override
    public PersistentEntity getEntity(long entityId) {
        return (PersistentEntity) dao.get(entityClassName, entityId);
    }

    /**
     * 具体的业务类必须调用该方法
     *
     * @param dao             具体的dao实现类
     * @param entityClassName 实体类的名字
     */
    public void init(T dao, String entityClassName) {
        this.dao = dao;
        this.entityClassName = entityClassName;
    }
}
