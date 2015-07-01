package cn.com.rexen.admin.api.biz;


import cn.com.rexen.admin.entities.UserBean;
import cn.com.rexen.core.api.biz.IBizService;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public interface IUserBeanService extends IBizService {
    public UserBean addUser(UserBean user);

    public void delUser(UserBean user);

    public void saveUser(UserBean user);


    public List<UserBean> getAllUser();

    List<UserBean> queryUser(UserBean userBean, int is_ent);

    /**
     * 分页查询用户
     *
     * @param userName   用户名
     * @param pageNumber 页数
     * @param pageSize   每页大小
     * @return 用户结果集
     */
    public List<UserBean> queryUser(String userName, int pageNumber, int pageSize);

    List<UserBean> query(UserBean userBean, int is_ent);

    /**
     * 生成roleList列表，以逗号分隔
     *
     * @param userBean 用户
     * @return
     */
    public String getRoleList(UserBean userBean);

    /**
     * 保存用户以及相关的角色
     *
     * @param userBean
     * @param roleSelect
     */
    void saveUserRole(UserBean userBean, List<String> roleSelect);

    void saveUserRoleNew(UserBean userBean, List<String> roleSelect);

    /**
     * 获得当前登陆用户名称
     *
     * @return
     */
    String getCurrentUserName();

    /**
     * 获得当前登陆用户登陆名称
     *
     * @return
     */
    String getCurrentUserLoginName();

    /**
     * 获得当前登陆用户实体
     *
     * @return
     */
    UserBean getCurrentUser();

    /**
     * 获取当前用户所在地区的代码
     *
     * @return
     */
    public String getCurrUserInQhdm();

    /**
     * 通过用户id串获取用户token集合
     *
     * @param id
     * @return
     */
    public List getUserTokenListByIds(Long id);

    /**
     * 通过jgdm获取用户token集合
     *
     * @return
     */
    public List getUserTokenListJgdm(String jgdm, long user_id);

    /**
     * 根据日程id获取不同类型用户token
     *
     * @param notice_id
     * @return
     */
    public List getUserTokenListByNoticeId(Long notice_id, int reply_type, long user_id);

    /**
     * 根据机构代码串获取这些机构下的所有用户
     *
     * @param jgdm
     * @return
     */
    public List getUseridListByGgdm(String jgdm, long user_id);

    public List<UserBean> getUserListByCond(int is_ent_user);

    public UserBean getUserBeanByUsername(String username);

    /**
     * 将用户置为无效
     *
     * @param relateId
     */
    public void setUserUnavailable(String relateId);

    /**
     * 根据隐患排查传过来的信息修改用户
     *
     * @param relateId
     * @return
     */
    public UserBean getUserByRelateId(String relateId);

}
