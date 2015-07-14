package cn.com.rexen.core.web.impl;

import cn.com.rexen.core.api.web.IBody;
import cn.com.rexen.core.api.web.IFooter;
import cn.com.rexen.core.api.web.IHeader;
import cn.com.rexen.core.api.web.ISystem;
import org.ops4j.pax.cdi.api.OsgiService;

/**
 * Created by sunlf on 2015/7/13.
 */
//@OsgiServiceProvider
public class SystemImpl implements ISystem {
    @OsgiService
    IHeader header;
    @OsgiService
    IFooter footer;
    @OsgiService
    IBody body;

    @Override
    public IHeader getHeader() {
        return header;
    }

    @Override
    public IFooter getFooter() {
        return footer;
    }

    @Override
    public IBody getBody() {
        return body;
    }
}
