package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.rest.model.DepartmentModel;
import cn.com.rexen.admin.rest.model.OrganizationModel;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;

/**
 * 部门管理服务接口
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public interface IDepartmentBeanService extends IBizService {

    public JsonStatus add(DepartmentBean bean);

    public JsonStatus delete(Long id);
    public void deleteByOrgId(Long orgId);

    public JsonStatus update(DepartmentBean org);

    public DepartmentModel getAll();
    public DepartmentModel getAllByOrgId(Long orgId);

}
