package cn.com.rexen.demo.core.biz;

import cn.com.rexen.core.api.biz.JsonStatus;
import cn.com.rexen.core.api.persistence.WorkflowStaus;
import cn.com.rexen.core.impl.biz.GenericBizServiceImpl;
import cn.com.rexen.demo.api.biz.INoticeBeanService;
import cn.com.rexen.demo.api.dao.INoticeBeanDao;
import cn.com.rexen.demo.core.Const;
import cn.com.rexen.demo.entities.NoticeBean;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.UUID;

/**
 * @类描述：公告管理
 * @创建人： zhangqingxin
 * @创建时间：2014/10/10
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class NoticeBeanServiceImpl extends GenericBizServiceImpl implements INoticeBeanService {
    private INoticeBeanDao noticeBeanDao;
    private RepositoryService repositoryService;
    private FormService formService;
    private IdentityService identityService;
    private RuntimeService runtimeService;
    private TaskService taskService;

    private String uuid;

    public NoticeBeanServiceImpl() {
        uuid = UUID.randomUUID().toString();
    }

    public void setNoticeBeanDao(INoticeBeanDao demoBeanDao) {
        this.noticeBeanDao = demoBeanDao;
        super.init(demoBeanDao, NoticeBean.class.getName());
    }

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
        return noticeBeanDao.find("select n from demoBean n where n.title LIKE ?1 ", "%" + title + "%");
    }

    public JsonStatus startProcess(String id) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            String bizKey = Const.PROCESS_KEY_NAME + ":" + id;
            //获得当前登陆用户
            identityService.setAuthenticatedUserId("test");
            NoticeBean bean = (NoticeBean) this.getEntity(new Long(id));
            //启动流程
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(Const.PROCESS_KEY_NAME, bizKey);

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
            jsonStatus.setMsg("启动流程失败！");
        }
        return jsonStatus;
    }
}
