/**
 * <module_Name>查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.view.<beanName>SearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.<pomName>SearchForm',
    xtype: '<pomName>SearchForm',
    storeId: '<pomName>Store',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '名称',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: 'name'
        }]
});
