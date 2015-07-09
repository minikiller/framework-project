/**
 * 字典表格
 * @author majian <br/>
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.view.DictGrid', {
    extend: 'Ext.grid.Panel',
    requires: [
        'Kalix.admin.dict.viewModel.DictViewModel',
        'Kalix.admin.dict.controller.DictGridController'
    ],
    alias: 'widget.dictGrid',
    id: "dictDataGrid",
    xtype: 'dictGrid',
    controller: 'dictGridController',
    viewModel: {
        type: 'dictViewModel'
    },
    autoLoad :true,
    stripeRows: true,
    manageHeight: true,
    selModel: {selType: 'checkboxmodel', mode: "SIMPLE"},
    bind:{
        store:'{dictStore}'
    },
    bbar: [{
        xtype: 'pagingToolBarComponent',
        bind:{
            store:'{dictStore}'
        }
    }],
    columns: [
        {text: '编号', dataIndex: 'id'},
        {text: '标签名', dataIndex: 'label'},
        {text: '数据值', dataIndex: 'value'},
        {text: '类型', dataIndex: 'type'},
        {text: '排序', dataIndex: 'sort'},
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
            text: '新增', icon: 'admin/resources/images/book_add.png', handler: 'onAdd'
        }, "-",
        {
            text: '批量删除', icon: 'admin/resources/images/book_delete.png', handler:'onDeleteAll'
        }, "-"]

});