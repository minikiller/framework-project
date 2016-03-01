/**
 * 消息查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.sender.view.MessageSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    requires: [
        'kalix.admin.dict.component.DictCombobox'
    ],
    alias: 'widget.messageSenderSearchForm',
    xtype: 'messageSenderSearchForm',
    storeId: 'messageSenderStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '接收者',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: 'receiverid'
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
            fieldLabel: '发件时间:',
            labelAlign: 'right',
            labelWidth: 120,
            width: 260,
            name: 'send_timestamp:begin:gt'
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
            name: 'send_timestamp:end:lt'
        }
    ]
});
