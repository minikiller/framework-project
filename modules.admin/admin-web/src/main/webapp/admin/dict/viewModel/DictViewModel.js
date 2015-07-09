/**
 * 字典视图模型
 *
 * @author majian <br/>
 *         date:2015-7-9
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.viewModel.DictViewModel', {
    extend: 'Ext.app.ViewModel',
    requires: [
        'Kalix.admin.dict.store.DictStore'
    ],
    alias: 'viewmodel.dictViewModel',
    data: {
        addTitle:'新增字典',
        editTitle:'编辑字典',
        url: '/camel/rest/dicts'
    },
    stores: {
        dictStore:{
            type:'dictStore'
        }
    }
});