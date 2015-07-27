package cn.com.rexen.admin.core;

import cn.com.rexen.admin.api.biz.IAreaBeanService;
import cn.com.rexen.admin.api.biz.IOrganizationBeanService;
import cn.com.rexen.admin.api.dao.IAboutBeanDao;
import cn.com.rexen.admin.api.dao.IAreaBeanDao;
import cn.com.rexen.admin.entities.AboutBean;
import cn.com.rexen.admin.entities.AreaBean;
import cn.com.rexen.admin.rest.model.AreaDTO;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.PersistentEntity;
import cn.com.rexen.core.api.security.IShiroService;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.core.util.Assert;
import cn.com.rexen.core.util.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:  urgent-project
 * 类描述:    区域服务实现类
 * 创建人:    sunlf
 * 创建时间:  2014/8/7 16:02
 * 修改人:    sunlf
 * 修改时间:  2014/8/7 16:02
 * 修改备注:  [说明本次修改内容]
 */
public class AreaBeanServiceImpl extends GenericBizServiceImpl implements IAreaBeanService {
    private static final String FUNCTION_NAME = "区域";
    private IAreaBeanDao areaBeanDao;
    private IOrganizationBeanService orgService;
    private IAboutBeanDao aboutBeanDao;
    private IShiroService shiroService;

    public void setOrgService(IOrganizationBeanService orgService) {
        this.orgService = orgService;
    }

