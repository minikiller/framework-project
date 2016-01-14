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
            /*
        {
            fieldLabel: '名称',
            allowBlank: false,
            bind: {
                activeError: '{validation.name}',
                value: '{rec.name}'
            }
        },
        {
            fieldLabel: '标题',
            allowBlank: false,
            bind: {
                activeError: '{validation.title}',
                value: '{rec.title}'
            }
        }, {
            fieldLabel: '内容',
            allowBlank: false,
            xtype: 'textarea',
            bind: {
                activeError: '{validation.content}',
                value: '{rec.content}'
            }
        },{
            fieldLabel: '发布时间',
            allowBlank: false,
            xtype: 'datefield',
            format: 'Y-m-d',
            bind: {
                value: '{rec.publishDate}'
            }
            }]
        }
    */
    ]
});