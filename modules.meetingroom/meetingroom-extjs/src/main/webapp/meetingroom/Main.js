/**
 * 会议室首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.meetingroom.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.app.meetingroom.view.MeetingroomGrid',
        'kalix.app.meetingroom.view.MeetingroomSearchForm',
        'kalix.app.meetingroom.viewModel.MeetingroomViewModel'
    ],
    storeId: 'meetingroomStore',
    viewModel: 'meetingroomViewModel',
    items: [
        {
            title: '会议室查询',
            iconCls: 'x-fa fa-search',
            xtype: 'meetingroomSearchForm'
        }, {
            xtype: 'meetingroomGridPanel',
            id: 'meetingroomGridPanel',
            title: '会议室列表',
            iconCls: 'x-fa fa-search',
            margin: 10
        }
    ]
});
