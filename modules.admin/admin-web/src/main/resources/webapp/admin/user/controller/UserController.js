/**
 * 用户模块控制器
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.controller.UserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.userController',
    /**
     * 初始化面板.
     * @returns {Ext.panel.Panel}
     */
    onInitPanel:function(){

        var panel = Ext.create("Ext.panel.Panel", {
            border: false,
            autoScroll: true,
            height:600,
            items: [this.onInitSearchPanel(), this.onInitDataGrid()]
        })

        return panel;
    },
    /**
     * 初始化查询面板.
     * @returns {Ext.panel.Panel}
     */
    onInitSearchPanel:function(){
        var formPanelRow1 = {
            border: false,
            layout: 'column',
            items: [{
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '登录名',
                    id: "usernameSearchId",
                    name: 'username'
                }]
            }, {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '姓名',
                    id: "nameSearchId",
                    name: 'name'
                }]
            }, {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '邮箱',
                    id: "emailSearchId",
                    name: 'email'
                }]
            }, {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '电话',
                    id: "phoneSearchId",
                    name: 'phone'
                }]
            }]
        };

        var formPanelRow2 = {
            border: false,
            layout: 'column',
            items: [ {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '手机号',
                    id: "mobileSearchId",
                    name: 'mobile'
                }]
            },
                {
                    columnWidth: .2,
                    border: false,
                    layout: 'form',
                    items: [{
                        xtype: 'combobox',
                        fieldLabel: '状态',
                        editable:false,
                        id: "statusSearchId",
                        name: 'status',
                        value:'-1',
                        store: [
                            ['-1', '全部'],
                            ['1', '启用'],
                            ['0', '停用']
                        ]
                    }]
                }]
        };

        //form
        var formPanel =Ext.create('Ext.form.FormPanel',{
            border: false,
            layout: 'form',
            labelWidth: 65,
            labelAlign: 'right',
            items: [formPanelRow1,formPanelRow2],
            buttonAlign: 'center',
            buttons: [{
                text: '查询',
                handler: function () {
                    var username = Ext.getCmp("username").getValue();
                    var name = Ext.getCmp("name").getValue();
                    var sex = Ext.getCmp("sex").getValue();
                    var status = Ext.getCmp("status").getValue();
                    var grid = Ext.getCmp("userDataGrid");

                    /*var user = Ext.create('Kalix.view.main.user.UserModel', {start:0, limit:5,user:{name:'1'}});
                     user.save(); //PUT /users
                     Ext.Msg.alert('Confirm', '发送POST请求');*/

                    var _store = Ext.create('Ext.data.Store', {
                        model: 'Kalix.view.main.user.UserModel'
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

        return searchPanel;
    },
    /**
     * 初始化数据表格.
     * @returns {Ext.panel.Panel}
     */
    onInitDataGrid:function(){
        var userStore=Ext.create("Kalix.admin.user.store.UserStore",{
            pageSize:this.getViewModel().get("pageSize"),
            proxy: {
                type: "ajax",
                url:this.getViewModel().get("list"),
                reader: {
                    type: "json",
                    root: "data",
                    totalProperty: 'totalCount'
                }
            }
        });
        var dataGird= {
            xtype:'userGrid',
            store:userStore,
            bbar: [{
                xtype: 'pagingToolBarComponent',
                store:userStore
            }]
        };

        return dataGird;
    }
});