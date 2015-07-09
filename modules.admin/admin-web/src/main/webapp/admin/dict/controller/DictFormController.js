/**
 * 字典表单控制器
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.controller.DictFormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.dictFormController',

    /**
     * 重置操作.
     * @returns {Ext.panel.Panel}
     */
    onAddReset:function(){
        Ext.getCmp("dictAddForm").reset();
    },
    /**
     * 重置操作.
     * @returns {Ext.panel.Panel}
     */
    onEditReset:function(){
        Ext.getCmp("dictEditForm").reset();
    },
    /**
     * 保存操作.
     * @returns {Ext.panel.Panel}
     */
    onSave:function(){
        var form = Ext.getCmp("dictAddForm");
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
                    var grid = Ext.getCmp("dictDataGrid");
                    var store = grid.getStore();
                    store.reload();
                    /*var dictname = Ext.getCmp("dictname").getValue();
                    var name = Ext.getCmp("name").getValue();
                    var sex = Ext.getCmp("sex").getValue();
                    var status = Ext.getCmp("status").getValue();
                    store.reload({
                        params: {
                            start: 0,
                            limit: pageSize,
                            dictname: dictname,
                            name: name,
                            sex: sex,
                            status: status
                        }
                    });*/
                },
                failure: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, action.result.msg);
                }
            });
        }
    },
    /**
     * 更新操作.
     * @returns {Ext.panel.Panel}
     */
    onUpdate:function(){
        var form = Ext.getCmp("dictEditForm");
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
                    var grid = Ext.getCmp("dictDataGrid");
                    var store = grid.getStore();
                    store.reload();
                },
                failure: function (form, action) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, action.result.msg);
                }
            });
        }
    }
});