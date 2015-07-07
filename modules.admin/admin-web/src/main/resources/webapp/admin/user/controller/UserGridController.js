/**
 *应用组件控制器
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.controller.UserGridController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.userGridController',
    /**
     * 重置操作.
     * @returns {Ext.panel.Panel}
     */
    onResetUser:function(){
        this.up('form').getForm().reset();
    },
    /**
     * 保存操作.
     * @returns {Ext.panel.Panel}
     */
    onSaveUser:function(){
        var form = this.up('form').getForm();
        if (form.isValid()) {
            var confirmPasswordValue = Ext.getCmp("confirmPasswordId").getValue();
            var passwordValue = Ext.getCmp("passwordId").getValue();
            if(confirmPasswordValue!=passwordValue){
                Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, "密码与确认密码必须一致!");
                return;
            }
            form.submit({
                success: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, action.result.msg);
                    var username = Ext.getCmp("username").getValue();
                    var name = Ext.getCmp("name").getValue();
                    var sex = Ext.getCmp("sex").getValue();
                    var status = Ext.getCmp("status").getValue();
                    var grid = Ext.getCmp("userDataGrid");
                    var store = grid.getStore();
                    store.reload({
                        params: {
                            start: 0,
                            limit: pageSize,
                            username: username,
                            name: name,
                            sex: sex,
                            status: status
                        }
                    });
                },
                failure: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, action.result.msg);
                }
            });
        } else {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, "请检查输入项!");
        }
    },
    /**
     * 打开新增操作.
     * @returns {Ext.panel.Panel}
     */
    onAddUser:function(){
        var addFormPanel = Ext.create('Ext.FormPanel',{
            labelAlign: 'center',
            labelWidth: 75,
            autoWidth: true,
            autoHeight: true,
            url: this.getViewModel().get("save"),
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
                    text: '保存', type: 'submit', handler:this.onSaveUser
                },
                {
                    text: '重置', handler:this.onResetUser
                }
            ]
        });


        var win = Ext.create('Ext.Window',{
            width: 510,
            height: 350,
            border: false,
            modal: true,
            title: "新增用户",
            items: [addFormPanel]
        });

        win.show();
    },
    /**
     * 更新操作.
     * @returns {Ext.panel.Panel}
     */
    onUpdateUser:function(){
        var form = this.up('form').getForm();
        if (form.isValid()) {
            form.submit({
                success: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, action.result.msg);
                    //dataStore.loadPage(1);
                },
                failure: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, action.result.msg);
                }
            });
        }
    },
    /**
     * 打开编辑操作.
     * @param grid
     * @param rowIndex
     * @param colIndex
     */
    onEditUser:function(grid, rowIndex, colIndex){
        var rec = grid.getStore().getAt(rowIndex);
        var editFormPanel =Ext.create('Ext.FormPanel',{
            labelAlign: 'center',
            labelWidth: 75,
            autoWidth: true,
            autoHeight: true,
            url: this.getViewModel().get("edit"),
            bodyStyle: "padding:15px",
            frame: true,
            jsonSubmit: true,
            defaultType: 'textfield',
            buttonAlign: "center",
            items: [
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
            ],
            buttons: [
                {
                    text: '保存', type: 'submit', handler:this.onUpdateUser
                },
                {
                    text: '重置', handler: this.onResetUser
                }
            ]
        });

        var win = Ext.create('Ext.Window',{
            width: 510,
            height: 350,
            border: false,
            modal: true,
            title: "编辑用户",
            items: [editFormPanel]
        });

        win.show();
    },
    /**
     * 批量删除操作.
     */
    onDeleteAllUser:function(){
        var selModel = Ext.getCmp("userDataGrid").getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    var rows = selModel.getSelection();
                    var ids = "";
                    for (var i = 0; i < rows.length; i++) {
                        if (rows[i] != null && rows[i].id != null) {
                            ids += rows[i].id;
                            if (i + 1 != rows.length) {
                                ids += "_";
                            }
                        }
                    }
                    Ext.Ajax.request({
                        url: "/userDeleteAllServlet?ids=" + ids,
                        method: "GET",
                        callback: function (options, success, response) {
                            var resp = Ext.JSON.decode(response.responseText);
                            Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, resp.msg);
                            if (resp.success) {
                                var username = Ext.getCmp("username").getValue();
                                var name = Ext.getCmp("name").getValue();
                                var sex = Ext.getCmp("sex").getValue();
                                var status = Ext.getCmp("status").getValue();
                                var grid = Ext.getCmp("userDataGrid");
                                var store = grid.getStore();
                                store.reload({
                                    params: {
                                        start: 0,
                                        limit: pageSize,
                                        username: username,
                                        name: name,
                                        sex: sex,
                                        status: status
                                    }
                                });
                            }
                        }
                    });
                }
            });
        } else {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_ERROR, "请选择要删除的记录！");
        }
    },
    /**
     * 删除单个操作.
     * @param grid
     * @param rowIndex
     * @param colIndex
     */
    onDeleteUser:function(grid, rowIndex, colIndex){
        var rec = grid.getStore().getAt(rowIndex);
        var deleteUrl=this.getViewModel().get("delete");
        Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
            if (button == "yes") {
                Ext.Ajax.request({
                    url: deleteUrl+"?id=" + rec.id,
                    method: 'DELETE',
                    callback: function (options, success, response) {
                        var resp = Ext.JSON.decode(response.responseText);
                        Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, resp.msg);
                        if (resp.success) {
                            var grid = Ext.getCmp("userDataGrid");
                            var store = grid.getStore();
                            store.reload();
                        }
                    }
                });
            }
        });
    }
});