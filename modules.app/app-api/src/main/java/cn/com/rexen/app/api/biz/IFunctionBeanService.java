package cn.com.rexen.app.api.biz;

import cn.com.rexen.app.dto.model.ApplicationDTO;
import cn.com.rexen.app.dto.model.FunctionDTO;
import cn.com.rexen.core.api.biz.IBizService;

/**
 * 功能服务接口.
 * @author majian <br/>
 *         date:2015-7-30
 * @version 1.0.0
 */
public interface IFunctionBeanService extends IBizService {
    public FunctionDTO getAllByApplicationId(long id);
    public void deleteByApplicationId(long id);
}
