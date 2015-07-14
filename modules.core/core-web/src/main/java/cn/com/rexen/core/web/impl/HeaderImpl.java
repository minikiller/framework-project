package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IHeader;

/**
 * Created by sunlf on 2015/7/13.
 */
public class HeaderImpl implements IHeader {
    @Override
    public String getId() {
        return "Header";
    }

    @Override
    public String getTitle() {
        return "Header";
    }

    @Override
    public String getDescription() {
        return "Header";
    }

    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public String getComponentClass() {
        return "Kalix.view.main.region.Top";
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
