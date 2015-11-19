package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IDepartmentBeanService;
import cn.com.rexen.admin.api.dao.IDepartmentBeanDao;
import cn.com.rexen.admin.api.dao.IDepartmentUserBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.dto.model.DepartmentDTO;
import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.DepartmentUserBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门管理服务实现
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public class DepartmentBeanServiceImpl extends GenericBizServiceImpl<IDepartmentBeanDao, DepartmentBean> implements IDepartmentBeanService {
    private static final String FUNCTION_NAME = "部门";
    // private IDepartmentBeanDao dao;
    private IUserBeanDao userBeanDao;
    private IDepartmentUserBeanDao depUserBeanDao;
    private IShiroService shiroService;

    public DepartmentBeanServiceImpl() {
        super.init(DepartmentBean.class.getName());
    }

    public void setDepUserBeanDao(IDepartmentUserBeanDao depUserBeanDao) {
        this.depUserBeanDao = depUserBeanDao;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }


    public void setUserBeanDao(IUserBeanDao userBeanDao) {
        this.userBeanDao = userBeanDao;
    }

//    public void setDepBeanDao(IDepartmentBeanDao dao) {
//        this.dao = dao;
//    }

    @Override
    public JsonStatus saveEntity(DepartmentBean bean) {
        DepartmentBean _bean=(DepartmentBean)bean;
        JsonStatus jsonStatus = new JsonStatus();
        try {

            List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.name = ?1 and ob.orgId=?2", _bean.getName(), _bean.getOrgId());
            if(beans!=null&&beans.size()>0){
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "已经存在！");
                return jsonStatus;
            }
            String userName = shiroService.getCurrentUserName();
            if(StringUtils.isNotEmpty(userName)){
                bean.setCreateBy(userName);
                bean.setUpdateBy(userName);
            }
            dao.save(_bean);

            if(_bean.getParentId()!=-1){
                DepartmentBean parentDepartmentBean = dao.get(_bean.getParentId());
                if(parentDepartmentBean!=null&&parentDepartmentBean.getIsLeaf()==1){
                    parentDepartmentBean.setIsLeaf(0);
                    dao.save(parentDepartmentBean);
                }
            }
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("新增" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("新增" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;
    }

    @Override
    public JsonStatus deleteEntity(long id) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (dao.get(id) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + id + "}不存在！");
            } else {
                List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.id = ?1", id);
                if(beans!=null&&!beans.isEmpty()) {
                    removeChildren(id);
                    DepartmentBean dep=beans.get(0);
                    dao.remove(id);
                    updateParent(dep.getParentId());
                    jsonStatus.setSuccess(true);
                    jsonStatus.setMsg("删除" + FUNCTION_NAME + "成功！");
                }else{
                    jsonStatus.setSuccess(true);
                    jsonStatus.setMsg(FUNCTION_NAME + "已经被删除！");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("删除" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    @Override
    public void deleteByOrgId(Long orgId) {
        try {
            dao.update("delete from DepartmentBean ob where ob.orgId = ?1", orgId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 如果父节点下再没有子节点,将更新父节点状态
     * @param id
     */
    public void updateParent(Long id){
        List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.id = ?1", id); //获得父节点
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> children = dao.find("select ob from DepartmentBean ob where ob.parentId = ?1", id); //获得父节点
            if(children==null||children.isEmpty()) {
                DepartmentBean parent = beans.get(0);
                parent.setIsLeaf(1);
                dao.save(parent);
            }
        }
    }

    public void removeChildren(Long id){
        List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.parentId = ?1", id);
        if(beans!=null&&beans.size()>0){
            for(DepartmentBean dep:beans){
                if(dep.getIsLeaf()==0){ //存在子节点
                    removeChildren(dep.getId());
                }
                dao.remove(dep.getId());
            }
        }
    }

    @Override
    public JsonStatus updateEntity(DepartmentBean bean) {
        DepartmentBean _department=(DepartmentBean)bean;
        JsonStatus jsonStatus = new JsonStatus();
        try {
            List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.name = ?1 and ob.orgId=?2 ", _department.getName(), _department.getOrgId());
            if(beans!=null&&beans.size()>0){
                DepartmentBean _bean=beans.get(0);
                if(_bean.getId()!=bean.getId()) {
                    jsonStatus.setFailure(true);
                    jsonStatus.setMsg(FUNCTION_NAME + "已经存在！");
                    return jsonStatus;
                }
            }
            DepartmentBean oldDep = dao.get(bean.getId());
            oldDep.setName(_department.getName());
            oldDep.setCode(_department.getCode());
            oldDep.setCenterCode(_department.getCenterCode());
            oldDep.setUpdateBy(shiroService.getCurrentUserName());
            dao.save(oldDep);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public DepartmentDTO getAll() {
        List<DepartmentBean> beans = dao.getAll(DepartmentBean.class.getName());
        DepartmentDTO root=new DepartmentDTO();
        root.setId(-1);
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(DepartmentBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    DepartmentDTO departmentDTO = mapper.map(rootElement, DepartmentDTO.class);
                    departmentDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    departmentDTO.setParentName("根机构");
                    getChilden(departmentDTO, beans, mapper);
                    root.getChildren().add(departmentDTO);
               }
           }
        }
       return root;
    }

    public DepartmentDTO getAllByOrgId(Long orgId) {
        List<DepartmentBean> beans = dao.find("select ob from DepartmentBean ob where ob.orgId = ?1", orgId);
        DepartmentDTO root=new DepartmentDTO();
        root.setId(-1);
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(DepartmentBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    DepartmentDTO departmentDTO = mapper.map(rootElement, DepartmentDTO.class);
                    departmentDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    departmentDTO.setParentName("根机构");
                    getChilden(departmentDTO, beans, mapper);
                    root.getChildren().add(departmentDTO);
               }
           }
        }
       return root;
    }

    /**
     * 递归函数加载子节点
     *
     * @param root
     * @param elements
     */
    private void getChilden(DepartmentDTO root, List<DepartmentBean> elements, Mapper mapper) {
        List<DepartmentDTO> children = new ArrayList<DepartmentDTO>();

        for (DepartmentBean departmentBean : elements) {
            if (root.getId() != -1 && (root.getId() == departmentBean.getParentId())) {
                DepartmentDTO departmentDTO = mapper.map(departmentBean, DepartmentDTO.class);
                departmentDTO.setLeaf(departmentBean.getIsLeaf()==0?false:true);
                departmentDTO.setParentName(root.getName());
                departmentDTO.setText(departmentBean.getName());
                children.add(departmentDTO);
                if(departmentBean.getIsLeaf()==0) {
                    getChilden(departmentDTO, elements, mapper);
                }
            }
        }
        root.setChildren(children);
    }

    /**
     * 获得所有根节点
     * @param elements
     * @return
     */
    private List<DepartmentBean> getRootElements(List<DepartmentBean> elements) {
        List<DepartmentBean> roots=new ArrayList<DepartmentBean>();
        for (DepartmentBean element : elements) {
            if (element.getParentId() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {
        depUserBeanDao.deleteByDepartmentId(id);
    }

    @Override
    public List getUsersByDepartmentId(long id) {
        List<String> userIds=new ArrayList<String>();
        List<DepartmentUserBean> departmentUserBeans=depUserBeanDao.find("select ob from DepartmentUserBean ob where ob.depId = ?1", id);
        if(departmentUserBeans!=null&&!departmentUserBeans.isEmpty()){
            for(DepartmentUserBean departmentUserBean:departmentUserBeans){
                if(departmentUserBean!=null&&departmentUserBean.getUserId()!=0){
                    userIds.add(String.valueOf(departmentUserBean.getUserId()));
                }
            }
        }
        return userIds;
    }

    @Override
    public JsonData getUserAll() {
        JsonData jsonData=new JsonData();
        List<UserBean> users=userBeanDao.find("select u from UserBean u where u.id<>(select dub.userId from DepartmentUserBean dub)");
        List<PersistentEntity> persistentEntities=new ArrayList<PersistentEntity>();
        if(users!=null&&users.size()>0){
            for(UserBean user:users){
                if(user!=null) {
                    persistentEntities.add(user);
                }
            }
        }
        jsonData.setData(persistentEntities);
        jsonData.setTotalCount((long)users.size());
        return null;
    }

    @Override
    public JsonData getUserAllAndDepartmentUsers(long depId) {
        JsonData jsonData=new JsonData();
        List<UserBean> users=userBeanDao.find("select u from UserBean u where u.id not in(select dub.userId from DepartmentUserBean dub)");
        List<PersistentEntity> persistentEntities=new ArrayList<PersistentEntity>();
        if(users!=null&&users.size()>0){
            for(UserBean user:users){
                if(user!=null) {
                    persistentEntities.add(user);
                }
            }
        }
        List<UserBean> departmentUserBeans=userBeanDao.find("select u from UserBean u where u.id in (select du.userId from DepartmentUserBean du where du.depId=?1)",depId);
        if(departmentUserBeans!=null&&departmentUserBeans.size()>0){
            for(UserBean departmentUserBean:departmentUserBeans){
                if(departmentUserBean!=null) {
                    persistentEntities.add(departmentUserBean);
                }
            }
        }
        jsonData.setData(persistentEntities);
        jsonData.setTotalCount((long)persistentEntities.size());
        return jsonData;
    }

    @Override
    public JsonStatus saveDepartmentUsers(long depId, String userId) {
        JsonStatus jsonStatus=new JsonStatus();
        try {
            depUserBeanDao.deleteByDepartmentId(depId);
            String userName=shiroService.getCurrentUserName();
            if (StringUtils.isNotEmpty(userId)) {
                if (userId.indexOf(",") != -1) {
                    String[] userIds = userId.split(",");
                    for (String _userId : userIds) {
                        if (StringUtils.isNotEmpty(_userId.trim())) {
                            DepartmentUserBean departmentUserBean = new DepartmentUserBean();
                            departmentUserBean.setCreateBy(userName);
                            departmentUserBean.setUpdateBy(userName);
                            departmentUserBean.setDepId(depId);
                            departmentUserBean.setUserId(Long.parseLong(_userId));
                            depUserBeanDao.save(departmentUserBean);
                        }
                    }
                }else{
                    if (StringUtils.isNotEmpty(userId.trim())) {
                        DepartmentUserBean departmentUserBean = new DepartmentUserBean();
                        departmentUserBean.setCreateBy(userName);
                        departmentUserBean.setUpdateBy(userName);
                        departmentUserBean.setDepId(depId);
                        departmentUserBean.setUserId(Long.parseLong(userId));
                        depUserBeanDao.save(departmentUserBean);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("保存失败!");
            return jsonStatus;
        }
        jsonStatus.setSuccess(true);
        jsonStatus.setMsg("保存成功!");
        return jsonStatus;
    }

}