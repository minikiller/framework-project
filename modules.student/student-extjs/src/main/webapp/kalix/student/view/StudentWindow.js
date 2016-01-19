/**
 * 学生新增和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.student.view.StudentWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.app.student.viewModel.StudentViewModel',
        'kalix.controller.BaseWindowController',
        'kalix.admin.user.store.UserStore'
    ],
    alias: 'widget.studentWindow',
    viewModel: 'studentViewModel',
    controller: {
        type: 'baseWindowController',
        storeId: 'studentStore'
    },
    xtype: "studentWindow",
    width: 400,
    //todo 在此修改表单
    items: [

        {
        xtype: 'baseForm',
        items: [
            	{
            		fieldLabel:'姓名',
            		allowBlank:false,
            		bind: {
            			value: '{rec.name}'
            		}
            	},
            	{
            		fieldLabel:'是否党员',
            		allowBlank:false,
            		bind: {
            			value: '{rec.party}'
            		}
            	},
            	{
            		fieldLabel:'性别',
            		allowBlank:false,
            		bind: {
            			value: '{rec.sex}'
            		}
            	},
            	{
            		fieldLabel:'出生日期',
            		allowBlank:false,
					xtype: 'datefield',
					editable: false,
					format: 'Y-m-d',
            		bind: {
            			value: '{rec.birthday}'
            		}
            	},
            	{
            		fieldLabel:'年龄',
            		allowBlank:false,
            		bind: {
            			value: '{rec.age}'
            		}
            	}
        ]
        }
    ]
});