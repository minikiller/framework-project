package cn.com.rexen.core.impl.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.web.model.QueryDTO;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.SerializeUtil;
import org.apache.log4j.Logger;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @类描述： 对外服务的抽象接口实现, 封装了基本的对数据库的操作
 * @创建人：sunlf
 * @创建时间：2014-3-27 下午1:01:59
 * @修改人：chenyanxu
 * @修改时间：2015-10-27 下午1:01:59
 * @修改备注：
 */
public abstract class GenericBizServiceImpl<T extends IGenericDao, TP extends PersistentEntity> implements IBizService<TP> {
    protected final Logger log = Logger.getLogger(getClass());
    protected T dao;
    protected String entityClassName;

    public void setDao(T dao) {
        this.dao = dao;
    }

    @Override
    public void doDelete(long entityId,JsonStatus jsonStatus) {
        dao.remove(entityId);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("删除成功！");
    }

    @Override
    @Transactional
    public void doSave(TP entity, JsonStatus jsonStatus) {
        if (entity.getId() == 0) {
            jsonStatus.setMsg("新增成功！");
        } else {
            jsonStatus.setMsg("修改成功！");
        }
        dao.save(entity);
        jsonStatus.setSuccess(true);
    }

    @Override
    public void doUpdate(TP entity, JsonStatus jsonStatus) {
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
    public JsonStatus deleteEntity(long entityId) {
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
    public JsonStatus removeEntity(TP entity) {
        return deleteEntity(entity.getId());
    }

    @Override
    @Transactional
    public void beforeSaveEntity(TP entity, JsonStatus status) {

    }

    @Override
    @Transactional
    public void afterSaveEntity(TP entity, JsonStatus status) {

    }

    @Override
    public boolean isSave(TP entity, JsonStatus status) {
        return true;
    }


    @Override
    @Transactional
    public JsonStatus saveEntity(TP entity) {
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
            /*if (entity.getId() == 0)
                jsonStatus.setMsg("新增失败！");
            else
                jsonStatus.setMsg("修改失败！");*/
            jsonStatus.setMsg("服务器异常，操作失败！");
        }
        return jsonStatus;

    }

    @Override
    public void beforeUpdateEntity(TP entity, JsonStatus status) {

    }

    @Override
    public void afterUpdateEntity(TP entity, JsonStatus status) {

    }

    @Override
    public boolean isUpdate(TP entity, JsonStatus status) {
        return true;
    }

    @Override
    public JsonStatus updateEntity(TP entity) {

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
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Assert.notNull(queryDTO, "查询条件不能为空.");
        return dao.getAll(queryDTO.getPage(), queryDTO.getLimit(), dao.buildCriteriaQuery(queryDTO));
    }

    @Override
    public JsonData getAllEntityByQuery(int page, int limit, String jsonStr) {
        QueryDTO queryDto = new QueryDTO();

        queryDto.setPage(page);
        queryDto.setLimit(limit);
        queryDto.setJsonMap(SerializeUtil.json2Map(jsonStr));

        return getAllEntityByQuery(queryDto);
    }

    @Override
    public JsonData getAllEntity(int pageNumber,
                                 int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }

    @Override
    public List getAllEntity() {
        return dao.getAll();
    }

    @Override
    public TP getEntity(long entityId) {
        return (TP) dao.get(entityId);
    }

    /**
     * 具体的业务类必须调用该方法
     *

     * @param entityClassName 实体类的名字
     */
    public void init(String entityClassName) {
        //this.dao = dao;
        this.entityClassName = entityClassName;
    }
}
