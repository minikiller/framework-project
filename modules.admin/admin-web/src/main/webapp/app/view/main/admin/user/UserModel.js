/**
 * 用户模型
 *
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.admin.user.UserModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'loginName', type: 'string'},
        {name: 'password', type: 'string'},
        {name: 'name', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'phone', type: 'string'},
        {name: 'mobile', type: 'string'},
        {name: 'loginIp', type: 'string'},
        {name: 'is_ent_user', type: 'int'},
        {name: 'available', type: 'int'}
    ]
});