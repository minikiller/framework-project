/**
 * 会议室新增和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.meetingroom.view.MeetingroomWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.app.meetingroom.viewModel.MeetingroomViewModel',
        'kalix.controller.BaseWindowController',
        'kalix.admin.user.store.UserStore'
    ],
    alias: 'widget.meetingroomWindow',
    viewModel: 'meetingroomViewModel',
    controller: {
        type: 'baseWindowController',
        storeId: 'meetingroomStore'
    },
    xtype: "meetingroomWindow",
    width: 400,
    //todo 在此修改表单
    items: [

        {
            xtype: 'baseForm',
            items: [
                {
                    fieldLabel: '会议室名称',
                    allowBlank: false,
                    bind: {
                        value: '{rec.name}'
                    }
                },
                {
                    fieldLabel: '会议室地址',
                    allowBlank: false,
                    bind: {
                        value: '{rec.address}'
                    }
                },
                {
                    fieldLabel: '容纳人数',
                    allowBlank: false,
                    xtype: 'numberfield',
                    bind: {
                        value: '{rec.capacity}'
                    }
                },
                {
                    fieldLabel: '会议室设备说明',
                    allowBlank: false,
                    bind: {
                        value: '{rec.equipment}'
                    }
                },
                {
                    xtype: 'textareafield',
                    height: 150,
                    fieldLabel: '会议室描述',
                    allowBlank: false,
                    bind: {
                        value: '{rec.description}'
                    }
                }
            ]
        }
    ]
});