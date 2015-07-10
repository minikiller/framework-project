/**
 * 用户组件
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.admin.user.view.User', {
    extend: 'Ext.panel.Panel',
    items: [],
    constructor: function () {
        this.id = "tab_user";
        var pageSize = 10;

        var dataStore = Ext.create("AppFrame.view.admin.user.store.UserStore", {
            pageSize: pageSize
        });

        var dataGrid = Ext.create('AppFrame.view.admin.user.view.UserGrid', {
            id: "userDataGrid",
            store: dataStore
        });

        var formPanelRow1 = {
            border: false,
            layout: 'column',
            items: [{
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    id: "username",
                    fieldLabel: '用户名',
                    name: 'username'
                }]
            }, {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '姓名',
                    id: "name",
                    name: 'name'
                }]
            },  {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'combobox',
                    fieldLabel: '状态',
                    id: "status",
                    name: 'status',
                    store: [
                        ['1', '启用'],
                        ['0', '停用']
                    ]
                }]
            }]
        };



        //form
        var formPanel = new Ext.form.FormPanel({
            border: false,
            layout: 'form',
            labelWidth: 65,
            labelAlign: 'right',
            items: [formPanelRow1],
            buttonAlign: 'center',
            buttons: [{
                text: '查询',
                handler: function () {
                    var username = Ext.getCmp("username").getValue();
                    var name = Ext.getCmp("name").getValue();
                    var sex = Ext.getCmp("sex").getValue();
                    var status = Ext.getCmp("status").getValue();
                    var grid = Ext.getCmp("userDataGrid");

                    /*var user = Ext.create('AppFrame.view.main.user.UserModel', {start:0, limit:5,user:{name:'1'}});
                     user.save(); //PUT /users
                     Ext.Msg.alert('Confirm', '发送POST请求');*/

                    var _store = Ext.create('Ext.data.Store', {
                        model: 'AppFrame.view.main.user.UserModel'
                    });

                    _store.load({id: '123'});
                    Ext.Msg.alert('Confirm', '发送GET请求');


                    //store.reload({ params: { start: 0, limit: pageSize,username:username,name:name,sex:sex,status:status} });

                }
            }, {
                text: '重置',
                handler: function () {
                    this.up('form').getForm().reset();
                }
            }]
        });


        var searchPanel = Ext.create("Ext.panel.Panel", {
            title: '条件查询',
            border: false,
            items: [formPanel]
        });

        var panel = Ext.create("Ext.panel.Panel", {
            border: false,
            autoScroll: true,
            items: [searchPanel, dataGrid]
        })

        this.items[0] = panel;

        this.callParent();
    }
});