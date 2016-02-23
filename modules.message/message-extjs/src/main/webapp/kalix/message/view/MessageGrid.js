/**
 * 消息表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.message.view.MessageGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.app.message.controller.MessageGridController',
        'kalix.app.message.store.MessageStore',
    ],
    alias: 'widget.messageGrid',
    xtype: 'messageGridPanel',
    controller: {
        type: 'messageGridController',
        storeId: 'messageStore',
        cfgForm: 'kalix.app.message.view.MessageWindow',
        cfgViewForm: 'kalix.app.message.view.MessageViewWindow',
        cfgModel: 'kalix.app.message.model.MessageModel'
    },
    store: {
        type: 'messageStore'
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
            {
                text: '发送者',
                dataIndex: 'sender'
            },
            {
                text: '接收者',
                dataIndex: 'receiver'
            },
            {
                text: '消息类别',
                dataIndex: 'category'
            },
            {
                text: '消息主题',
                dataIndex: 'title'
            },
            {
                text: '发送时间',
                dataIndex: 'send_timestamp',
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
