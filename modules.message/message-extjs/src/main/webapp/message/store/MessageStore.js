/**
 * 消息数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.message.store.MessageStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.app.message.model.MessageModel',
    alias: 'store.messageStore',
    xtype: 'messageStore',
    storeId: "messageStore",
    proxyUrl: '/kalix/camel/rest/messages'
});