package cn.com.rexen.workflow.api.model;

import cn.com.rexen.core.api.web.model.BaseDTO;

/**
 * Created by sunlf on 2015/7/30.
 */
public class ProcessDefinitionDTO extends BaseDTO {
    private String name;
    private String key;
    private String description;
    private int version;
    private String category;
    private int suspensionState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(int suspensionState) {
        this.suspensionState = suspensionState;
    }
}
