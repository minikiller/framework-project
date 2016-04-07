package cn.com.rexen.core.impl.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.web.model.BaseDTO;
import cn.com.rexen.core.api.web.model.QueryDTO;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.BeanUtil;
import cn.com.rexen.core.util.SerializeUtil;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.*;


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
    private EventAdmin eventAdmin;

    public GenericBizServiceImpl() {
        Object obj = this.getClass().getGenericSuperclass();
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        java.lang.reflect.Type type = genericSuperclass.getActualTypeArguments()[1];
        if (type instanceof Class) {
            this.entityClassName = ((Class<T>) type).getName();
        } else if (type instanceof ParameterizedType) {
            this.entityClassName = ((Class<T>) ((ParameterizedType) type).getRawType()).getName();
        }
    }

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
    public void doBatchDelete(String entityIds, JsonStatus jsonStatus) {
        dao.removeBatch(entityIds);
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("批量删除成功！");
    }

    @Override
    @Transactional
    public void doSave(TP entity, JsonStatus jsonStatus) {
        if (entity.getId() == 0) {
            jsonStatus.setMsg("新增成功！");
        } else {
            jsonStatus.setMsg("修改成功！");
        }

        PersistentEntity newObj = (PersistentEntity) dao.save(entity);

        jsonStatus.setTag(String.valueOf(newObj.getId()));
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
        postEvent(this.entityClassName.replace(".", "/") + "/before/delete", id);
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {
        postEvent(this.entityClassName.replace(".", "/") + "/after/delete", id);
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

    public JsonStatus batchDeleteEntity(String entityIds) {
        log.debug("remove entities of " + entityClassName + ";PKS is " + entityIds);
        JsonStatus jsonStatus = new JsonStatus();
        try {
            doBatchDelete(entityIds, jsonStatus);
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("批量删除失败！");
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
        postEvent(this.entityClassName.replace(".", "/") + "/before/save", entity);
    }

    @Override
    @Transactional
    public void afterSaveEntity(TP entity, JsonStatus status) {
        postEvent(this.entityClassName.replace(".", "/") + "/after/save", entity);
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
        postEvent(this.entityClassName.replace(".", "/") + "/before/update", entity);
    }

    @Override
    public void afterUpdateEntity(TP entity, JsonStatus status) {
        postEvent(this.entityClassName.replace(".", "/") + "/after/update", entity);
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

    /**
     * 只适应于字符类型的关联查询场景，需要自己实现getNativeQueryStr和getResultClass方法
     *
     * @param page
     * @param limit
     * @param jsonStr
     * @return
     */
    @Override
    public JsonData getAllByNativeQuery(int page, int limit, String jsonStr) {

        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        //获得查询的sql语句
        String sql = getNativeQueryStr();
        Assert.notNull(sql, "查询条件不能为空.");
        //获得返回的结果类
        Class<? extends BaseDTO> cls = getResultClass();
        Assert.notNull(cls, "返回查询结果类不能为空.");

        String posSql = " order by a.creationDate desc";
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            sql = sql + " and a." + entry.getKey() + " like '%" + entry.getValue() + "%'";
        }

        return dao.findByNativeSql(sql + posSql, page, limit, cls, null);
    }

    /**
     * 需要重写该类实现getAllByNativeQuery
     *
     * @return
     */
    protected String getNativeQueryStr() {
        return null;
    }

    /**
     * 需要重写该类实现getAllByNativeQuery
     *
     * @return
     */
    protected Class<? extends BaseDTO> getResultClass() {
        return null;
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

    /**
     * 用于报表的查询，返回全部数据
     *
     * @return
     */
    @Override
    public JsonData getAllEntityforReport(String jsonStr) {
        QueryDTO queryDto = new QueryDTO();
        queryDto.setJsonMap(SerializeUtil.json2Map(jsonStr));
        return dao.getAll(dao.buildCriteriaQuery(queryDto));
    }

    @Override
    public TP getEntity(long entityId) {
        return (TP) dao.get(entityId);
    }

    @Override
    public List<Object> getFieldValuesByIds(Object[] ids,String fieldName){
        String sql="SELECT a FROM %s a WHERE a.id in (%s)";
        List queryIds=new ArrayList<Long>();

        for(int index=0;index<ids.length;++index){
            if(!queryIds.contains(ids[index])){
                queryIds.add(ids[index]);
            }
        }

        sql=String.format(sql,this.entityClassName, StringUtils.join(queryIds,","));

        List records = this.dao.find(sql);

        if(records.size()>0){
            Map fieldValueMap =BeanUtil.getBeanListFieldValues(records,fieldName);
            List rtn=new ArrayList<Object>();

            for(int idsIndex=0;idsIndex<ids.length;++idsIndex){
                rtn.add(fieldValueMap.get(ids[idsIndex].toString()));
            }

            return rtn;
        }

        return null;
    }


    /**
     * 具体的业务类必须调用该方法
     *
     * @param entityClassName 实体类的名字
     */
    public void init(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public void setEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    private void postEvent(String topic, Object obj) {
        if (eventAdmin != null) {
            Gson gson = new Gson();
            Dictionary properties = new Hashtable();
            properties.put("message", gson.toJson(obj));
            Event event = new Event(topic, properties);
            eventAdmin.postEvent(event);
        }
    }
}
