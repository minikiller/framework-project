package cn.com.vixo.plan;

import java.util.Date;

/**
 * Created by zangyanming on 2016/4/8.
 */
public class PlanBean {
    /**
     * @describe 项目计划名称
     * @validator 不能为空
     */
    private String planTaskName;
    /**
     * @describe 项目计划工期
     * @validator 不能为空
     */
    private int planTaskTime;
    /**
     * @describe 项目计划开始时间
     * @validator 不能为空
     */
    private Date planBeginTime;
    /**
     * @describe 项目计划结束时间
     * @validator 不能为空
     */
    private Date planEndTime;
    /**
     * @describe 项目负责人
     * @validator 不能为空
     */
    private String principal;
    /**
     * @describe 项目里程碑
     */
    private int milestone;
    /**
     * @describe 父项目计划id
     */
    private long parentProjectPlanId;
    /**
     * @describe 项目主键id
     * @validator 不能为空
     */
    private long projectId;
}
