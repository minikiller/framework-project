/**
 * <module_Name>模块查询控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.controller.<beanName>SearchFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.<pomName>SearchFormController',

    requires: [
        '<extjsPrefix>.store.<beanName>Store'
    ],

    onSearch: function (target, event) {
        var form = target.findParentByType('form').getForm();
        var store = kalix.getApplication().getStore('<pomName>Store');

        store.on('beforeload', function (store, options) {
            Ext.apply(store.proxy.extraParams, form.getFieldValues());
        });
        store.load();
    }
});