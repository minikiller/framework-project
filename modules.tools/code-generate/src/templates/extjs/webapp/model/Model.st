/**
 * <module_Name>模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('<extjsPrefix>.model.<beanName>Model', {
    extend: 'Ext.data.Model',

    idProperty: '_id',
    //todo 在此修改模型定义
    fields: [{
        name: 'id',
        type: 'string'
    }, {
        name: 'title',
        type: 'string'
    }, {
        name: 'content',
        type: 'string'
    }, {
        name: 'publishPeople',
        type: 'string'
    }, {
        name: 'publishDate',
        type: 'int'
    }, {
        name: 'version',
        type: 'int'
    }
    ],
    //todo 在此修改模型验证提示信息
    validators: {
        title: [
            {
                type: 'length',
                max: '20',
                min: '4',
                bothMessage: '长度不能小于4个字符，不能超过20个字符！'
        }
        ],
        content: [{
            type: 'presence',
            message: '内容不能为空!'
        }
        ],
    },

    //需要提交给服务端的模型 key
    serverKeys: [
        'id',
        'title',
        'content',
        'version'
    ],

    //需要提交给服务端的 JSON 数据
    toServerJSON: function () {
        return Ext.JSON.encode(_.pick(this.getData(), this.serverKeys));
    }
});
