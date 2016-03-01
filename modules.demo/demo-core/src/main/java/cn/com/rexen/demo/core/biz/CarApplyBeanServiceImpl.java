package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.WorkflowStaus;
import cn.com.rexen.core.impl.biz.ShiroGenericBizServiceImpl;
import cn.com.rexen.demo.api.biz.ICarApplyBeanService;
import cn.com.rexen.demo.api.dao.ICarApplyBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.core.WorkflowUtil;
import cn.com.rexen.demo.entities.CarApplyBean;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class CarApplyBeanServiceImpl extends ShiroGenericBizServiceImpl<ICarApplyBeanDao, CarApplyBean> implements ICarApplyBeanService {
    private IdentityService identityService;
    private TaskService taskService;
    private RuntimeService runtimeService;

    @Override
    public JsonStatus startProcess(String id) {
        JsonStatus jsonStatus = new JsonStatus();

        jsonStatus.setSuccess(true);
        try {
            String bizKey = Const.PROCESS_CAR_APPLY_KEY_NAME + ":" + id;
            //获得当前登陆用户
//            String userName=this.getShiroService().getCurrentUserName();
            String userName = this.getShiroService().getSubject().getPrincipal().toString();
            identityService.setAuthenticatedUserId(userName);
            CarApplyBean bean = this.getEntity(new Long(id));
            //启动流程
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(Const.PROCESS_CAR_APPLY_KEY_NAME, bizKey);

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

    @Override
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

            CarApplyBean bean = this.getEntity(new Long(beanId));

            String userName=this.getShiroService().getCurrentUserName();
            taskService.claim(task.getId(), currentUserId);
            writeClaimResult(currentTaskName,userName, bean);

            //添加备注信息
            identityService.setAuthenticatedUserId(userName);
            taskService.addComment(task.getId(), processInstanceId, comment);
            Map<String, Object> submitMap = new HashMap<String, Object>();
            boolean passed = accepted.equals("同意") ? true : false;
            submitMap.put("accepted", passed);
            submitMap.put("city", bean.isCity());
            /*if (!passed) {
                submitMap.put("assignee", "qwer");
            }*/
            taskService.complete(task.getId(), submitMap);
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
    private void writeClaimResult(String currentTaskName, String userName,CarApplyBean bean) {

        if (currentTaskName.equals("正处级领导审核")) //申请部门负责人签字
            bean.setDepUser(userName);
        else if (currentTaskName.equals("副校级领导审核")) //副校级领导审核
            bean.setManagerUser(userName);
        else if (currentTaskName.equals("校务部副部长审核")) //校务部签字
            bean.setSchoolUser(userName);
        else if (currentTaskName.equals("校党委书记审核")) //校务部主管领导审批（市外）
            bean.setSchoolManagerUser(userName);

    }

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
