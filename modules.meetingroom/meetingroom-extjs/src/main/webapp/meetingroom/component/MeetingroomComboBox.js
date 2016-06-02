/**
 * 会议室选择下拉comboBox
 * @author zangyanming
 */
Ext.define('kalix.app.meetingroom.component.MeetingroomComboBox', {
    extend: 'kalix.view.components.common.BaseComboBox',
    requires: [
        'kalix.app.meetingroom.store.MeetingroomStore'
    ],
    alias: 'widget.meetingroomComboBox',
    xtype: 'meetingroomComboBox',
    valueField: 'id',
    displayField: 'name',
    queryParam: 'name',
    modelField: 'meetingroomId',
    store: {
        type: 'meetingroomStore'
    }
});
