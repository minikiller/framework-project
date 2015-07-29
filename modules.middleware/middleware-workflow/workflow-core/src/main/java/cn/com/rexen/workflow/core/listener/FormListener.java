package cn.com.rexen.workflow.core.listener;

import cn.com.rexen.workflow.api.web.IFormHandler;
import cn.com.rexen.workflow.core.manager.FormManager;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: sunlf
 * Date: 14-1-24
 * Time: 下午6:17
 * Form监听者
 */
public class FormListener {
    private static Logger logger = Logger.getLogger(FormListener.class);

    /**
     * 监听到Form
     *
     * @param formHandler
     */
    public void bind(IFormHandler formHandler) {
        logger.info("workflow " + formHandler.getProcessDefinitionId() + " is binded!");
        FormManager.getInstall().add(formHandler);

    }


    /**
     * Form被移除
     *
     * @param formHandler
     */
    public void unbind(IFormHandler formHandler) {
        logger.info("Workflow of " + formHandler.getProcessDefinitionId() + " is unbound!");
        FormManager.getInstall().remove(formHandler);
    }

}
