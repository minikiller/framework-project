/**
 * 学生首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.student.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.app.student.view.StudentGrid',
        'kalix.app.student.view.StudentSearchForm',
        'kalix.app.student.viewModel.StudentViewModel'
    ],
    storeId: 'studentStore',
    viewModel: 'studentViewModel',
    items: [
        {
            title: '学生查询',
            iconCls: 'x-fa fa-search',
            xtype: 'studentSearchForm'
        }, {
            xtype: 'studentGridPanel',
            id: 'studentGridPanel',
            title: '学生列表',
            iconCls: 'x-fa fa-search',
            margin: 10
        }
    ]
});
