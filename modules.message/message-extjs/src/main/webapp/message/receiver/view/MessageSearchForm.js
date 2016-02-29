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
            name: 'senderid'
        },
        //{
        //    xtype: 'textfield',
        //    fieldLabel: '接收者',
        //    labelAlign: 'right',
        //    labelWidth: 60,
        //    width: 200,
        //    name: 'receiverid'
        //},
        //{
        //    xtype: 'textfield',
        //    fieldLabel: '消息类别',
        //    labelAlign: 'right',
        //    labelWidth: 60,
        //    width: 200,
        //    name: 'category'
        //},
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
        //{
        //    xtype: 'textfield',
        //    fieldLabel: '消息内容',
        //    labelAlign: 'right',
        //    labelWidth: 60,
        //    width: 200,
        //    name: 'content'
        //},
        {
            xtype: 'datefield',
            format: 'Y-m-d',
            fieldLabel: '发送时间:',
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
        //,
        //{
        //    xtype: 'textfield',
        //    name: 'receiverid',
        //    value:'42343'
        //}
    ]

});
