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
        {text: '编号', dataIndex: 'id',width:40},
        {text: '登录名', dataIndex: 'loginName',width:80},
        {text: '姓名', dataIndex: 'name',width:60},
        {text: '邮箱', dataIndex: 'email',width:60},
        {text: '电话', dataIndex: 'phone',width:60},
        {text: '手机', dataIndex: 'mobile',width:60},
        {text: '创建人', dataIndex: 'createBy',width:60},
        { text: '创建日期', dataIndex: 'creationDate',width:120,renderer:function(value){
            var createDate=new Date(value);
            return createDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        {text: '更新人', dataIndex: 'updateBy',width:60},
        { text: '更新日期', dataIndex: 'updateDate',width:120,renderer:function(value){
            var updateDate=new Date(value);
            return updateDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        {text: '最后登陆IP', dataIndex: 'loginIp',width:70},
        { text: '登陆日期', dataIndex: 'loginDate',width:120,renderer:function(value){
            var loginDate=new Date(value);
            return loginDate.format("yyyy-MM-dd hh:mm:ss");
        }},
        { text: '用户状态', dataIndex: 'available',width:60,renderer:function(value){
            if(value!=null&&value=="1"){
                return "启用";
            }
            return "停用";
        }},
        {
            header: '操作',
            xtype: "actioncolumn",
            width:60,
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