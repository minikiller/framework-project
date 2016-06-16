/**
 * 消息表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.sender.view.MessageGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.message.sender.controller.MessageGridController',
        'kalix.message.sender.store.MessageStore',
        'kalix.admin.dict.component.DictGridColumn'
    ],
    alias: 'widget.messageGrid',
    xtype: 'messageSenderGridPanel',
    controller: {
        type: 'messageSenderGridController',
        storeId: 'messageSenderStore',
        cfgForm: 'kalix.message.sender.view.MessageWindow',
        cfgViewForm: 'kalix.message.sender.view.MessageViewWindow',
        cfgModel: 'kalix.message.sender.model.MessageModel'
    },
    store: {
        type: 'messageSenderStore'
    },

    //todo 在此修改grid显示列
    stripeRows: true,
    manageHeight: true,
    forceFit: true,
    selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
    columns: {
        defaults: {
            //renderer: 'addTooltip',
            flex: 1
        },
        items: [
            {
                xtype: "rownumberer",
                text: "行号",
                width: 50,
                flex: 0,
                align: 'center',
                renderer: this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true
            },
            {
                text: '收件人',
                dataIndex: 'receiverNames'
            },
            {
                text: '消息类别',
                xtype: 'dictGridColumn',
                dictType: 'category',
                dataIndex: 'category',
                renderer: null
            },
            {
                text: '消息主题',
                dataIndex: 'title'
            },
            {
                text: '发件时间',
                dataIndex: 'creationDate'
            },

            {
                xtype: 'securityGridColumnCommon',
                items: [
                    {
                        iconCls: 'iconfont icon-view-column',
                        permission: '',
                        tooltip: '查看',
                        handler: 'onView'
                    },
                    {
                        iconCls: 'iconfont icon-delete',
                        permission: '',
                        tooltip: '删除',
                        handler: 'onDelete'
                    }
                ]
            }
        ]
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '批量删除',
                permission: '',
                iconCls: 'iconfont icon-delete',
                handler: 'onBatchDelete'
            }
        ]
    }
});
