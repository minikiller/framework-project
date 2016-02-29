/**
 * 消息表格控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.sender.controller.MessageWindowController', {
    extend: 'kalix.controller.BaseWindowController',
    alias: 'controller.messageSenderWindowController',
    onShow: function () {
        this.getView().lookupViewModel().getData().rec.set('senderid', Ext.util.Cookies.get('currentUserName') || '系统管理员');
        this.getView().lookupViewModel().getData().rec.dirty = false;
    }
});
