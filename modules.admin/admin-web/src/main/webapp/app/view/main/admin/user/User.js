/**
 * 用户组件
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.admin.user.User', {
    extend: 'Ext.panel.Panel',
    items: [],
    constructor: function () {
        this.id = "tab_user";
        var pageSize = 10;

        var dataStore = Ext.create("AppFrame.view.main.admin.user.UserStore", {
            pageSize: pageSize
        });

        var dataGrid = Ext.create('Ext.grid.Panel', {
            id: "userDataGrid",
            store: dataStore,
            autoLoad :true,
            stripeRows: true,
            manageHeight: true,
            selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
            columns: [
                {text: '编号', dataIndex: 'id'},
                {text: '用户名', dataIndex: 'loginName'},
                {text: '姓名', dataIndex: 'name'},
                {text: '邮箱', dataIndex: 'email'},
                {text: '电话', dataIndex: 'phone'},
                {text: '手机', dataIndex: 'mobile'},
                {text: '创建人', dataIndex: 'createBy'},
                { text: '创建日期', dataIndex: 'creationDate',renderer:function(value){
                    var createDate=new Date(value);
                    return createDate.format("yyyy-MM-dd hh:mm:ss");
                }},
                {text: '更新人', dataIndex: 'updateBy'},
                { text: '更新日期', dataIndex: 'updateDate',renderer:function(value){
                    var updateDate=new Date(value);
                    return updateDate.format("yyyy-MM-dd hh:mm:ss");
                }},
                {text: '最后登陆IP', dataIndex: 'loginIp'},
                { text: '登陆日期', dataIndex: 'loginDate',renderer:function(value){
                    var loginDate=new Date(value);
                    return loginDate.format("yyyy-MM-dd hh:mm:ss");
                }},
                { text: '用户状态', dataIndex: 'available',renderer:function(value){
                    if(value!=null&&value=="1"){
                        return "启用";
                    }
                    return "停用";
                }},
                {
                    header: '操作',
                    xtype: "actioncolumn",
                    items: [{
                        icon: "resources/images/pencil.png",
                        handler: function (grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            var editFormPanel = new Ext.FormPanel({
                                labelAlign: 'center',
                                labelWidth: 75,
                                autoWidth: true,
                                autoHeight: true,
                                url: '/userUpdateServlet',
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
                                        text: '保存', type: 'submit', handler: function () {
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
                                    }
                                    },
                                    {
                                        text: '重置', handler: function () {
                                        this.up('form').getForm().reset();
                                    }
                                    }
                                ]
                            });

                            var win = new Ext.Window({
                                width: 510,
                                height: 350,
                                border: false,
                                modal: true,
                                title: "编辑用户",
                                items: [editFormPanel]
                            });

                            win.show();
                        }
                    }, {
                        icon: "resources/images/cancel.png",
                        handler: function (grid, rowIndex, colIndex) {
                            var rec = grid.getStore().getAt(rowIndex);
                            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                                if (button == "yes") {
                                    Ext.Ajax.request({ //初始化选项卡
                                        url: "/userDeleteServlet?id=" + rec.id,
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
                        }

                    }]
                }
            ],
            tbar: [
                {
                    text: '新增', icon: 'resources/images/group_add.png', handler: function () {

                    var addFormPanel = new Ext.FormPanel({
                        labelAlign: 'center',
                        labelWidth: 75,
                        autoWidth: true,
                        autoHeight: true,
                        url: '/camel/rest/user',
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
                                text: '保存', type: 'submit', handler: function () {
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
                                            Ext.Msg.alert('Success', action.result.msg);
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
                            }
                            },
                            {
                                text: '重置', handler: function () {
                                this.up('form').getForm().reset();
                            }
                            }
                        ]
                    });


                    var win = new Ext.Window({
                        width: 510,
                        height: 350,
                        border: false,
                        modal: true,
                        title: "新增用户",
                        items: [addFormPanel]
                    });

                    win.show();
                }
                }, "-",
                {
                    text: '批量删除', icon: 'resources/images/group_delete.png', handler: function () {
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
                }
                }, "-"],
            bbar: [{
                xtype: 'pagingtoolbar',
                border: false,
                store: dataStore,
                displayMsg: '本页显示 {0} - {1} 条，共计 {2} 条',
                emptyMsg: "没有数据",
                beforePageText: "当前页",
                afterPageText: "共{0}页",
                displayInfo: true
            }]
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