package cn.com.rexen.core.api.web.model;

import java.util.List;

/**
 * Created by sunlf on 2015/7/14.
 */
public class ModuleBean extends BaseWebPage {

    private List<MenuBean> children;

    public List<MenuBean> getChildren() {
        return children;
    }

    public void setChildren(List<MenuBean> children) {
        this.children = children;
    }

}
