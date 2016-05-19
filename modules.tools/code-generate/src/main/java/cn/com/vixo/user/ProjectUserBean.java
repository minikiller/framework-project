package cn.com.vixo.user;

/**
 * Created by zangyanming on 2016/3/30.
 */
public class ProjectUserBean {
    /**
     * @describe 项目主键id
     * @validator 不能为空
     */
    private long projectId;
    /**
     * @describe 组主键id
     * @validator 不能为空
     */
    private long groupId;
    /**
     * @describe 用户主键id
     * @validator 不能为空
     */
    private long userId;
    /**
     * @describe 是否是主管
     */
    private boolean isDataSupervisor;
    /**
     * @describe 是否分配任务
     */
    private boolean isAssignTask;

}
