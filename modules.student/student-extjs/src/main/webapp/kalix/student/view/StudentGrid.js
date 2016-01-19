/**
 * 学生表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.student.view.StudentGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.app.student.controller.StudentGridController',
        'kalix.app.student.store.StudentStore',
    ],
    alias: 'widget.studentGrid',
    xtype: 'studentGridPanel',
    controller: {
        type: 'studentGridController',
        storeId: 'studentStore',
        cfgForm: 'kalix.app.student.view.StudentWindow',
        cfgViewForm: 'kalix.app.student.view.StudentViewWindow',
        cfgModel: 'kalix.app.student.model.StudentModel'
    },
    store: {
        type: 'studentStore'
    },

    //todo 在此修改grid显示列
    columns: {
        defaults: {flex: 1,renderer: 'addTooltip'},
        items: [
            {
                xtype: "rownumberer",
                text: "行号",
                width: 50,
                flex: 0,
                align: 'center',
                renderer:this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true,
            },
            	{
            		text:'姓名',
            		dataIndex:'name'
            	},
            	{
            		text:'是否党员',
            		dataIndex:'party'
            	},
            	{
            		text:'性别',
            		dataIndex:'sex'
            	},
            	{
            		text:'出生日期',
            		dataIndex:'birthday',
            		xtype:'datecolumn',
            		format:'Y-m-d'
            	},
            	{
            		text:'年龄',
            		dataIndex:'age'
            	},

            {
                xtype: 'securityGridColumnRUD',
                //todo change permission
                permissions: [
                    'admin:constructModule:studentMenu:view',
                    'admin:constructModule:studentMenu:edit',
                    'admin:constructModule:studentMenu:delete'
                ]
            }
        ]
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                //todo change permission
                permission: 'admin:constructModule:studentMenu:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
