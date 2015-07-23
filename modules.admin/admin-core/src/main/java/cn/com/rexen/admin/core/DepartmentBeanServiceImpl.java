package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IDepartmentBeanService;
import cn.com.rexen.admin.api.biz.IOrganizationBeanService;
import cn.com.rexen.admin.api.biz.IUserBeanService;
import cn.com.rexen.admin.api.dao.IDepartmentBeanDao;
import cn.com.rexen.admin.api.dao.IOrganizationBeanDao;
import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.admin.rest.model.DepartmentModel;
import cn.com.rexen.admin.rest.model.OrganizationModel;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
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
public class DepartmentBeanServiceImpl extends GenericBizServiceImpl implements IDepartmentBeanService {
    private static final String FUNCTION_NAME = "部门";
    private IDepartmentBeanDao depBeanDao;
    private IUserBeanService userBeanService;

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    public void setDepBeanDao(IDepartmentBeanDao depBeanDao) {
        this.depBeanDao = depBeanDao;
    }

    @Override
    public JsonStatus add(DepartmentBean bean) {
        JsonStatus jsonStatus = new JsonStatus();
        try {

            List<DepartmentBean> beans=depBeanDao.find("select ob from DepartmentBean ob where ob.name = ?1", bean.getName());
            if(beans!=null&&beans.size()>0){
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg(FUNCTION_NAME + "已经存在！");
                return jsonStatus;
            }
            UserBean currentUser=userBeanService.getCurrentUser();
            if(currentUser!=null){
                bean.setCreateBy(currentUser.getName());
                bean.setUpdateBy(currentUser.getName());
            }
            depBeanDao.save(bean);

            if(bean.getParentId()!=-1){
                DepartmentBean parentDepartmentBean=depBeanDao.get(bean.getParentId());
                if(parentDepartmentBean!=null&&parentDepartmentBean.getIsLeaf()==1){
                    parentDepartmentBean.setIsLeaf(0);
                    depBeanDao.save(parentDepartmentBean);
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
    public JsonStatus delete(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (depBeanDao.get(id) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + id + "}不存在！");
            } else {
                List<DepartmentBean> beans=depBeanDao.find("select ob from DepartmentBean ob where ob.id = ?1", id);
                if(beans!=null&&!beans.isEmpty()) {
                    removeChildren(id);
                    DepartmentBean dep=beans.get(0);
                    depBeanDao.remove(id);
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


    /**
     * 如果父节点下再没有子节点,将更新父节点状态
     * @param id
     */
    public void updateParent(Long id){
        List<DepartmentBean> beans=depBeanDao.find("select ob from DepartmentBean ob where ob.id = ?1", id); //获得父节点
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> children=depBeanDao.find("select ob from DepartmentBean ob where ob.parentId = ?1", id); //获得父节点
            if(children==null||children.isEmpty()) {
                DepartmentBean parent = beans.get(0);
                parent.setIsLeaf(1);
                depBeanDao.save(parent);
            }
        }
    }

    public void removeChildren(Long id){
        List<DepartmentBean> beans=depBeanDao.find("select ob from DepartmentBean ob where ob.parentId = ?1", id);
        if(beans!=null&&beans.size()>0){
            for(DepartmentBean dep:beans){
                if(dep.getIsLeaf()==0){ //存在子节点
                    removeChildren(dep.getId());
                }
                depBeanDao.remove(dep.getId());
            }
        }
    }

    @Override
    public JsonStatus update(DepartmentBean bean) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            DepartmentBean oldDep=depBeanDao.get(bean.getId());
            oldDep.setName(bean.getName());
            oldDep.setCode(bean.getCode());
            oldDep.setCenterCode(bean.getCenterCode());
            depBeanDao.save(oldDep);
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setMsg("更新" + FUNCTION_NAME + "失败！");
        }
        return jsonStatus;

    }

    public DepartmentModel getAll() {
        List<DepartmentBean> beans=depBeanDao.getAll(DepartmentBean.class.getName());
        DepartmentModel root=new DepartmentModel();
        root.setId("-1");
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(DepartmentBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    DepartmentModel departmentModel = mapper.map(rootElement, DepartmentModel.class);
                    departmentModel.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    departmentModel.setParentName("根机构");
                    getChilden(departmentModel, beans, mapper);
                    root.getChildren().add(departmentModel);
               }
           }
        }
       return root;
    }

    public DepartmentModel getAllByOrgId(Long orgId) {
        List<DepartmentBean> beans=depBeanDao.find("select ob from DepartmentBean ob where ob.orgId = ?1", orgId);
        DepartmentModel root=new DepartmentModel();
        root.setId("-1");
        if(beans!=null&&beans.size()>0){
            List<DepartmentBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(DepartmentBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    DepartmentModel departmentModel = mapper.map(rootElement, DepartmentModel.class);
                    departmentModel.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    departmentModel.setParentName("根机构");
                    getChilden(departmentModel, beans, mapper);
                    root.getChildren().add(departmentModel);
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
    private void getChilden(DepartmentModel root, List<DepartmentBean> elements, Mapper mapper) {
        List<DepartmentModel> children = new ArrayList<DepartmentModel>();

        for (DepartmentBean departmentBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(departmentBean.getParentId()))) {
                DepartmentModel departmentModel = mapper.map(departmentBean, DepartmentModel.class);
                departmentModel.setLeaf(departmentBean.getIsLeaf()==0?false:true);
                departmentModel.setParentName(root.getName());
                departmentModel.setText(departmentBean.getName());
                children.add(departmentModel);
                if(departmentBean.getIsLeaf()==0) {
                    getChilden(departmentModel, elements, mapper);
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

}