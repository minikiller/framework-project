package cn.com.rexen.workflow.core.impl;

import cn.com.rexen.workflow.api.biz.IProcessService;
import cn.com.rexen.workflow.api.model.JsonData;
import cn.com.rexen.workflow.api.model.ProcessDefinitionDTO;
import cn.com.rexen.workflow.core.DozerHelper;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.List;

/**
 * Created by sunlf on 2015/7/30.
 */
public class ProcessServiceImpl implements IProcessService {
    private transient RepositoryService repositoryService;

    /**
     * 获得流程定义列表
     *
     * @return
     */
    @Override
    public JsonData getProcessDefinition() {
        JsonData jsonData = new JsonData();
        List<ProcessDefinitionDTO> processDefinitionDTOList = null;
        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery().latestVersion().list();
        if (processDefinitionList != null) {
            Mapper mapper = new DozerBeanMapper();
            processDefinitionDTOList = DozerHelper.map(mapper, processDefinitionList, ProcessDefinitionDTO.class);
            jsonData.setTotalCount(processDefinitionDTOList.size());
            jsonData.setData(processDefinitionDTOList);
        }
        return jsonData;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }
}
