/**
 * 消息查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.receiver.view.MessageSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    requires: [
        'kalix.admin.dict.component.DictCombobox'
    ],
    alias: 'widget.messageReceiverSearchForm',
    xtype: 'messageReceiverSearchForm',
    storeId: 'messageReceiverStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '发送者',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: 'senderId'
        },
        {
            xtype: 'dictCombobox',
            fieldLabel: '消息类别',
            dictType: 'category',
            name: 'category',
            bind: {
                value: '{rec.category}'
            }
        },
        {
            xtype: 'textfield',
            fieldLabel: '消息主题',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: 'title'
        },
        {
            xtype: 'datefield',
            format: 'Y-m-d',
            fieldLabel: '收件时间:',
            labelAlign: 'right',
            labelWidth: 120,
            width: 260,
            name: 'creationDate:begin:gt'
        },
        {
            xtype: 'displayfield',
            hideLabel: true,
            value: '-',
            margin: '0 5 0 5'
        },
        {
            xtype: 'datefield',
            format: 'Y-m-d',
            headLabel: true,
            labelAlign: 'right',
            width: 140,
            name: 'creationDate:end:lt'
        }
    ]

});
