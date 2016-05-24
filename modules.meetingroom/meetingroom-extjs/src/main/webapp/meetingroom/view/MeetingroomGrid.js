/**
 * 会议室表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.meetingroom.view.MeetingroomGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.app.meetingroom.controller.MeetingroomGridController',
        'kalix.app.meetingroom.store.MeetingroomStore'
    ],
    alias: 'widget.meetingroomGrid',
    xtype: 'meetingroomGridPanel',
    controller: {
        type: 'meetingroomGridController',
        storeId: 'meetingroomStore',
        cfgForm: 'kalix.app.meetingroom.view.MeetingroomWindow',
        cfgViewForm: 'kalix.app.meetingroom.view.MeetingroomViewWindow',
        cfgModel: 'kalix.app.meetingroom.model.MeetingroomModel'
    },
    store: {
        type: 'meetingroomStore'
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
                hidden: true
            },
            {
                text: '会议室名称',
                dataIndex: 'name'
            },
            {
                text: '会议室地址',
                dataIndex: 'address'
            },
            {
                text: '容纳人数',
                dataIndex: 'capacity'
            },
            {
                text: '会议室设备说明',
                dataIndex: 'equipment'
            },
            {
                text: '会议室描述',
                dataIndex: 'description'
            },

            {
                xtype: 'securityGridColumnRUD',
                //todo change permission
                permissions: [
                    'workflow:sysWorkFlowModule:meetingroomMenu:view',
                    'workflow:sysWorkFlowModule:meetingroomMenu:edit',
                    'workflow:sysWorkFlowModule:meetingroomMenu:delete'
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
                permission: '',
                permission: 'workflow:sysWorkFlowModule:meetingroomMenu:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
