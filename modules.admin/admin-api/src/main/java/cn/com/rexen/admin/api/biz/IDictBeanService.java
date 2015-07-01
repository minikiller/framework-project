package cn.com.rexen.admin.api.biz;

import com.daren.admin.entities.DictBean;
import com.daren.core.api.biz.IBizService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类描述：字典服务接口类
 * @创建人：sunlf
 * @创建时间：2014-05-14 下午1:56
 * @修改人：
 * @修改时间：
 * @修改备注：
 */

public interface IDictBeanService extends IBizService {
    //机构类型
    public static final String SYS_OFFICE_TYPE = "sys_office_type";
    //机构等级
    public static final String SYS_OFFICE_GRADE = "sys_office_grade";

    /**
     * 根据类型常量获得字典项
     *
     * @param type
     * @return
     */
    List<DictBean> getDictList(String type);

    /**
     * 根据类型常量获得字典项Map
     *
     * @param type
     * @return
     */
    Map<String, String> getDictMap(String type);

    /**
     * 模糊查询
     *
     * @param dictBean
     * @return
     */
    List<DictBean> query(DictBean dictBean);

    /**
     * 查询专家组类型
     *
     * @return
     */
    @GET
    @Produces("application/json;charset=utf-8")
    @Path("/getExpertGroupList")
    public List<DictBean> getExpertGroupList();

    /**
     * dlw ext 版 标准返回结果
     * 2014-12-26-16:58
     *
     * @return
     */
    @GET
    @Produces("application/json;charset=utf-8")
    @Path("/getExpertGroupListData")
    public HashMap getExpertGroupListData(@Context HttpServletRequest request, @Context HttpServletResponse response);
}
