/**
 * 会议室数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.meetingroom.store.MeetingroomStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.app.meetingroom.model.MeetingroomModel',
    alias: 'store.meetingroomStore',
    xtype: 'meetingroomStore',
    storeId: "meetingroomStore",
    proxyUrl: '/kalix/camel/rest/meetingrooms'
});