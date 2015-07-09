package cn.com.rexen.core.impl.biz;

import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;

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
    @ApiOperation(value = "添加用户", httpMethod = "DELETE", response = JsonStatus.class, notes = "add user")
    public JsonStatus deleteEntity(@ApiParam(required = true, name = "entityId", value = "用户信息json数据") long entityId) {
        log.debug("remove entity of " + entityClassName + ";PK is " + entityId);
        JsonStatus jsonStatus = new JsonStatus();
        try {
            dao.remove(entityClassName, entityId);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("删除失败！");
        }
        return jsonStatus;
    }

    @Override
    public JsonStatus saveEntity(PersistentEntity entity) {

        log.debug("save entity of " + entityClassName);
        JsonStatus jsonStatus = new JsonStatus();
        String action = (entity.getId() == 0) ? "新增" : "更新";
        try {
            dao.save(entity);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg(action + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg(action + "失败！");
        }
        return jsonStatus;

    }

    @Override
    public Object saveEntityAndReturn(PersistentEntity entity) {
        return dao.save(entity);
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
