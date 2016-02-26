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
    columns: {
        defaults: {flex: 1, renderer: 'addTooltip'},
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
                hidden: true,
            },
            //{
            //    text: '发送者',
            //    dataIndex: 'sender'
            //},
            {
                text: '接收者',
                dataIndex: 'receiver'
            },
            {
                text: '消息类别',
                xtype: 'dictGridColumn',
                dictType: 'category',
                dataIndex: 'category',
                renderer: null
            }
            ,
            {
                text: '消息主题',
                dataIndex: 'title'
            },
            {
                text: '发送时间',
                dataIndex: 'createdate',
                xtype: 'datecolumn',
                format: 'Y-m-d', renderer: null
            },

            {
                xtype: 'securityGridColumnRUD',
                //todo change permission
                permissions: [
                    'admin:constructModule:messageMenu:view',
                    'admin:constructModule:messageMenu:edit',
                    'admin:constructModule:messageMenu:delete'
                ]
            }
        ]
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                //todo change permission
                permission: 'admin:constructModule:messageMenu:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
