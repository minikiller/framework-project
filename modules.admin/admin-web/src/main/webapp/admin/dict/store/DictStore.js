/**
 * 字典数据仓库
 *
 * @author majian <br/>
 *         date:2015-7-9
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.store.DictStore', {
    extend: 'Ext.data.Store',
    model: 'Kalix.admin.dict.model.DictModel',
    alias: 'store.dictStore',
    xtype:'dictStore',
    storeId: "dictStore",
    autoLoad: true,
    pageSize:10,
    proxy: {
        type: "ajax",
        url:'/camel/rest/dicts',
        reader: {
            type: "json",
            root: "data",
            totalProperty: 'totalCount'
        }
    }
});