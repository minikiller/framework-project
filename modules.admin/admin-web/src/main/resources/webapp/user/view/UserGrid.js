/**
 * �û�ģ��
 *
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('AppFrame.view.admin.user.view.UserGrid', {
    extend: 'Ext.grid.Panel',
    autoLoad :true,
    stripeRows: true,
    manageHeight: true,
    selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
    columns: [
        {text: '���', dataIndex: 'id'},
        {text: '�û���', dataIndex: 'loginName'},
        {text: '����', dataIndex: 'name'},
        {text: '����', dataIndex: 'email'},
        {text: '�绰', dataIndex: 'phone'},
        {text: '�ֻ�', dataIndex: 'mobile'},
        {text: '������', dataIndex: 'createBy'},
        { text: '��������', dataIndex: 'creationDate',renderer:function(value){
            var createDate=new Date(value);
            return createDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        {text: '������', dataIndex: 'updateBy'},
        { text: '��������', dataIndex: 'updateDate',renderer:function(value){
            var updateDate=new Date(value);
            return updateDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        {text: '����½IP', dataIndex: 'loginIp'},
        { text: '��½����', dataIndex: 'loginDate',renderer:function(value){
            var loginDate=new Date(value);
            return loginDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        { text: '�û�״̬', dataIndex: 'available',renderer:function(value){
            if(value!=null&&value=="1"){
                return "����";
            }
            return "ͣ��";
        }},
        {
            header: '����',
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
                                fieldLabel: '��¼��',
                                id: 'loginNameId',
                                name: 'loginName',
                                allowBlank: false,
                                blankText: '��¼������Ϊ��!',
                                value: rec.data.loginName
                            },
                            {
                                fieldLabel: '����',
                                id: 'nameId',
                                name: 'name',
                                allowBlank: false,
                                blankText: '��������Ϊ��!',
                                value: rec.data.name
                            },
                            {
                                inputType: 'password',
                                fieldLabel: '����',
                                id: 'passwordId',
                                name: 'password',
                                allowBlank: false,
                                blankText: '���벻��Ϊ��!',
                                value: rec.data.password
                            },
                            {
                                inputType: 'password',
                                fieldLabel: 'ȷ������',
                                isFormField:false,
                                id: 'confirmPasswordId',
                                allowBlank: false,
                                blankText: 'ȷ�����벻��Ϊ��!',
                                value: rec.data.password
                            },
                            {
                                fieldLabel: '����',
                                id: 'emailId',
                                name: 'email',
                                allowBlank: false,
                                blankText: '���䲻��Ϊ��!',
                                value: rec.data.email
                            },
                            {
                                fieldLabel: '�绰��',
                                id: 'phoneId',
                                name: 'phone',
                                allowBlank: false,
                                blankText: '�绰�Ų���Ϊ��!',
                                value: rec.data.phone
                            },
                            {
                                fieldLabel: '�ֻ���',
                                id: 'mobileId',
                                name: 'mobile',
                                allowBlank: false,
                                blankText: '�ֻ��Ų���Ϊ��!',
                                value: rec.data.mobile
                            },
                            {
                                xtype: 'combobox',
                                fieldLabel: '״̬',
                                name: 'available',
                                editable:false,
                                value: rec.data.available,
                                store: [
                                    ['1', '����'],
                                    ['0', 'ͣ��']
                                ]
                            }
                        ],
                        buttons: [
                            {
                                text: '����', type: 'submit', handler: function () {
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
                                text: '����', handler: function () {
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
                        title: "�༭�û�",
                        items: [editFormPanel]
                    });

                    win.show();
                }
            }, {
                icon: "resources/images/cancel.png",
                handler: function (grid, rowIndex, colIndex) {
                    var rec = grid.getStore().getAt(rowIndex);
                    Ext.Msg.confirm("����", "ȷ��Ҫɾ����", function (button) {
                        if (button == "yes") {
                            Ext.Ajax.request({ //��ʼ��ѡ�
                                url: "/camel/rest/user?id=" + rec.id,
                                method: 'DELETE',
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
            text: '����', icon: 'resources/images/group_add.png', handler: function () {

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
                        fieldLabel: '��¼��',
                        id: 'loginNameId',
                        name: 'loginName',
                        allowBlank: false,
                        blankText: '��¼������Ϊ��!'
                    },
                    {
                        fieldLabel: '����',
                        id: 'nameId',
                        name: 'name',
                        allowBlank: false,
                        blankText: '��������Ϊ��!'
                    },
                    {
                        inputType: 'password',
                        fieldLabel: '����',
                        id: 'passwordId',
                        name: 'password',
                        allowBlank: false,
                        blankText: '���벻��Ϊ��!'
                    },
                    {
                        inputType: 'password',
                        fieldLabel: 'ȷ������',
                        isFormField:false,
                        id: 'confirmPasswordId',
                        allowBlank: false,
                        blankText: 'ȷ�����벻��Ϊ��!'
                    },
                    {
                        fieldLabel: '����',
                        id: 'emailId',
                        name: 'email',
                        allowBlank: false,
                        blankText: '���䲻��Ϊ��!'
                    },
                    {
                        fieldLabel: '�绰��',
                        id: 'phoneId',
                        name: 'phone',
                        allowBlank: false,
                        blankText: '�绰�Ų���Ϊ��!'
                    },
                    {
                        fieldLabel: '�ֻ���',
                        id: 'mobileId',
                        name: 'mobile',
                        allowBlank: false,
                        blankText: '�ֻ��Ų���Ϊ��!'
                    },
                    {
                        xtype: 'combobox',
                        fieldLabel: '״̬',
                        name: 'available',
                        editable:false,
                        value:'1',
                        store: [
                            ['1', '����'],
                            ['0', 'ͣ��']
                        ]
                    }
                ],
                buttons: [
                    {
                        text: '����', type: 'submit', handler: function () {
                        var form = this.up('form').getForm();
                        if (form.isValid()) {
                            var confirmPasswordValue = Ext.getCmp("confirmPasswordId").getValue();
                            var passwordValue = Ext.getCmp("passwordId").getValue();
                            if(confirmPasswordValue!=passwordValue){
                                Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, "������ȷ���������һ��!");
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
                            Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, "����������!");
                        }
                    }
                    },
                    {
                        text: '����', handler: function () {
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
                title: "�����û�",
                items: [addFormPanel]
            });

            win.show();
        }
        }, "-",
        {
            text: '����ɾ��', icon: 'resources/images/group_delete.png', handler: function () {
            var selModel = Ext.getCmp("userDataGrid").getSelectionModel();
            if (selModel.hasSelection()) {
                Ext.Msg.confirm("����", "ȷ��Ҫɾ����", function (button) {
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
                Ext.Msg.alert(CONFIG.ALTER_TITLE_ERROR, "��ѡ��Ҫɾ���ļ�¼��");
            }
        }
        }, "-"],
    bbar: [{
        xtype: 'pagingtoolbar',
        border: false,
        store: dataStore,
        displayMsg: '��ҳ��ʾ {0} - {1} �������� {2} ��',
        emptyMsg: "û������",
        beforePageText: "��ǰҳ",
        afterPageText: "��{0}ҳ",
        displayInfo: true
    }]

});