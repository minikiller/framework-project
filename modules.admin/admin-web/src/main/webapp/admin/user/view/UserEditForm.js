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
    ],
    constructor: function (url,rec) {
        this.url=url;
        this.items=[
            {xtype: 'hiddenfield', name: 'id', value: rec.data.id},

            {
                fieldLabel: '登录名',
                id: 'loginNameId',
                name: 'loginName',
                allowBlank: false,
                blankText: '登录名不能为空!',
                value: rec.data.loginName
            },
            {
                fieldLabel: '姓名',
                id: 'nameId',
                name: 'name',
                allowBlank: false,
                blankText: '姓名不能为空!',
                value: rec.data.name
            },
            {
                inputType: 'password',
                fieldLabel: '密码',
                id: 'passwordId',
                name: 'password',
                allowBlank: false,
                blankText: '密码不能为空!',
                value: rec.data.password
            },
            {
                inputType: 'password',
                fieldLabel: '确认密码',
                isFormField:false,
                id: 'confirmPasswordId',
                allowBlank: false,
                blankText: '确认密码不能为空!',
                value: rec.data.password
            },
            {
                fieldLabel: '邮箱',
                id: 'emailId',
                name: 'email',
                allowBlank: false,
                blankText: '邮箱不能为空!',
                value: rec.data.email
            },
            {
                fieldLabel: '电话号',
                id: 'phoneId',
                name: 'phone',
                allowBlank: false,
                blankText: '电话号不能为空!',
                value: rec.data.phone
            },
            {
                fieldLabel: '手机号',
                id: 'mobileId',
                name: 'mobile',
                allowBlank: false,
                blankText: '手机号不能为空!',
                value: rec.data.mobile
            },
            {
                xtype: 'combobox',
                fieldLabel: '状态',
                name: 'available',
                editable:false,
                value: rec.data.available,
                store: [
                    ['1', '启用'],
                    ['0', '停用']
                ]
            }
        ]
        this.callParent();
    }
});