/**
 * <module_Name>查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.view.<beanName>SearchForm', {
    extend: 'Ext.form.Panel',
    requires: [
        '<extjsPrefix>.controller.<beanName>SearchFormController'
    ],
    alias: 'widget.<pomName>SearchForm',
    xtype: '<pomName>SearchForm',
    controller: '<pomName>SearchFormController',
    bodyPadding: 10,
    layout: 'column',
    margin: 10,
    //todo 在此修改查询条件
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '标题',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: 'title'
        },
        {
            xtype: 'button',
            text: '查询',
            margin: '0 0 0 10',
            handler: 'onSearch',
            glyph: 'xf002@FontAwesome',
        }
    ]
});
