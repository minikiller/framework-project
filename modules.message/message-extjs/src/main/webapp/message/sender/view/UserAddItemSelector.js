/**
 * 添加用户组件
 *
 * @author zangyanming <br/>
 *         date:2016-2-29
 * @version 1.0.0
 */
Ext.define('kalix.admin.user.view.UserAddItemSelector', {
    extend: 'Ext.ux.form.ItemSelector',
    xtype: 'userAddItemSelector',
    anchor: '100%',
    displayField: 'name',
    valueField: 'id',
    msgTarget: 'side',
    fromTitle: '可选用户',
    toTitle: '已选用户',
    items: []
});