    public void setShiroService(IShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public void setAreaBeanDao(IAreaBeanDao dictBeanDao) {
        this.areaBeanDao = dictBeanDao;
        super.init(dictBeanDao, AreaBean.class.getName());
    }

    public void setAboutBeanDao(IAboutBeanDao aboutBeanDao) {
        this.aboutBeanDao = aboutBeanDao;
    }

    @Override
    public List<AreaBean> query(AreaBean areaBean) {
        return areaBeanDao.find("select a from AreaBean a where a.name like ?1", "%" + areaBean.getName() + "%");
    }

    @Override
    public List<AreaBean> getRootBeanList() {
        return areaBeanDao.find("select u from AreaBean u where u.parent is null");
    }

    @Override
    public List<AreaBean> getRootBeanListByQhdm() {
        AboutBean aboutBean = aboutBeanDao.get(AboutBean.class.getName(), 1L);
        String qhdm = "";
        if (aboutBean != null) {
            qhdm = aboutBean.getXzqh_dm();
        }
        return areaBeanDao.find("select u from AreaBean u where u.code = ?1", qhdm);
    }

    @Override
    public List<AreaBean> getChildBeanList(AreaBean node) {
        return areaBeanDao.find("select u from AreaBean u where u.parent= ?1", node);
    }


    @Override
    public void beforeDeleteEntity(Long id, JsonStatus status) {
        List<AreaBean> areaBeans=areaBeanDao.find("select ob from AreaBean ob where ob.id = ?1", id);
        if(areaBeans!=null&&!areaBeans.isEmpty()) {
            removeChildren(id);
            AreaBean area=areaBeans.get(0);
            //departmentBeanService.deleteByOrgId(id);
            updateParent(area.getParentId());
            status.setSuccess(true);
            status.setMsg("删除" + FUNCTION_NAME + "成功！");
        }else{
            status.setSuccess(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
        }
    }

    @Override
    public void afterDeleteEntity(Long id, JsonStatus status) {

    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (areaBeanDao.get(AreaBean.class.getName(),entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public JsonStatus deleteEntity(long entityId) {
        JsonStatus jsonStatus = new JsonStatus();
        try {
            if (areaBeanDao.get(AreaBean.class.getName(),entityId) == null) {
                jsonStatus.setFailure(true);
                jsonStatus.setMsg(FUNCTION_NAME + "{" + entityId + "}不存在！");
            } else {
                List<AreaBean> AreaBeans=areaBeanDao.find("select ob from AreaBean ob where ob.id = ?1", entityId);
                if(AreaBeans!=null&&!AreaBeans.isEmpty()) {
                    removeChildren(entityId);
                    AreaBean org=AreaBeans.get(0);
                    areaBeanDao.remove(AreaBean.class.getName(), entityId);
                    orgService.deleteByAreaId(entityId);
                    //departmentBeanService.deleteByOrgId(id);
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
        List<AreaBean> AreaBeans=areaBeanDao.find("select ob from AreaBean ob where ob.id = ?1", id); //获得父节点
        if(AreaBeans!=null&&AreaBeans.size()>0){
            List<AreaBean> children=areaBeanDao.find("select ob from AreaBean ob where ob.parentId = ?1", id); //获得父节点
            if(children==null||children.isEmpty()) {
                AreaBean parent = AreaBeans.get(0);
                parent.setIsLeaf(1);
                areaBeanDao.save(parent);
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
    public void afterSaveEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity,"实体不能为空.");
        AreaBean bean=(AreaBean)entity;
        if(bean.getParentId()!=-1){
            AreaBean parentAreaBean=areaBeanDao.get(AreaBean.class.getName(),bean.getParentId());
            if(parentAreaBean!=null&&parentAreaBean.getIsLeaf()==1){
                parentAreaBean.setIsLeaf(0);
                areaBeanDao.save(parentAreaBean);
            }
        }
    }

    @Override
    public boolean isSave(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        AreaBean bean=(AreaBean)entity;
        List<AreaBean> beans=areaBeanDao.find("select ob from AreaBean ob where ob.name = ?1", bean.getName());
        if(beans!=null&&beans.size()>0){
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public void beforeUpdateEntity(PersistentEntity entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        AreaBean oldArea=areaBeanDao.get(AreaBean.class.getName(), entity.getId());
        AreaBean area=(AreaBean)entity;
        area.setParentId(oldArea.getParentId());
        area.setIsLeaf(oldArea.getIsLeaf());
        String userName = shiroService.getCurrentUserName();
        Assert.notNull(userName, "用户名不能为空.");
        if(StringUtils.isNotEmpty(userName)) {
            area.setUpdateBy(userName);
        }
    }

    @Override
    public void afterUpdateEntity(PersistentEntity entity, JsonStatus status) {
        super.afterUpdateEntity(entity, status);
    }

    public void removeChildren(Long id){
        List<AreaBean> AreaBeans=areaBeanDao.find("select ob from AreaBean ob where ob.parentId = ?1", id);
        if(AreaBeans!=null&&AreaBeans.size()>0){
            for(AreaBean org:AreaBeans){
                if(org.getIsLeaf()==0){ //存在子节点
                    removeChildren(org.getId());
                }
                areaBeanDao.remove(AreaBean.class.getName(), org.getId());
                orgService.deleteByAreaId(org.getId());
                //departmentBeanService.deleteByOrgId(org.getId());
            }
        }
    }
    
    public AreaDTO getAllArea() {
        List<AreaBean> beans=areaBeanDao.getAll(AreaBean.class.getName());
        AreaDTO root=new AreaDTO();
        root.setId("-1");
        if(beans!=null&&beans.size()>0){
            List<AreaBean> rootElements = getRootElements(beans);
            if(rootElements!=null&&rootElements.size()>0) {
                for(AreaBean rootElement:rootElements){
                    Mapper mapper = new DozerBeanMapper();
                    AreaDTO AreaDTO = mapper.map(rootElement, AreaDTO.class);
                    AreaDTO.setLeaf(rootElement.getIsLeaf() == 0 ? false : true);
                    AreaDTO.setParentName("根机构");
                    AreaDTO.setText(rootElement.getName());
                    getChilden(AreaDTO, beans, mapper);
                    root.getChildren().add(AreaDTO);
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
    private void getChilden(AreaDTO root, List<AreaBean> elements, Mapper mapper) {
        List<AreaDTO> children = new ArrayList<AreaDTO>();

        for (AreaBean AreaBean : elements) {
            if (root.getId()!=null&&root.getId().equals(String.valueOf(AreaBean.getParentId()))) {
                AreaDTO AreaDTO = mapper.map(AreaBean, AreaDTO.class);
                AreaDTO.setLeaf(AreaBean.getIsLeaf()==0?false:true);
                AreaDTO.setParentName(root.getName());
                AreaDTO.setText(AreaBean.getName());
                children.add(AreaDTO);
                if(AreaBean.getIsLeaf()==0) {
                    getChilden(AreaDTO, elements, mapper);
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
    private List<AreaBean> getRootElements(List<AreaBean> elements) {
        List<AreaBean> roots=new ArrayList<AreaBean>();
        for (AreaBean element : elements) {
            if (element.getParentId() == -1) {
                roots.add(element);
            }
        }
        return roots;
    }
}
