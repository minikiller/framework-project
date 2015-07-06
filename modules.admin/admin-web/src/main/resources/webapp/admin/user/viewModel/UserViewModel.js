/**
 * 用户视图模型
 *
 * @author majian <br/>
 *         date:2015-7-6
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.viewModel.UserViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.userViewModel',
    data: {
        id:'tab_user',
        pageSize:10,
        list: '/camel/rest/user/findAll',
        save: '/camel/rest/user',
        update: '/camel/rest/user'
    }
});