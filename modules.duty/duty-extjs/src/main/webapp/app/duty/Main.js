/**
 * 职务首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.duty.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.app.duty.view.DutyGrid',
        'kalix.app.duty.view.DutySearchForm',
        'kalix.app.duty.viewModel.DutyViewModel'
    ],
    storeId: 'dutyStore',
    viewModel: 'dutyViewModel',
    items: [
        {
            title: '职务查询',
            iconCls: 'x-fa fa-search',
            xtype: 'dutySearchForm'
        }, {
            xtype: 'dutyGridPanel',
            id: 'dutyGridPanel',
            title: '职务列表',
            iconCls: 'x-fa fa-search',
            margin: 10
        }
    ]
});
