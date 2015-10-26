package cn.com.rexen.core.impl.persistence;


import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.persistence.SearchException;
import cn.com.rexen.core.api.web.model.QueryDTO;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import javax.transaction.Transactional;

/**
 * @类描述：DAO数据访问通用实现抽象类
 * @创建人：sunlf
 * @创建时间：2014-7-3 下午1:01:59
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
//@Transactional
public abstract class GenericDao<T extends PersistentEntity, PK extends Serializable> implements IGenericDao<T, PK> {
    protected final Logger log = Logger.getLogger(getClass());
    protected EntityManager entityManager;
    private Class<T> persistentClass;

    public GenericDao() {
        Object obj = this.getClass().getGenericSuperclass();
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        java.lang.reflect.Type type = genericSuperclass.getActualTypeArguments()[0];
        if (type instanceof Class) {
            this.persistentClass = (Class<T>) type;
        } else if (type instanceof ParameterizedType) {
            this.persistentClass = (Class<T>) ((ParameterizedType) type).getRawType();
        }
    }

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDao(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public void setEntityManager(EntityManager em) {
        entityManager = em;
    }

    @Override
    public List<T> getAll(String className) {
        final Query query = entityManager.createQuery("select c from " + className + " c ");
        final List<T> resultList = query.getResultList();
        return resultList;
    }

    /**
     * JPA 分页查询
     *
     * @param page
     * @param limit
     * @param className
     * @return
     */
    @Override
    public JsonData getAll(int page, int limit, String className) {
        JsonData jsonData=new JsonData();
        Class entityClass = null;
        try {
            entityClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Long count = getTotalCount(className);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root from = criteriaQuery.from(entityClass);
        CriteriaQuery select = criteriaQuery.select(from);
        select.orderBy(criteriaBuilder.desc(from.get("creationDate")));
        TypedQuery typedQuery = entityManager.createQuery(select);

        typedQuery.setFirstResult((page-1) * limit);
        typedQuery.setMaxResults(limit);
        jsonData.setTotalCount(count);
        jsonData.setData(typedQuery.getResultList());
        return jsonData;
    }

    @Override
    public CriteriaQuery buildCriteriaQuery(QueryDTO queryDTO) {
        return null;
    }

    @Override
    public JsonData getAll(int page, int limit,String className, CriteriaQuery criteriaQuery) {
        JsonData jsonData=new JsonData();
        Class entityClass = null;
        try {
            entityClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult((page - 1) * limit);
        typedQuery.setMaxResults(limit);
        jsonData.setTotalCount(getTotalCount(className, criteriaQuery));
        jsonData.setData(typedQuery.getResultList());
        return jsonData;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * 获得结果集的总数
     *
     * @param className
     * @return
     */
    private Long getTotalCount(String className) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        try {
            countQuery.select(criteriaBuilder.count(countQuery.from(Class.forName(className))));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        return count;
    }

    /**
     * 获得结果集的总数
     * @param className
     * @param criteriaQuery
     * @return
     */
    private Long getTotalCount(String className,CriteriaQuery criteriaQuery) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.where(criteriaQuery.getRestriction());
        try {
            countQuery.select(criteriaBuilder.count(countQuery.from(Class.forName(className))));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Long count = entityManager.createQuery(countQuery).getSingleResult();
        return count;
    }

    @Override
    public List<T> getAllDistinct(String className) {
        final Query query = entityManager.createQuery("select Distinct c from " + className + " c ");
        final List<T> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<T> search(String searchTerm) throws SearchException {
        return null;
    }

    @Override
    public T get(String className, PK id) {

        try {
            return (T) entityManager.find(Class.forName(className), id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean exists(PK id) {
        return false;
    }

    @Override
    public T save(T object) {
        if (object.getId() == 0)//do not persist
            entityManager.persist(object);
        else {
            object.setUpdateDate(new Date());
            entityManager.merge(object);
        }

        entityManager.flush();
        return object;
    }

    @Override
    public T save(T object, String userName) {
        if (object.getId() == 0)//do not persist
        {
            object.setCreateBy(userName);
            entityManager.persist(object);
        } else {
            object.setUpdateBy(userName);
            object.setUpdateDate(new Date());
            entityManager.merge(object);
        }
        entityManager.flush();
        return object;
    }

    //@Override
    public void remove(String className, T object) {
        entityManager.remove(object);
        entityManager.flush();
    }

    @Override
    public void remove(String className, PK id) {
        Object object = get(className, id);
        entityManager.remove(object);
        entityManager.flush();
    }

    @Override
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        return null;
    }

    @Override
    public void reindex() {

    }

    @Override
    public void reindexAll(boolean async) {

    }

    /**
     * 按HQL查询唯一对象.
     */
    @Override
    public <T> T findUnique(String hql, Object... values) {
        List list = this.find(hql, values);
        if (list != null && list.size() > 0) {

            return (T) list.get(0);
        }
        return null;
    }

    @Override
    public List find(String hql, Object... values) {
        return createQuery(hql, values).getResultList();
    }

    /**
     * 支持原生的sql查询
     *
     * @param sql   sql语句
     * @param cls   需要返回结果的类
     * @param parms 参数
     * @return
     */
    @Override
    public List findByNativeSql(String sql, Class cls, Object... parms) {
        return createNativeQuery(sql, cls, parms).getResultList();
    }

    private Query createNativeQuery(String sql, Class cls, Object[] parameter) {
        Query queryObject = entityManager.createNativeQuery(sql, cls);
        if (parameter != null) {
            for (int i = 0; i < parameter.length; i++) {
                queryObject.setParameter(i + 1, parameter[i]);
            }
        }

        return queryObject;
    }

    /**
     * @param hql
     * @param pageNumber 从0开始的页号
     * @param pageSize
     * @param values
     * @return
     */
    @Override
    public List findbyPage(String hql, int pageNumber, int pageSize, Object... values) {
        Query queryObject = createQuery(hql, values);
        /*List result=queryObject.getResultList();//获得结果集个数
        int count=result.size();
        if(count==0)
            return result;*/
        queryObject.setFirstResult(pageNumber * pageSize);
        queryObject.setMaxResults(pageSize);
        return queryObject.getResultList();
    }

    /**
     * 根据查询函数与参数列表创建Query对象,后续可进行更多处理,辅助函数.
     */
//    @Transactional(Transactional.TxType.SUPPORTS)
    protected Query createQuery(String queryString, Object... parameter) {

        Query queryObject = entityManager.createQuery(queryString);
        if (parameter != null) {
            for (int i = 0; i < parameter.length; i++) {
                queryObject.setParameter(i + 1, parameter[i]);
            }
        }

        return queryObject;
    }

    /**
     * 更新
     *
     * @param qlString
     * @param parameter
     * @return
     */
    @Override
//    @Transactional(Transactional.TxType.REQUIRED)
    public int update(String qlString, Object... parameter) {
        return createQuery(qlString, parameter).executeUpdate();
    }

    /**
     * 更新，使用纯生sql
     *
     * @param sql
     * @return
     */
    @Override
    public int updateNativeQuery(String sql) {
        return entityManager.createNativeQuery(sql).executeUpdate();
    }

}
