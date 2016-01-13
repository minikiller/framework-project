/**
 * <module_Name>模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('<extjsPrefix>.model.<beanName>Model', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
    <ModelFields>
    /*{
        name: 'title',
        type: 'string'
    }, {
        name: 'name',
        type: 'string'
    },{
        name: 'content',
        type: 'string'
    }, {
        name: 'publishPeople',
        type: 'string'
    }, {
        name: 'publishDate',
        type: 'date'
    }
    */
    ],
    //todo 在此修改模型验证提示信息
    <Validators>
    /*
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
        name: [{
            type: 'presence',
            message: '名称不能为空!'
        }]
    }
        */

});
