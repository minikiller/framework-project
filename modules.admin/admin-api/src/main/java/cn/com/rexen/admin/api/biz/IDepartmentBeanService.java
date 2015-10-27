package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.dto.model.DepartmentDTO;
import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.core.api.biz.IBizService;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.JsonData;

import java.util.List;

/**
 * 部门管理服务接口
 * @author majian <br/>
 *         date:2015-7-23
 * @version 1.0.0
 */
public interface IDepartmentBeanService extends IBizService<DepartmentBean> {

    void deleteByOrgId(Long orgId);

    DepartmentDTO getAll();

    DepartmentDTO getAllByOrgId(Long orgId);

    List getUsersByDepartmentId(long id);

    JsonData getUserAll();

    JsonData getUserAllAndDepartmentUsers(long depId);

    JsonStatus saveDepartmentUsers(long depId, String userIds);
}
