package cn.com.rexen.audit.web.impl;

import cn.com.rexen.core.api.web.IMenu;
import cn.com.rexen.core.impl.web.AbstractMenuImpl;

/**
 * 审计菜单
 *
 * @author majian <br/>
 *         date:2015-8-10
 * @version 1.0.0
 */
public class AuditMenuImpl extends AbstractMenuImpl implements IMenu {
    @Override
    public String getIconCls() {
        return "iconfont icon-operation-management";
    }
}
