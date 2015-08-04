package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IDepartmentBeanService;
import cn.com.rexen.admin.api.biz.IOrganizationBeanService;
import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.dto.model.OrganizationDTO;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import java.util.ArrayList;
import java.util.List;

import cn.com.rexen.core.util.Assert;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * 机构管理服务实现
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public class OrganizationBeanServiceImpl extends GenericBizServiceImpl implements IOrganizationBeanService {
    private static final String FUNCTION_NAME = "机构";
    private IOrganizationBeanDao orgBeanDao;
    private IUserBeanService userBeanService;
    private IShiroService shiroService;
    private IDepartmentBeanService departmentBeanService;

    public void setDepartmentBeanService(IDepartmentBeanService departmentBeanService) {
        this.departmentBeanService = departmentBeanService;
    }

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setOrgBeanDao(IOrganizationBeanDao orgBeanDao) {
        this.orgBeanDao = orgBeanDao;
        super.init(orgBeanDao,OrganizationBean.class.getName());
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    @Override
    public void beforeSaveEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        OrganizationBean bean=(OrganizationBean)entity;
        String userName = shiroService.getCurrentUserName();
        if (userName != null) {
            bean.setCreateBy(userName);
            bean.setUpdateBy(userName);
        }
    }

    @Override
    public void afterSaveEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        OrganizationBean bean=(OrganizationBean)entity;
        if(bean.getParentId()!=-1){
            OrganizationBean parentOrganizationBean=orgBeanDao.getOrg(bean.getParentId());
            if(parentOrganizationBean!=null&&parentOrganizationBean.getIsLeaf()==1){
                parentOrganizationBean.setIsLeaf(0);
                orgBeanDao.saveOrg(parentOrganizationBean);
            }
        }
    }

    @Override
    public boolean isUpdate(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        OrganizationBean bean=(OrganizationBean)entity;
        List<OrganizationBean> beans=orgBeanDao.find("select ob from OrganizationBean ob where ob.name = ?1", bean.getName());
        if(beans!=null&&beans.size()>0){
            OrganizationBean _org=beans.get(0);
            if(_org.getId()!=entity.getId()) {
                status.setFailure(true);
                status.setMsg(FUNCTION_NAME + "已经存在！");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        OrganizationBean bean=(OrganizationBean)entity;
        List<OrganizationBean> beans=orgBeanDao.find("select ob from OrganizationBean ob where ob.name = ?1 and ob.areaId=?2", bean.getName(),bean.getAreaId());
        if(beans!=null&&beans.size()>0){
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (orgBeanDao.get(OrganizationBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }


    @Override
    public JsonStatus deleteEntity(long id) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (orgBeanDao.getOrg(id) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + id + "}不存在！");
            } else {
                List<OrganizationBean> organizationBeans=orgBeanDao.find("select ob from OrganizationBean ob where ob.id = ?1", id);
                if(organizationBeans!=null&&!organizationBeans.isEmpty()) {
                    removeChildren(id);
                    OrganizationBean org=organizationBeans.get(0);
                    orgBeanDao.removeOrg(id);
                    departmentBeanService.deleteByOrgId(id);
                    updateParent(org.getParentId());
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


    /**
     * 如果父节点下再没有子节点,将更新父节点状态
     * @param parentId
     */
    public void updateParent(Long parentId){
        List<OrganizationBean> organizationBeans=orgBeanDao.find("select ob from OrganizationBean ob where ob.id = ?1", parentId); //获得父节点
        if(organizationBeans!=null&&organizationBeans.size()>0){
            List<OrganizationBean> children=orgBeanDao.find("select ob from OrganizationBean ob where ob.parentId = ?1", parentId); //获得父节点
            if(children==null||children.isEmpty()) {
                OrganizationBean parent = organizationBeans.get(0);
                parent.setIsLeaf(1);
                orgBeanDao.save(parent);
            }
        }
    }

    public void removeChildren(Long id){
        List<OrganizationBean> organizationBeans=orgBeanDao.find("select ob from OrganizationBean ob where ob.parentId = ?1", id);
        if(organizationBeans!=null&&organizationBeans.size()>0){
            for(OrganizationBean org:organizationBeans){
                if(org.getIsLeaf()==0){ //存在子节点
                    removeChildren(org.getId());
                }
                orgBeanDao.removeOrg(org.getId());
                departmentBeanService.deleteByOrgId(org.getId());
            }
        }
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        super.beforeUpdateEntity(entity, status);
    }

    @Override
    public JsonStatus updateEntity(PersistentEntity entity) {
        OrganizationBean org=(OrganizationBean)entity;
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if(isUpdate(org,jsonStatus)) {
                OrganizationBean oldOrg = orgBeanDao.getOrg(org.getId());
                oldOrg.setName(org.getName());
                oldOrg.setCode(org.getCode());
                oldOrg.setCenterCode(org.getCenterCode());
                oldOrg.setUpdateBy(shiroService.getCurrentUserName());
                orgBeanDao.saveOrg(oldOrg);
                jsonStatus.setSuccess(true);
                jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public OrganizationDTO getAllOrg() {
        List<OrganizationBean> orgs=orgBeanDao.getAll(OrganizationBean.class.getName());
        OrganizationDTO root=new OrganizationDTO();
        root.setId("-1");
        if(orgs!=null&&orgs.size()>0){
            List<OrganizationBean> rootElements = getRootElements(orgs);
            if(rootElements!=null&&rootElements.size()>0) {
                for(OrganizationBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    OrganizationDTO organizationDTO = mapper.map(rootElement, OrganizationDTO.class);
                    organizationDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    organizationDTO.setParentName("根机构");
                    organizationDTO.setText(rootElement.getName());
                    getChilden(organizationDTO, orgs, mapper);
                    root.getChildren().add(organizationDTO);
               }
           }
        }
       return root;
    }

    /**
     * 递归函数加载子机构
     *
     * @param root
     * @param elements
     */
    private void getChilden(OrganizationDTO root, List<OrganizationBean> elements, Mapper mapper) {
        List<OrganizationDTO> children = new ArrayList<OrganizationDTO>();

        for (OrganizationBean organizationBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(organizationBean.getParentId()))) {
                OrganizationDTO organizationDTO = mapper.map(organizationBean, OrganizationDTO.class);
                organizationDTO.setLeaf(organizationBean.getIsLeaf() == 0 ? false : true);
                organizationDTO.setParentName(root.getName());
                organizationDTO.setText(organizationBean.getName());
                children.add(organizationDTO);
                if(organizationBean.getIsLeaf()==0) {
                    getChilden(organizationDTO, elements, mapper);
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
    private List<OrganizationBean> getRootElements(List<OrganizationBean> elements) {
        List<OrganizationBean> roots=new ArrayList<OrganizationBean>();
        for (OrganizationBean element : elements) {
            if (element.getParentId() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }

    public OrganizationDTO getAllByAreaId(Long id) {
        List<OrganizationBean> beans=orgBeanDao.find("select ob from OrganizationBean ob where ob.areaId = ?1", id);
        OrganizationDTO root=new OrganizationDTO();
        root.setId("-1");
        if(beans!=null&&beans.size()>0){
            List<OrganizationBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(OrganizationBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    OrganizationDTO OrganizationDTO = mapper.map(rootElement, OrganizationDTO.class);
                    OrganizationDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    OrganizationDTO.setParentName("根机构");
                    OrganizationDTO.setText(rootElement.getName());
                    getChilden(OrganizationDTO, beans, mapper);
                    root.getChildren().add(OrganizationDTO);
                }
            }
        }
        return root;
    }

    @Override
    public void deleteByAreaId(Long id) {
        try {
            List<OrganizationBean> orgs=orgBeanDao.find("select ob from OrganizationBean ob where ob.areaId = ?1",id);
            if(orgs!=null&&!orgs.isEmpty()){
                for(OrganizationBean org:orgs){
                    if(org!=null) {
                        orgBeanDao.removeOrg(org.getId());
                        departmentBeanService.deleteByOrgId(org.getId());
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}