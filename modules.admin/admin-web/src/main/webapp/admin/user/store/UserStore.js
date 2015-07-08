/**
 * 用户数据仓库
 *
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.store.UserStore', {
    extend: 'Ext.data.Store',
    requires: [
        'Kalix.view.components.common.PagingToolBar',
        'Kalix.admin.user.viewModel.UserViewModel'
    ],
    model: 'Kalix.admin.user.model.UserModel',
    alias: 'store.userStore',
    xtype:'userStore',
    viewModel: {
        type: 'userViewModel'
    },
    autoLoad: true
});