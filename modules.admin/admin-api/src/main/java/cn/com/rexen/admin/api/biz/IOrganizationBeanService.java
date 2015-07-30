package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.entities.OrganizationBean;
import cn.com.rexen.admin.rest.model.OrganizationDTO;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;

/**
 * 机构管理服务接口
 * @author majian <br/>
 *         date:2015-7-21
 * @version 1.0.0
 */
public interface IOrganizationBeanService extends IBizService {


    public JsonStatus delete(Long id);

    public JsonStatus update(OrganizationBean org);

    public OrganizationDTO getAllOrg();

    public OrganizationDTO getAllByAreaId(Long id);

    public void deleteByAreaId(Long id);
}
