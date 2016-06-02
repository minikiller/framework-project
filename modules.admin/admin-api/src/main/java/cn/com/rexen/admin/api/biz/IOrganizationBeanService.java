package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.dto.model.OrganizationDTO;
import cn.com.rexen.admin.entities.OrganizationBean;
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
public interface IOrganizationBeanService extends IBizService<OrganizationBean> {

    OrganizationDTO getAllOrg();

    OrganizationDTO getOrg(Long id);

    OrganizationDTO getOrgByName(String name);

    OrganizationDTO getAllByAreaId(Long id);

    void deleteByAreaId(Long id);

    OrganizationDTO getAllByOrgId(Long orgId);

    List getUsersByDepartmentId(long id);

    JsonData getUserAllAndDepartmentUsers(long depId);

    JsonStatus saveDepartmentUsers(long depId, String userId);
}
