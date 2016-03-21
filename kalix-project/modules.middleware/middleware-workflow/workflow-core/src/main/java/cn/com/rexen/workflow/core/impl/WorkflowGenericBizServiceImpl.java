package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.IGenericDao;
import cn.com.rexen.core.api.persistence.WorkflowEntity;
import cn.com.rexen.core.api.persistence.WorkflowStaus;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.workflow.api.util.WorkflowUtil;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.DelegationState;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 2016-03-03.
 * 工作流抽象类，封装通用方法
 */
public abstract class  WorkflowGenericBizServiceImpl<T extends IGenericDao, TP extends WorkflowEntity> extends ShiroGenericBizServiceImpl<T, TP> {
    protected IdentityService identityService;
    protected TaskService taskService;
    protected RuntimeService runtimeService;

    /**
     * 获得工作流主键名称，需要子类重载
     * @return
     */
    public abstract String getProcessKeyName();

    /**
     * 启动工作流
     * @param id 业务模型id
     * @return
     */

    public JsonStatus startProcess(String id) {
        JsonStatus jsonStatus = new JsonStatus();

        jsonStatus.setSuccess(true);
        try {
            String bizKey = getProcessKeyName() + ":" + id;
            //获得当前登陆用户
//            String userName=this.getShiroService().getCurrentUserName();
            String userName = this.getShiroService().getSubject().getPrincipal().toString();
            identityService.setAuthenticatedUserId(userName);
            TP bean = this.getEntity(new Long(id));
            //启动流程
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(getProcessKeyName(), bizKey);

            Task task = taskService.createTaskQuery().processInstanceId(instance.getProcessInstanceId()).singleResult();
            //设置实体状态
            bean.setProcessInstanceId(instance.getProcessInstanceId());
            bean.setCurrentNode(task.getName());
            bean.setStatus(WorkflowStaus.ACTIVE);
            bean.setAuditResult("审批中...");
            this.updateEntity(bean);
            jsonStatus.setMsg("启动流程成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("启动流程失败！");
        }
        return jsonStatus;
    }

    /**
     * 完成人工任务
     * @param taskId
     * @param accepted
     * @param comment
     * @return
     */
    public JsonStatus completeTask(String taskId, String accepted, String comment) {
        JsonStatus jsonStatus = new JsonStatus();

        try {
            jsonStatus.setSuccess(true);
            String currentUserId = this.getShiroService().getSubject().getPrincipal().toString();
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            String currentTaskName = task.getName();
            //通过任务对象获取流程实例
            final String processInstanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            //通过流程实例获取“业务键”
            String businessKey = pi.getBusinessKey();
            //拆分业务键，拆分成“业务对象名称”和“业务对象ID”的数组
            String beanId = WorkflowUtil.getBizId(businessKey);

            TP bean = this.getEntity(new Long(beanId));

            String userName=this.getShiroService().getCurrentUserName();
            //判断是否有人委托
            if (task.getDelegationState()!=null && task.getDelegationState().equals(DelegationState.PENDING)) {
                taskService.resolveTask(task.getId());
            } else {
                taskService.claim(task.getId(), currentUserId);
            }

            writeClaimResult(currentTaskName,userName, bean);

            //添加备注信息
            identityService.setAuthenticatedUserId(userName);
            taskService.addComment(task.getId(), processInstanceId, comment);
            Map<String, Object> submitMap = new HashMap<String, Object>();
            boolean passed = accepted.equals("同意") ? true : false;
            submitMap.put("accepted", passed);
//            submitMap.put("city", bean.isCity());
            /*if (!passed) {
                submitMap.put("assignee", "qwer");
            }*/
            taskService.complete(task.getId(), getVariantMap(submitMap,bean));
            List<Task> curTask = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
            //设置实体状态
            if (curTask.size() > 0) {//流程未结束
                bean.setCurrentNode(curTask.get(0).getName());
                bean.setStatus(WorkflowStaus.ACTIVE);
            } else {//流程已结束
                bean.setCurrentNode("");
                bean.setStatus(WorkflowStaus.FINISH);
                String result = passed ? "审批通过" : currentTaskName + "不通过";
                bean.setAuditResult(result);
            }

            this.updateEntity(bean);
            jsonStatus.setMsg("任务处理成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("任务处理失败！");
        }
        return jsonStatus;
    }

    /**
     * 添加处理人的名字到实体中
     *
     * @param currentTaskName
     * @param bean
     */
    public abstract void writeClaimResult(String currentTaskName, String userName,TP bean);

    /**
     * 加入流程环节变量到map中
     * @param map
     * @return
     */
    public abstract Map getVariantMap(Map map,TP bean);

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
}
