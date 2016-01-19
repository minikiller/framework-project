/**
 * 学生查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.student.view.StudentSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.studentSearchForm',
    xtype: 'studentSearchForm',
    storeId: 'studentStore',
    items: [
    	{
    		xtype:'textfield',
    		fieldLabel:'姓名',
    		labelAlign:'right',
    		labelWidth:60,
    		width:200,
    		name:'name'
    	},
    	{
    		xtype:'textfield',
    		fieldLabel:'是否党员',
    		labelAlign:'right',
    		labelWidth:60,
    		width:200,
    		name:'party'
    	},
    	{
    		xtype:'textfield',
    		fieldLabel:'性别',
    		labelAlign:'right',
    		labelWidth:60,
    		width:200,
    		name:'sex'
    	},
    	{
    		xtype:'textfield',
    		fieldLabel:'出生日期',
    		labelAlign:'right',
    		labelWidth:60,
    		width:200,
    		name:'birthday'
    	},
    	{
    		xtype:'textfield',
    		fieldLabel:'年龄',
    		labelAlign:'right',
    		labelWidth:60,
    		width:200,
    		name:'age'
    	}
    ]

});
