/**
 * 用户新增表单
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.view.UserAddForm', {
    extend: 'Ext.FormPanel',
    requires: [
        'Kalix.admin.user.controller.UserFormController'
    ],
    alias: 'widget.userAddForm',
    controller: 'userFormController',
    id: "userAddForm",
    xtype: "userAddForm",
    labelAlign: 'center',
    labelWidth: 75,
    autoWidth: true,
    autoHeight: true,
    jsonSubmit: true,
    bodyStyle: "padding:15px",
    frame: true,
    buttonAlign: "center",
    defaultType: 'textfield',
    items: [
        {
            fieldLabel: '登录名',
            id: 'loginNameId',
            name: 'loginName',
            allowBlank: false,
            blankText: '登录名不能为空!'
        },
        {
            fieldLabel: '姓名',
            id: 'nameId',
            name: 'name',
            allowBlank: false,
            blankText: '姓名不能为空!'
        },
        {
            inputType: 'password',
            fieldLabel: '密码',
            id: 'passwordId',
            name: 'password',
            allowBlank: false,
            blankText: '密码不能为空!'
        },
        {
            inputType: 'password',
            fieldLabel: '确认密码',
            isFormField:false,
            id: 'confirmPasswordId',
            allowBlank: false,
            blankText: '确认密码不能为空!'
        },
        {
            fieldLabel: '邮箱',
            id: 'emailId',
            name: 'email',
            allowBlank: false,
            blankText: '邮箱不能为空!'
        },
        {
            fieldLabel: '电话号',
            id: 'phoneId',
            name: 'phone',
            allowBlank: false,
            blankText: '电话号不能为空!'
        },
        {
            fieldLabel: '手机号',
            id: 'mobileId',
            name: 'mobile',
            allowBlank: false,
            blankText: '手机号不能为空!'
        },
        {
            xtype: 'combobox',
            fieldLabel: '状态',
            name: 'available',
            editable:false,
            value:'1',
            store: [
                ['1', '启用'],
                ['0', '停用']
            ]
        }
    ],
    buttons: [
        {
            text: '保存', type: 'submit', handler:'onSaveUser'
        },
        {
            text: '重置', handler:'onResetUser'
        }
    ],
    constructor: function (url) {
        this.url=url;
        this.callParent();
    }
});