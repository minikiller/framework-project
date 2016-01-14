/**
 * <module_Name>新增和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.view.<beanName>Window', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        '<extjsPrefix>.viewModel.<beanName>ViewModel',
        'kalix.controller.BaseWindowController',
        'kalix.admin.user.store.UserStore'
    ],
    alias: 'widget.<pomName>Window',
    viewModel: '<pomName>ViewModel',
    controller: {
        type: 'baseWindowController',
        storeId: '<pomName>Store'
    },
    xtype: "<pomName>Window",
    width: 400,
    //todo 在此修改表单
    items: [

        {
        xtype: 'baseForm',
        items: [
            <WindowItems>
        ]
        }
    ]
});