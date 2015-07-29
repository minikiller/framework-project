package cn.com.rexen.workflow.api.web;

/**
 * 实现工作流form的统一接口
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
     * 获得extjs的类名称
     *
     * @return
     */
    String getComponentClass();
}
