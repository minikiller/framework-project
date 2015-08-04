package cn.com.rexen.app.api.biz;

import cn.com.rexen.admin.entities.RoleFunctionBean;
import cn.com.rexen.app.dto.model.ApplicationDTO;
import cn.com.rexen.app.dto.model.AuthorizationDTO;
import cn.com.rexen.app.dto.model.FunctionDTO;
import cn.com.rexen.app.entities.FunctionBean;
import cn.com.rexen.core.api.biz.IBizService;
import org.dozer.Mapper;

import java.util.List;

/**
 * 功能服务接口.
 * @author majian <br/>
 *         date:2015-7-30
 * @version 1.0.0
 */
public interface IFunctionBeanService extends IBizService {
    /**
     * 返回指定应用下所有功能节点
     * @param id
     * @return
     */
    public FunctionDTO getAllByApplicationId(long id);

    /**
     * 删除指定应用下所有功能
     * @param id
     */
    public void deleteByApplicationId(long id);

    /**
     * 返回所有根节点
     * @param elements
     * @return
     */
    public List<FunctionBean> getRootElements(List<FunctionBean> elements);

    /**
     * 返回子节点
     * @param root
     * @param elements
     * @param mapper
     */
    public void getChilden(AuthorizationDTO root, List<FunctionBean> elements, Mapper mapper);

    /**
     * 返回子节点并设置选中状态
     * @param root
     * @param elements
     * @param mapper
     */
    public void getChilden(AuthorizationDTO root, List<FunctionBean> elements, Mapper mapper,List<RoleFunctionBean> roleFunctionBeans);
}
