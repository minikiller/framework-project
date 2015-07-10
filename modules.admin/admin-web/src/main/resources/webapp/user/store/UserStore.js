/**
 * 用户数据仓库
 *
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('AppFrame.view.admin.user.store.UserStore', {
    extend: 'Ext.data.Store',
    model: 'AppFrame.view.admin.user.model.UserModel',
    autoLoad: true,
    proxy: {
        type: "ajax",
        url: "/camel/rest/user/findAll",
        reader: {
            type: "json",
            root: "data",
            totalProperty: 'totalCount'
        }
    }
});