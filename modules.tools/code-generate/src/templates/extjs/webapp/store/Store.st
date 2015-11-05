/**
 * <module_Name>数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.store.<beanName>Store', {
    extend: 'Ext.data.Store',
    model: '<extjsPrefix>.model.<beanName>Model',
    alias: 'store.<pomName>Store',
    xtype: '<pomName>Store',
    storeId: "<pomName>Store",
    autoLoad: true,
    pageSize: 10,
    proxy: {
        type: "ajax",
        url: '/kalix/camel/rest/<pomName>s/list',
        paramsAsJson: true,
        actionMethods: {
            create: 'POST',
            read: 'POST',
            update: 'POST',
            destroy: 'POST'
        },
        reader: {
            type: "json",
            rootProperty: "data",
            totalProperty: 'totalCount'
        }
    }
});