/**
 * 消息新增和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.message.view.MessageWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.app.message.viewModel.MessageViewModel',
        'kalix.controller.BaseWindowController',
        'kalix.admin.user.store.UserStore'
    ],
    alias: 'widget.messageWindow',
    viewModel: 'messageViewModel',
    controller: {
        type: 'baseWindowController',
        storeId: 'messageStore'
    },
    xtype: "messageWindow",
    width: 400,
    //todo 在此修改表单
    items: [

        {
            xtype: 'baseForm',
            items: [
                {
                    fieldLabel: '发送者',
                    allowBlank: false,
                    bind: {
                        value: '{rec.sender}'
                    }
                },
                {
                    fieldLabel: '接收者',
                    allowBlank: false,
                    bind: {
                        value: '{rec.receiver}'
                    }
                },
                {
                    fieldLabel: '消息类别',
                    allowBlank: false,
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
                    allowBlank: false,
                    bind: {
                        value: '{rec.content}'
                    }
                },
                {
                    fieldLabel: '发送时间',
                    allowBlank: false,
                    xtype: 'datefield',
                    format: 'Y-m-d',
                    bind: {
                        value: '{rec.send_timestamp}'
                    }
                },
                {
                    fieldLabel: '是否已读',
                    allowBlank: false,
                    xtype: 'numberfield',
                    bind: {
                        value: '{rec.read}'
                    }
                }
            ]
        }
    ]
});