/**
 * 字典数据仓库
 *
 * @author majian <br/>
 *         date:2015-7-4
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.admin.dict.DictStore', {
    extend: 'Ext.data.Store',
    model: 'AppFrame.view.main.admin.dict.DictModel',
    autoLoad: true,
    proxy: {
        type: "ajax",
        url: "/camel/rest/dict/findAll",
        reader: {
            type: "json",
            root: "data",
            totalProperty: 'totalCount'
        }
    }
});