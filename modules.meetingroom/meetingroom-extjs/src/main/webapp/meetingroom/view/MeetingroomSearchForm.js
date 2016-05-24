/**
 * 会议室查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.meetingroom.view.MeetingroomSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.meetingroomSearchForm',
    xtype: 'meetingroomSearchForm',
    storeId: 'meetingroomStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '会议室名称',
            labelAlign: 'right',
            labelWidth: 80,
            width: 200,
            name: 'name'
        },
        {
            xtype: 'textfield',
            fieldLabel: '会议室地址',
            labelAlign: 'right',
            labelWidth: 80,
            width: 200,
            name: 'address'
        },
        {
            xtype: 'numberfield',
            fieldLabel: '容纳人数',
            labelAlign: 'right',
            labelWidth: 70,
            width: 200,
            name: 'capacity'
        }
    ]
});
