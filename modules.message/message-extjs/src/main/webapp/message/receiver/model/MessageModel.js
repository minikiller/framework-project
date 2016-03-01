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
            name: 'senderId',
            type: 'string'
        }, {
            name: 'receiverId',
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
            name: 'read',
            type: 'boolean',
            defaultValue: false
        }, {
            name: 'state',
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
        receiverId: [{
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
