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
        var addFormPanel =Ext.create('Kalix.admin.user.view.UserAddForm',this.getViewModel().get("update"));

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
        var editFormPanel =Ext.create('Kalix.admin.user.view.UserEditForm',this.getViewModel().get("update"),rec);

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