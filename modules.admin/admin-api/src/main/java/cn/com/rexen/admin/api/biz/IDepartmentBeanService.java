package cn.com.rexen.admin.api.biz;

import cn.com.rexen.admin.dto.model.DepartmentDTO;
import cn.com.rexen.admin.entities.DepartmentBean;
import cn.com.rexen.admin.entities.UserBean;
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
public interface IDepartmentBeanService extends IBizService {

    public void deleteByOrgId(Long orgId);

    public DepartmentDTO getAll();
    public DepartmentDTO getAllByOrgId(Long orgId);

    public List getUsersByDepartmentId(long id);
    public JsonData getUserAll();
    public JsonData getUserAllAndDepartmentUsers(long depId);
    public JsonStatus saveDepartmentUsers(long depId,String userIds);
}
