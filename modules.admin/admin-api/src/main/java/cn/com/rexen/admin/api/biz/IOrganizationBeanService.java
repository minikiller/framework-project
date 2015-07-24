package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.entities.RoleBean;
import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.admin.rest.model.OrganizationModel;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;

import java.util.List;

/**
 * 机构管理服务接口
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public interface IOrganizationBeanService extends IBizService {

    public JsonStatus addOrg(OrganizationBean org);

    public JsonStatus deleteOrg(Long id);

    public JsonStatus updateOrg(OrganizationBean org);

    public OrganizationModel getAllOrg();

    public OrganizationModel getAllByAreaId(Long id);

    public void deleteByAreaId(Long id);
}
