package cn.com.rexen.bean;

public class CategoryBean {
    /**
     * @describe 分类名称
     * @validator 不能为空
     */
    private String name; //分类名称
    /**
     * @describe 分类主键
     * @validator 不能为空
     */
    private String key; //分类主键
    /**
     * @describe 分类图标
     * @validator 不能为空
     */
    private String icon;//分类图标
    /**
     * @describe 分类描述
     * @validator 不能为空
     */
    private String description;//分类描述

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
