package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.WorkflowStaus;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.demo.api.biz.ISealApplyBeanService;
import cn.com.rexen.demo.api.dao.ISealApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.core.WorkflowUtil;
import cn.com.rexen.demo.entities.SealApplyBean;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class SealApplyBeanServiceImpl extends ShiroGenericBizServiceImpl<ISealApplyBeanDao, SealApplyBean> implements ISealApplyBeanService {
    private IdentityService identityService;
    private TaskService taskService;
    private RuntimeService runtimeService;

    @Override
    public JsonStatus startProcess(String id) {
        JsonStatus jsonStatus = new JsonStatus();

        jsonStatus.setSuccess(true);
        try {
            String bizKey = Const.PROCESS_SEAL_APPLY_KEY_NAME + ":" + id;
            //获得当前登陆用户
            String userName = this.getShiroService().getSubject().getPrincipal().toString();
            identityService.setAuthenticatedUserId(userName);
            SealApplyBean bean = (SealApplyBean) this.getEntity(new Long(id));
            //启动流程
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(Const.PROCESS_SEAL_APPLY_KEY_NAME, bizKey);

            Task task = taskService.createTaskQuery().processInstanceId(instance.getProcessInstanceId()).singleResult();
            //设置实体状态
            bean.setProcessInstanceId(instance.getProcessInstanceId());
            bean.setCurrentNode(task.getName());
            bean.setStatus(WorkflowStaus.ACTIVE);
            this.saveEntity(bean);
            jsonStatus.setMsg("启动流程成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("启动流程失败！");
        }

        return jsonStatus;
    }

    @Override
    public JsonStatus completeTask(String taskId, String accepted, String comment) {
        JsonStatus jsonStatus = new JsonStatus();

        try {
            jsonStatus.setSuccess(true);
            String currentUserId = this.getShiroService().getSubject().getPrincipal().toString();
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            //通过任务对象获取流程实例
            final String processInstanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            //通过流程实例获取“业务键”
            String businessKey = pi.getBusinessKey();
            //拆分业务键，拆分成“业务对象名称”和“业务对象ID”的数组
            String beanId = WorkflowUtil.getBizId(businessKey);

            SealApplyBean bean = (SealApplyBean) this.getEntity(new Long(beanId));

            taskService.claim(task.getId(), currentUserId);
            //添加备注信息
            identityService.setAuthenticatedUserId(currentUserId);
            taskService.addComment(task.getId(), processInstanceId, comment);
            Map<String, Object> submitMap = new HashMap<String, Object>();
            boolean passed = accepted.equals("同意") ? true : false;
            submitMap.put("accepted", passed);
            if (!passed) {
                submitMap.put("assignee", "qwer");
            }
            taskService.complete(task.getId(), submitMap);
            Task curTask = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
            //设置实体状态
            if (curTask != null) {
                bean.setCurrentNode(curTask.getName());
                bean.setStatus(WorkflowStaus.ACTIVE);
            } else {
                bean.setCurrentNode("");
                bean.setStatus(WorkflowStaus.FINISH);
            }

            this.saveEntity(bean);
            jsonStatus.setMsg("任务处理成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("任务处理失败！");
        }
        return jsonStatus;
    }

    public IdentityService getIdentityService() {
        return identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }
}
