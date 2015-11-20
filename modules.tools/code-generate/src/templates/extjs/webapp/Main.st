/**
 * <module_Name>首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        '<extjsPrefix>.view.<beanName>Grid',
        '<extjsPrefix>.view.<beanName>SearchForm',
        '<extjsPrefix>.viewModel.<beanName>ViewModel'
    ],
    storeId: '<pomName>Store',
    viewModel: '<pomName>ViewModel',
    items: [
        {
            title: '<module_Name>查询',
            iconCls: 'x-fa fa-search',
            xtype: '<pomName>SearchForm'
        }, {
            xtype: '<pomName>GridPanel',
            id: '<pomName>GridPanel',
            title: '<module_Name>列表',
            iconCls: 'x-fa fa-search',
            margin: 10
        }
    ]
});
