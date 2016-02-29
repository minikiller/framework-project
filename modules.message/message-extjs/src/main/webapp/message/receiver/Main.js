/**
 * 消息首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.receiver.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.message.receiver.view.MessageGrid',
        'kalix.message.receiver.view.MessageSearchForm',
        'kalix.message.receiver.viewModel.MessageViewModel'
    ],
    storeId: 'messageReceiverStore',
    viewModel: 'messageReceiverViewModel',
    items: [
        {
            title: '消息通知查询',
            iconCls: 'x-fa fa-search',
            xtype: 'messageReceiverSearchForm'
        }, {
            xtype: 'messageReceiverGridPanel',
            id: 'messageReceiverGridPanel',
            title: '消息通知列表',
            iconCls: 'x-fa fa-inbox',
            margin: 10
        }
    ]
});
