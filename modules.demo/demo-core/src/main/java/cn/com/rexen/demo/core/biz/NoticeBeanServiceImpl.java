package cn.com.rexen.demo.core.biz;

import cn.com.rexen.audit.core.biz.AuditBizServiceImpl;
import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.WorkflowStaus;
import cn.com.rexen.core.api.security.IUserLoginService;
import cn.com.rexen.demo.api.biz.INoticeBeanService;
import cn.com.rexen.demo.api.dao.INoticeBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.core.WorkflowUtil;
import cn.com.rexen.demo.entities.NoticeBean;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class NoticeBeanServiceImpl extends AuditBizServiceImpl<INoticeBeanDao, NoticeBean> implements INoticeBeanService {
    //    private INoticeBeanDao dao;
    private RepositoryService repositoryService;
    private FormService formService;
    private IdentityService identityService;
    private RuntimeService runtimeService;
    private TaskService taskService;
    private IUserLoginService userLoginService;
    private JsonStatus jsonStatus = new JsonStatus();

    private String uuid;

    public NoticeBeanServiceImpl() {
        uuid = UUID.randomUUID().toString();
        super.init(NoticeBean.class.getName());
    }

    @Override
    public String getAppName() {
        return "Hello";
    }

    @Override
    public String getFunName() {
        return "test";
    }

    public void setUserLoginService(IUserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

//    public void setNoticeBeanDao(INoticeBeanDao demoBeanDao) {
//        this.dao = demoBeanDao;
//
//    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void setFormService(FormService formService) {
        this.formService = formService;
    }

    public void setIdentityService(IdentityService identityService) {
        this.identityService = identityService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public List<NoticeBean> query(String title) {
        return dao.find("select n from demoBean n where n.title LIKE ?1 ", "%" + title + "%");
    }

    /**
     * 启动流程实例
     *
     * @param entityId 实体id
     * @return
     */
    @Override
    public JsonStatus startProcess(String entityId) {

        jsonStatus.setSuccess(true);
        try {
            String bizKey = Const.PROCESS_Notice_KEY_NAME+ ":" + entityId;
            //获得当前登陆用户
            String userName = userLoginService.getLoginName();
            identityService.setAuthenticatedUserId(userName);
            NoticeBean bean = (NoticeBean) this.getEntity(new Long(entityId));
            //启动流程
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(Const.PROCESS_Notice_KEY_NAME, bizKey);

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

    /**
     * 完成任务节点
     *
     * @param taskId   任务id
     * @param accepted “同意”或者“不同意”
     * @param comment  审批意见
     * @return
     */
    @Override
    public JsonStatus completeTask(String taskId, String accepted, String comment) {
        try {
            jsonStatus.setSuccess(true);
            String currentUserId = userLoginService.getLoginName();
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            //通过任务对象获取流程实例
            final String processInstanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            //通过流程实例获取“业务键”
            String businessKey = pi.getBusinessKey();
            //拆分业务键，拆分成“业务对象名称”和“业务对象ID”的数组
            String beanId = WorkflowUtil.getBizId(businessKey);

            NoticeBean bean = (NoticeBean) this.getEntity(new Long(beanId));

            taskService.claim(task.getId(), currentUserId);
            //添加备注信息
            identityService.setAuthenticatedUserId(currentUserId);
            taskService.addComment(task.getId(), processInstanceId, comment);
            Map<String, Object> submitMap = new HashMap<String, Object>();
            boolean passed = accepted.equals("同意") ? true : false;
            submitMap.put("accepted", passed);
            if(!passed){
                submitMap.put("assignee","qwer");
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

    /**
     * 编辑任务
     *
     * @param taskId   任务id
     * @return
     */
    @Override
    public JsonStatus completeTask(String taskId) {
        try {
            jsonStatus.setSuccess(true);
            String currentUserId = userLoginService.getLoginName();
            Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
            //通过任务对象获取流程实例
            final String processInstanceId = task.getProcessInstanceId();
            ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            //通过流程实例获取“业务键”
            String businessKey = pi.getBusinessKey();
            //拆分业务键，拆分成“业务对象名称”和“业务对象ID”的数组
            String beanId = WorkflowUtil.getBizId(businessKey);

            NoticeBean bean = (NoticeBean) this.getEntity(new Long(beanId));

            taskService.claim(task.getId(), currentUserId);
            //添加备注信息
            identityService.setAuthenticatedUserId(currentUserId);
            Map<String, Object> submitMap = new HashMap<String, Object>();
            taskService.complete(task.getId());
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
}
