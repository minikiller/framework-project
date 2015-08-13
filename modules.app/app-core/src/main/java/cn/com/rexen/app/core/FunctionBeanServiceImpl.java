package cn.com.rexen.app.core;

import cn.com.rexen.admin.entities.RoleFunctionBean;
import cn.com.rexen.app.api.biz.IApplicationBeanService;
import cn.com.rexen.app.api.biz.IFunctionBeanService;
import cn.com.rexen.app.api.dao.IApplicationBeanDao;
import cn.com.rexen.app.api.dao.IFunctionBeanDao;
import cn.com.rexen.app.dto.model.ApplicationDTO;
import cn.com.rexen.app.dto.model.AuthorizationDTO;
import cn.com.rexen.app.dto.model.FunctionDTO;
import cn.com.rexen.app.entities.ApplicationBean;
import cn.com.rexen.app.entities.FunctionBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能服务实现
 * @author majian <br/>
 *         date:2015-7-27
 * @version 1.0.0
 */
public class FunctionBeanServiceImpl extends GenericBizServiceImpl implements IFunctionBeanService {
    private static final String FUNCTION_NAME = "功能";
    private IFunctionBeanDao functionBeanDao;
    private IShiroService shiroService;

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setFunctionBeanDao(IFunctionBeanDao functionBeanDao) {
        this.functionBeanDao = functionBeanDao;
        super.init(functionBeanDao, FunctionBean.class.getName());
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setUpdateBy(userName);
        }
    }


    public void removeChildren(Long id){
        List<FunctionBean> functionBeans=functionBeanDao.find("select ob from FunctionBean ob where ob.parentId = ?1", id);
        if(functionBeans!=null&&functionBeans.size()>0){
            for(FunctionBean functionBean:functionBeans){
                if(functionBean.getIsLeaf()==0){ //存在子节点
                    removeChildren(functionBean.getId());
                }
                functionBeanDao.remove(FunctionBean.class.getName(), functionBean.getId());
            }
        }
    }

    @Override
    public void doDelete(long entityId, JsonStatus jsonStatus) {
        List<FunctionBean> functionBeans=functionBeanDao.find("select ob from FunctionBean ob where ob.id = ?1", entityId);
        if(functionBeans!=null&&!functionBeans.isEmpty()) {
            removeChildren(entityId);
            FunctionBean function=functionBeans.get(0);
            functionBeanDao.remove(FunctionBean.class.getName(), entityId);
            updateParent(function.getParentId());
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("删除" + FUNCTION_NAME + "成功！");
        }else{
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg(FUNCTION_NAME + "已经被删除！");
        }
    }

    /**
     * 如果父节点下再没有子节点,将更新父节点状态
     * @param parentId
     */
    public void updateParent(Long parentId){
        List<FunctionBean> functionBeans=functionBeanDao.find("select ob from FunctionBean ob where ob.id = ?1", parentId); //获得父节点
        if(functionBeans!=null&&functionBeans.size()>0){
            List<FunctionBean> children=functionBeanDao.find("select ob from FunctionBean ob where ob.parentId = ?1", parentId); //获得父节点
            if(children==null||children.isEmpty()) {
                FunctionBean parent = functionBeans.get(0);
                parent.setIsLeaf(1);
                functionBeanDao.save(parent);
            }
        }
    }

    @Override
    public void doUpdate(PersistentEntity entity, JsonStatus jsonStatus) {
        Assert.notNull(entity, "实体不能为空.");
        FunctionBean oldBean=functionBeanDao.get(FunctionBean.class.getName(), entity.getId());
        if(oldBean!=null){
            FunctionBean functionBean=(FunctionBean)entity;
            oldBean.setName(functionBean.getName());
            oldBean.setRemark(functionBean.getRemark());
            oldBean.setUpdateBy(functionBean.getUpdateBy());
            //修改功能代码后再更新permission字段
            oldBean.setPermission(oldBean.getPermission().replace(oldBean.getCode(),functionBean.getCode()));
            //更新下所有子功能
            updatePermission(oldBean.getCode(),functionBean.getCode(),oldBean);
            oldBean.setCode(functionBean.getCode());
            functionBeanDao.save(oldBean);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("修改成功！");
        }
    }

    @Override
    public void afterSaveEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        FunctionBean bean=(FunctionBean)entity;
        if(bean.getParentId()!=-1){
            FunctionBean parentFunctionBean=functionBeanDao.get(FunctionBean.class.getName(),bean.getParentId());
            if(parentFunctionBean!=null&&parentFunctionBean.getIsLeaf()==1){
                parentFunctionBean.setIsLeaf(0);
                functionBeanDao.save(parentFunctionBean);
            }
        }
    }

    private void updatePermission(String oldTopCode,String newTopCode,FunctionBean parentFunction){
        //如果下面有叶子节点
        if(parentFunction.getIsLeaf()==0){
            List<FunctionBean> childFunction=functionBeanDao.find("select fb from FunctionBean fb where fb.parentId=?1",parentFunction.getId());
            if(childFunction!=null&&!childFunction.isEmpty()){
                for(FunctionBean functionBean:childFunction){
                    functionBean.setPermission(functionBean.getPermission().replace(oldTopCode,newTopCode));
                    functionBeanDao.save(functionBean);
                    updatePermission(oldTopCode,newTopCode,functionBean);
                }
            }
        }
    }

    @Override
    public void beforeSaveEntity(PersistentEntity entity, JsonStatus status) {
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            entity.setCreateBy(userName);
            entity.setUpdateBy(userName);
        }
    }


    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (functionBeanDao.get(FunctionBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        FunctionBean bean=(FunctionBean)entity;
        List<FunctionBean> beans= functionBeanDao.find("select ob from FunctionBean ob where ob.name = ?1 and ob.applicationId=?2", bean.getName(), bean.getApplicationId());
        if(beans!=null&&beans.size()>0){
            FunctionBean functionBean=beans.get(0);
            if(functionBean.getId()!=entity.getId()) {
                status.setFailure(true);
                status.setMsg(FUNCTION_NAME + "已经存在,请检查名称！");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        FunctionBean bean=(FunctionBean)entity;
        List<FunctionBean> beans= functionBeanDao.find("select ob from FunctionBean ob where ob.name = ?1 and ob.applicationId=?2 and ob.parentId=?3", bean.getName(), bean.getApplicationId(),bean.getParentId());
        if(beans!=null&&beans.size()>0){
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在,请检查名称！");
            return false;
        }
        return true;
    }

    @Override
    public void deleteByApplicationId(long id) {
        functionBeanDao.update("delete from FunctionBean fb where fb.applicationId=?1", id);
    }

    /**
     * 递归函数加载子节点
     *
     * @param root
     * @param elements
     */
    public void getChilden(FunctionDTO root, List<FunctionBean> elements, Mapper mapper) {
        List<FunctionDTO> children = new ArrayList<FunctionDTO>();

        for (FunctionBean functionBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(functionBean.getParentId()))) {
                FunctionDTO functionDTO = mapper.map(functionBean, FunctionDTO.class);
                functionDTO.setLeaf(functionBean.getIsLeaf() == 0 ? false : true);
                functionDTO.setParentName(root.getName());
                functionDTO.setText(functionBean.getName());
                children.add(functionDTO);
                if(functionBean.getIsLeaf()==0) {
                    getChilden(functionDTO, elements, mapper);
                }
            }
        }
        root.setChildren(children);
    }

    /**
     * 递归函数加载子节点
     *
     * @param root
     * @param elements
     */
    public void getChilden(AuthorizationDTO root, List<FunctionBean> elements, Mapper mapper) {
        List<AuthorizationDTO> children = new ArrayList<AuthorizationDTO>();

        for (FunctionBean functionBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(functionBean.getParentId()))) {
                AuthorizationDTO functionDTO = mapper.map(functionBean, AuthorizationDTO.class);
                functionDTO.setLeaf(functionBean.getIsLeaf() == 0 ? false : true);
                functionDTO.setParentName(root.getName());
                functionDTO.setChecked(true);
                functionDTO.setExpanded(true);
                functionDTO.setText(functionBean.getName());
                children.add(functionDTO);
                if(functionBean.getIsLeaf()==0) {
                    getChilden(functionDTO, elements, mapper);
                }
            }
        }
        root.setChildren(children);
    }


    /**
     * 递归函数加载子节点,并设置选中状态
     *
     * @param root
     * @param elements
     */
    public void getChilden(AuthorizationDTO root, List<FunctionBean> elements, Mapper mapper,List<RoleFunctionBean> roleFunctionBeans) {
        List<AuthorizationDTO> children = new ArrayList<AuthorizationDTO>();

        for (FunctionBean functionBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(functionBean.getParentId()))) {
                AuthorizationDTO functionDTO = mapper.map(functionBean, AuthorizationDTO.class);
                functionDTO.setLeaf(functionBean.getIsLeaf() == 0 ? false : true);
                functionDTO.setParentName(root.getName());
                functionDTO.setChecked(false);
                if(roleFunctionBeans!=null&&!roleFunctionBeans.isEmpty()){
                    for(RoleFunctionBean roleFunctionBean:roleFunctionBeans){
                        if(functionBean.getId()==roleFunctionBean.getFunctionId()){
                            functionDTO.setChecked(true);
                            break;
                        }
                    }
                }
                functionDTO.setExpanded(true);
                functionDTO.setText(functionBean.getName());
                children.add(functionDTO);
                if(functionBean.getIsLeaf()==0) {
                    getChilden(functionDTO, elements, mapper,roleFunctionBeans);
                }
            }
        }
        root.setChildren(children);
    }

    public FunctionDTO getAllByApplicationId(long id) {
        List<FunctionBean> beans=functionBeanDao.find("select ob from FunctionBean ob where ob.applicationId = ?1", id);
        FunctionDTO root=new FunctionDTO();
        root.setId("-1");
        if(beans!=null&&beans.size()>0){
            List<FunctionBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(FunctionBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    FunctionDTO functionDTO = mapper.map(rootElement, FunctionDTO.class);
                    functionDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    functionDTO.setParentName("根功能");
                    functionDTO.setText(rootElement.getName());
                    getChilden(functionDTO, beans, mapper);
                    root.getChildren().add(functionDTO);
                }
            }
        }
        return root;
    }
    /**
     * 获得所有根节点
     * @param elements
     * @return
     */
    public List<FunctionBean> getRootElements(List<FunctionBean> elements) {
        List<FunctionBean> roots=new ArrayList<FunctionBean>();
        for (FunctionBean element : elements) {
            if (element.getParentId() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }
}