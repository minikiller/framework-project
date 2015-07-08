/**
 * 用户编辑表单
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.view.UserEditForm', {
    extend: 'Ext.FormPanel',
    requires: [
        'Kalix.admin.user.controller.UserFormController'
    ],
    alias: 'widget.userEditForm',
    controller: 'userFormController',
    id: "userEditForm",
    xtype: 'userEditForm',
    labelAlign: 'center',
    labelWidth: 75,
    autoWidth: true,
    autoHeight: true,
    bodyStyle: "padding:15px",
    frame: true,
    jsonSubmit: true,
    method:"PUT",
    defaultType: 'textfield',
    buttonAlign: "center",
    buttons: [
        {
            text: '保存', type: 'submit', handler:'onUpdateUser'
        },
        {
            text: '重置', handler:'onResetUser'
        }
    ]
});