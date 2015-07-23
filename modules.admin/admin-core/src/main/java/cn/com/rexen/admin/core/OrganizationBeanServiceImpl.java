package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IOrganizationBeanService;
import cn.com.rexen.admin.api.biz.IRoleBeanService;
import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.api.dao.IRoleBeanDao;
import cn.com.rexen.admin.api.dao.IUserBeanDao;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.admin.rest.model.OrganizationModel;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setOrgBeanDao(IOrganizationBeanDao orgBeanDao) {
        this.orgBeanDao = orgBeanDao;
    }

    @Override
    public JsonStatus addOrg(OrganizationBean org) {
        JsonStatus jsonStatus = new JsonStatus();
        try {

            List<OrganizationBean> organizationBeans=orgBeanDao.find("select ob from OrganizationBean ob where ob.name = ?1", org.getName());
            if(organizationBeans!=null&&organizationBeans.size()>0){
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg(FUNCTION_NAME + "已经存在！");
                return jsonStatus;
            }
            UserBean currentUser=userBeanService.getCurrentUser();
            if(currentUser!=null){
                org.setCreateBy(currentUser.getName());
                org.setUpdateBy(currentUser.getName());
            }
            orgBeanDao.saveOrg(org);

            if(org.getParentId()!=-1){
                OrganizationBean parentOrganizationBean=orgBeanDao.getOrg(org.getParentId());
                if(parentOrganizationBean!=null&&parentOrganizationBean.getIsLeaf()==1){
                    parentOrganizationBean.setIsLeaf(0);
                    orgBeanDao.saveOrg(parentOrganizationBean);
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
    public JsonStatus deleteOrg(Long id) {
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
     * @param id
     */
    public void updateParent(Long id){
        List<OrganizationBean> organizationBeans=orgBeanDao.find("select ob from OrganizationBean ob where ob.id = ?1", id); //获得父节点
        if(organizationBeans!=null&&organizationBeans.size()>0){
            List<OrganizationBean> children=orgBeanDao.find("select ob from OrganizationBean ob where ob.parentId = ?1", id); //获得父节点
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
            }
        }
    }

    @Override
    public JsonStatus updateOrg(OrganizationBean org) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            OrganizationBean oldOrg=orgBeanDao.getOrg(org.getId());
            oldOrg.setName(org.getName());
            oldOrg.setCode(org.getCode());
            oldOrg.setCenterCode(org.getCenterCode());
            orgBeanDao.saveOrg(oldOrg);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public OrganizationModel getAllOrg() {
        List<OrganizationBean> orgs=orgBeanDao.getAll(OrganizationBean.class.getName());
        OrganizationModel root=new OrganizationModel();
        root.setId("-1");
        if(orgs!=null&&orgs.size()>0){
            List<OrganizationBean> rootElements = getRootElements(orgs);
            if(rootElements!=null&&rootElements.size()>0) {
                for(OrganizationBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    OrganizationModel organizationModel = mapper.map(rootElement, OrganizationModel.class);
                    organizationModel.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    organizationModel.setParentName("根机构");
                    organizationModel.setText(rootElement.getName());
                    getChilden(organizationModel, orgs, mapper);
                    root.getChildren().add(organizationModel);
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
    private void getChilden(OrganizationModel root, List<OrganizationBean> elements, Mapper mapper) {
        List<OrganizationModel> children = new ArrayList<OrganizationModel>();

        for (OrganizationBean organizationBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(organizationBean.getParentId()))) {
                OrganizationModel organizationModel = mapper.map(organizationBean, OrganizationModel.class);
                organizationModel.setLeaf(organizationBean.getIsLeaf() == 0 ? false : true);
                organizationModel.setParentName(root.getName());
                organizationModel.setText(organizationBean.getName());
                children.add(organizationModel);
                if(organizationBean.getIsLeaf()==0) {
                    getChilden(organizationModel, elements, mapper);
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

}