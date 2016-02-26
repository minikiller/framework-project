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
        'kalix.admin.dict.component.DictCombobox'
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
    xtype: "messageSenderWindow",
    width: 400,
    //todo 在此修改表单
    items: [

        {
            xtype: 'baseForm',
            items: [
                {
                    readOnly: true,
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
                //,
                //{
                //    fieldLabel: '发送时间',
                //    allowBlank: false,
                //    xtype: 'datefield',
                //    format: 'Y-m-d',
                //    bind: {
                //        value: '{rec.send_timestamp}'
                //    }
                //},
                //{
                //    fieldLabel: '是否已读',
                //    allowBlank: false,
                //    xtype: 'numberfield',
                //    bind: {
                //        value: '{rec.read}'
                //    }
                //}
            ]
        }
    ]
});