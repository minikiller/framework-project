/**
 * 消息新增和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.sender.view.MessageWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.message.sender.viewModel.MessageViewModel',
        'kalix.message.sender.controller.MessageWindowController',
        'kalix.admin.user.store.UserStore',
        'kalix.admin.dict.component.DictCombobox',
        'kalix.admin.user.component.UserTagField'
    ],
    alias: 'widget.messageSenderWindow',
    viewModel: 'messageSenderViewModel',
    controller: {
        type: 'messageSenderWindowController',
        storeId: 'messageSenderStore'
    },
    listeners: {
        show: 'onShow'
    },
    iconCls: 'iconfont icon-add',
    xtype: "messageSenderWindow",
    width: 600,
    modal: true,
    //todo 在此修改表单
    items: [
        {
            xtype: 'baseForm',
            items: [
                {
                    fieldLabel: '收件人',
                    xtype: 'userTagField',
                    listeners: {
                        change: 'onChange'
                    },
                    bind: {
                        value: '{rec.receiverNames}'
                    }
                },
                {
                    fieldLabel: '消息类别',
                    xtype: 'dictCombobox',
                    dictType: 'category',
                    name: 'category',
                    bind: {
                        value: '{rec.category}'
                    }
                },
                {
                    fieldLabel: '消息主题',
                    allowBlank: false,
                    bind: {
                        value: '{rec.title}'
                    }
                },
                {
                    fieldLabel: '消息内容',
                    xtype: 'textareafield',
                    allowBlank: false,
                    bind: {
                        value: '{rec.content}'
                    }
                }
            ]
        }
    ]
});