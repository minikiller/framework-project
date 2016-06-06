package cn.com.rexen.workflow.api.web;

/**
 * 实现工作流form的统一接口，用于流程执行过程中的界面显示
 */
public interface IFormHandler {
    /**
     * 获得form的key
     *
     * @return
     */
    String getFormKey();

    /**
     * 获得流程定义名称
     *
     * @return
     */
    String getProcessDefinitionId();

    /**
     * 获得extjs的表单类名称
     *
     * @return
     */
    String getFormClass();

    /**
     * 获得extjs的窗口类名称
     *
     * @return
     */
    String getWindowClass();


}
