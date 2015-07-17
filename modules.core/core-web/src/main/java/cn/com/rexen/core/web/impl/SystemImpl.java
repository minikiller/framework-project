package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IBody;
import cn.com.rexen.core.api.web.IFooter;
import cn.com.rexen.core.api.web.IHeader;
import cn.com.rexen.core.api.web.ISystem;

/**
 * Created by sunlf on 2015/7/13.
 */
//@OsgiServiceProvider
public class SystemImpl implements ISystem {
    private IHeader header;
    private IFooter footer;
    private IBody body;

    @Override
    public IHeader getHeader() {
        return header;
    }

    public void setHeader(IHeader header) {
        this.header = header;
    }

    @Override
    public IFooter getFooter() {
        return footer;
    }

    public void setFooter(IFooter footer) {
        this.footer = footer;
    }

    @Override
    public IBody getBody() {
        return body;
    }

    public void setBody(IBody body) {
        this.body = body;
    }
}
