package cn.com.rexen.app.api.biz;

import cn.com.rexen.app.dto.model.ApplicationDTO;
import cn.com.rexen.app.dto.model.AuthorizationDTO;
import cn.com.rexen.core.api.biz.IBizService;

/**
 * 应用服务接口.
 * @author majian <br/>
 *         date:2015-7-30
 * @version 1.0.0
 */
public interface IApplicationBeanService extends IBizService {
    /**
     * 返回应用树
     * @return
     */
    ApplicationDTO getTreesByAllApplications();

    /**
     * 返回授权树
     * @return
     */
    AuthorizationDTO getAuthorizationTree();


}
