/**
 * 用户模型
 *
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.model.UserModel', {
    extend: 'Ext.data.Model',
    fields: ['id', 'loginName', 'password', 'name', 'email', 'phone', 'mobile', 'loginIp', 'is_ent_user', 'available', 'createBy', 'creationDate', 'updateBy', 'updateDate'
    ]
});