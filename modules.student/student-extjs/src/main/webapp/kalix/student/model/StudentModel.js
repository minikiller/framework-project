/**
 * 学生模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.app.student.model.StudentModel', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
    	{
    	name:'name',
    	type: 'string'
    	},	{
    	name:'party',
    	type: 'boolean'
    	},	{
    	name:'sex',
    	type: 'string'
    	},	{
    	name:'birthday',
    	type: 'date'
    	},	{
    	name:'age',
    	type: 'int'
    	}
    ],
    //todo 在此修改模型验证提示信息
    	validators: {
    		name:[{
    			type:'presence',
    			message:'姓名不能为空'
    		}],
    		age:[{
    			type:'presence',
    			message:'年龄介于1与120之间'
    		}]
    	}
});
