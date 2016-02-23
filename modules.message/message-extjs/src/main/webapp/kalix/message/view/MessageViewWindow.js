/**
 * 消息查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.app.message.view.MessageViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.app.message.viewModel.MessageViewModel',
        'kalix.admin.user.store.UserStore'
    ],
    alias: 'widget.messageViewWindow',
    viewModel: 'messageViewModel',
    xtype: "messageViewWindow",
    width: 400,
    //todo 在此修改查看字段
    items: [{
        defaults: {readOnly: true},
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
            },
            {
                fieldLabel: '消息状态',
                allowBlank: false,
                xtype: 'numberfield',
                bind: {
                    value: '{rec.message_state}'
                }
            },
            {
                fieldLabel: '消息标识',
                allowBlank: false,
                xtype: 'numberfield',
                bind: {
                    value: '{rec.sign}'
                }
            }
        ]
    }

    ]


});