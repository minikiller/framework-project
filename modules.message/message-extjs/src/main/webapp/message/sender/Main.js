/**
 * 消息首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.sender.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.message.sender.view.MessageGrid',
        'kalix.message.sender.view.MessageSearchForm',
        'kalix.message.sender.viewModel.MessageViewModel'
    ],
    storeId: 'messageSenderStore',
    viewModel: 'messageSenderViewModel',
    items: [
        {
            title: '发件查询',
            iconCls: 'x-fa fa-search',
            xtype: 'messageSenderSearchForm'
        }, {
            xtype: 'messageSenderGridPanel',
            id: 'messageSenderGridPanel',
            title: '发件列表',
            iconCls: 'x-fa fa-share',
            margin: 10
        }
    ]
});
