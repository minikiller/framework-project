/**
 * 字典组件
 *
 * @author majian <br/>
 *         date:2015-7-4
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.admin.dict.Dict', {
    extend: 'Ext.panel.Panel',
    items: [],
    constructor: function () {
        this.id = "tab_dict";
        var pageSize = 10;

        var dataStore = Ext.create("AppFrame.view.main.admin.dict.DictStore", {
            pageSize: pageSize
        });

        var dataGrid = Ext.create('Ext.grid.Panel', {
            id: "dictDataGrid",
            store: dataStore,
            autoLoad :true,
            stripeRows: true,
            manageHeight: true,
            selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
            columns: [
                {text: '编号', dataIndex: 'id'},
                {text: '标签名', dataIndex: 'label'},
                {text: '数据值 ', dataIndex: 'value'},
                {text: '类型', dataIndex: 'type'},
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
                                url: '/dictUpdateServlet',
                                bodyStyle: "padding:15px",
                                frame: true,
                                jsonSubmit: true,
                                defaultType: 'textfield',
                                buttonAlign: "center",
                                items: [
                                    {xtype: 'hiddenfield', name: 'id', value: rec.data.id},

                                    {
                                        fieldLabel: '标签名',
                                        id: 'labelId',
                                        name: 'label',
                                        allowBlank: false,
                                        blankText: '标签名不能为空!',
                                        value: rec.data.label
                                    },
                                    {
                                        fieldLabel: '数据值',
                                        id: 'valueId',
                                        name: 'value',
                                        allowBlank: false,
                                        blankText: '数据值不能为空!',
                                        value: rec.data.value
                                    },
                                    {
                                        fieldLabel: '类型',
                                        id: 'typeId',
                                        name: 'type',
                                        allowBlank: false,
                                        blankText: '类型密码不能为空!',
                                        value: rec.data.type
                                    },
                                    {
                                    	xtype     : 'textareafield',  
                                        fieldLabel: '描述',
                                        id: 'descriptionId',
                                        name: 'description',
                                        allowBlank: false,
                                        blankText: '描述不能为空!',
                                        value: rec.data.description
                                    },
                                    {
                                        fieldLabel: '排序',
                                        id: 'sortId',
                                        name: 'sort',
                                        allowBlank: false,
                                        blankText: '排序不能为空!',
                                        value: rec.data.sort
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
                                title: "编辑字典",
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
                                        url: "/camel/rest/dict?id=" + rec.id,
                                        method: 'DELETE',
                                        callback: function (options, success, response) {
                                            var resp = Ext.JSON.decode(response.responseText);
                                            Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, resp.msg);
                                            if (resp.success) {
                                                var dictname = Ext.getCmp("dictname").getValue();
                                                var name = Ext.getCmp("name").getValue();
                                                var sex = Ext.getCmp("sex").getValue();
                                                var status = Ext.getCmp("status").getValue();
                                                var grid = Ext.getCmp("dictDataGrid");
                                                var store = grid.getStore();
                                                store.reload({
                                                    params: {
                                                        start: 0,
                                                        limit: pageSize,
                                                        dictname: dictname,
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
                        url: '/camel/rest/dict',
                        jsonSubmit: true,
                        bodyStyle: "padding:15px",
                        frame: true,
                        buttonAlign: "center",
                        defaultType: 'textfield',
                        items: [
                            
                                    {
                                        fieldLabel: '标签名',
                                        id: 'labelId',
                                        name: 'label',
                                        allowBlank: false,
                                        blankText: '标签名不能为空!'
                                    },
                                    {
                                        fieldLabel: '数据值',
                                        id: 'valueId',
                                        name: 'value',
                                        allowBlank: false,
                                        blankText: '数据值不能为空!'
                                    },
                                    {
                                        fieldLabel: '类型',
                                        id: 'typeId',
                                        name: 'type',
                                        allowBlank: false,
                                        blankText: '类型密码不能为空!'
                                    },
                                    {
                                    	xtype     : 'textareafield',  
                                        fieldLabel: '描述',
                                        id: 'descriptionId',
                                        name: 'description',
                                        allowBlank: false,
                                        blankText: '描述不能为空!'
                                    },
                                    {
                                        fieldLabel: '排序',
                                        id: 'sortId',
                                        name: 'sort',
                                        allowBlank: false,
                                        blankText: '排序不能为空!'
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
                                            var dictname = Ext.getCmp("dictname").getValue();
                                            var name = Ext.getCmp("name").getValue();
                                            var sex = Ext.getCmp("sex").getValue();
                                            var status = Ext.getCmp("status").getValue();
                                            var grid = Ext.getCmp("dictDataGrid");
                                            var store = grid.getStore();
                                            store.reload({
                                                params: {
                                                    start: 0,
                                                    limit: pageSize,
                                                    dictname: dictname,
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
                        title: "新增字典",
                        items: [addFormPanel]
                    });

                    win.show();
                }
                }, "-",
                {
                    text: '批量删除', icon: 'resources/images/group_delete.png', handler: function () {
                    var selModel = Ext.getCmp("dictDataGrid").getSelectionModel();
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
                                    url: "/dictDeleteAllServlet?ids=" + ids,
                                    method: "GET",
                                    callback: function (options, success, response) {
                                        var resp = Ext.JSON.decode(response.responseText);
                                        Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, resp.msg);
                                        if (resp.success) {
                                            var dictname = Ext.getCmp("dictname").getValue();
                                            var name = Ext.getCmp("name").getValue();
                                            var sex = Ext.getCmp("sex").getValue();
                                            var status = Ext.getCmp("status").getValue();
                                            var grid = Ext.getCmp("dictDataGrid");
                                            var store = grid.getStore();
                                            store.reload({
                                                params: {
                                                    start: 0,
                                                    limit: pageSize,
                                                    dictname: dictname,
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
                    id: "dictname",
                    fieldLabel: '字典名',
                    name: 'dictname'
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
                    var dictname = Ext.getCmp("dictname").getValue();
                    var name = Ext.getCmp("name").getValue();
                    var sex = Ext.getCmp("sex").getValue();
                    var status = Ext.getCmp("status").getValue();
                    var grid = Ext.getCmp("dictDataGrid");

                    /*var dict = Ext.create('AppFrame.view.main.dict.dictModel', {start:0, limit:5,dict:{name:'1'}});
                     dict.save(); //PUT /dicts
                     Ext.Msg.alert('Confirm', '发送POST请求');*/

                    var _store = Ext.create('Ext.data.Store', {
                        model: 'AppFrame.view.main.dict.dictModel'
                    });

                    _store.load({id: '123'});
                    Ext.Msg.alert('Confirm', '发送GET请求');


                    //store.reload({ params: { start: 0, limit: pageSize,dictname:dictname,name:name,sex:sex,status:status} });

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