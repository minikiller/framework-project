/**
 * 用户表格控制器
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
     * 打开新增操作.
     * @returns {Ext.panel.Panel}
     */
    onAddUser:function(){
        var addFormPanel = Ext.create('Kalix.admin.user.view.UserAddForm',{
            url: this.getViewModel().get("save")
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
     * 打开编辑操作.
     * @param grid
     * @param rowIndex
     * @param colIndex
     */
    onEditUser:function(grid, rowIndex, colIndex){
        var rec = grid.getStore().getAt(rowIndex);
        var editFormPanel =Ext.create('Kalix.admin.user.view.UserEditForm',{
            url: this.getViewModel().get("update"),
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