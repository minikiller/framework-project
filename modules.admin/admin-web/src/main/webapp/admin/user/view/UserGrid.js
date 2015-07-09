/**
 * 用户表格
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('Kalix.admin.user.view.UserGrid', {
    extend: 'Ext.grid.Panel',
    requires: [
        'Kalix.admin.user.viewModel.UserViewModel',
        'Kalix.admin.user.controller.UserGridController'
    ],
    alias: 'widget.userGrid',
    id: "userDataGrid",
    xtype: 'userGrid',
    controller: 'userGridController',
    viewModel: {
        type: 'userViewModel'
    },
    autoLoad :true,
    stripeRows: true,
    manageHeight: true,
    selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
    bind:{
        store:'{userStore}'
    },
    bbar: [{
        xtype: 'pagingToolBarComponent',
        bind:{
            store:'{userStore}'
        }
    }],
    columns: [
        {text: '编号', dataIndex: 'id'},
        {text: '登录名', dataIndex: 'loginName'},
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
                tooltip: '修改',
                handler: 'onEdit'
            }, {
                icon: "resources/images/cancel.png",
                tooltip: '删除',
                handler:'onDelete'

            }]
        }
    ],
    tbar: [
        {
            text: '新增', icon: 'admin/resources/images/group_add.png', handler: 'onAdd'
        }, "-",
        {
            text: '批量删除', icon: 'admin/resources/images/group_delete.png', handler:'onDeleteAll'
        }, "-"]

});