/**
 * 消息模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.message.receiver.model.MessageModel', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
        {
            name: 'sender',
            type: 'string'
        }, {
            name: 'receiver',
            type: 'string'
        }, {
            name: 'category',
            type: 'string',
            defaultValue: '1'
        }, {
            name: 'title',
            type: 'string'
        }, {
            name: 'content',
            type: 'string'
        }, {
            name: 'send_timestamp',
            type: 'date',
            dateFormat: 'Y-m-d H:i:s'
        }, {
            name: 'read',
            type: 'int',
            defaultValue: 1
        }, {
            name: 'message_state',
            type: 'int',
            defaultValue: 1
        }, {
            name: 'sign',
            type: 'int',
            defaultValue: 1
        }
    ],
    //todo 在此修改模型验证提示信息
    validators: {
        sender: [{
            type: 'presence',
            message: '发送者不能为空'
        }],
        receiver: [{
            type: 'presence',
            message: '接收者不能为空'
        }],
        category: [{
            type: 'presence',
            message: '消息类别不能为空'
        }],
        title: [{
            type: 'presence',
            message: '消息主题不能为空'
        }],
        content: [{
            type: 'presence',
            message: '消息内容不能为空'
        }]
    }
});
