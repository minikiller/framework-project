package cn.com.rexen.workflow.api.web;

/**
 * 实现工作流业务数据的统一接口,用于流程历史查看
 */
public interface IBizDataHandler {

    /**
     * 返回业务数据的描述
     *
     * @return
     */
    String getBizName();

    /**
     * 获得form的实现Extjs类
     *
     * @return
     */
    String getComponentClass(String bizId);

    /**
     * 获得流程定义名称
     *
     * @return
     */
    String getProcessDefinitionId();
}
