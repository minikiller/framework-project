/**
 * 消息首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.message.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.app.message.view.MessageGrid',
        'kalix.app.message.view.MessageSearchForm',
        'kalix.app.message.viewModel.MessageViewModel'
    ],
    storeId: 'messageStore',
    viewModel: 'messageViewModel',
    items: [
        {
            title: '消息查询',
            iconCls: 'x-fa fa-search',
            xtype: 'messageSearchForm'
        }, {
            xtype: 'messageGridPanel',
            id: 'messageGridPanel',
            title: '消息列表',
            iconCls: 'x-fa fa-search',
            margin: 10
        }
    ]
});
