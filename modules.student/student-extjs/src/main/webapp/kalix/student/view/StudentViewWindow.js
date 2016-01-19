/**
 * 学生查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.app.student.view.StudentViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
        requires: [
            'kalix.app.student.viewModel.StudentViewModel',
            'kalix.admin.user.store.UserStore'
        ],
        alias: 'widget.studentViewWindow',
        viewModel: 'studentViewModel',
        xtype: "studentViewWindow",
        width: 400,
    //todo 在此修改查看字段
    items: [{
            defaults: {readOnly: true},
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
                		xtype:'datefield',
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