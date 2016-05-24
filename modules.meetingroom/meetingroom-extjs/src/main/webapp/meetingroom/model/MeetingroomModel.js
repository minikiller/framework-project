/**
 * 会议室模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.app.meetingroom.model.MeetingroomModel', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
        {
            name: 'name',
            type: 'string',
            validators: [{type: 'presence'}]
        }, {
            name: 'address',
            type: 'string',
            validators: [{type: 'presence'}]
        }, {
            name: 'capacity',
            type: 'int',
            defaultValue: 0
        }, {
            name: 'equipment',
            type: 'string'
        }, {
            name: 'description',
            type: 'string'
        }
    ]
});
