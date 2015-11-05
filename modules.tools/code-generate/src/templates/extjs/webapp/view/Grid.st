/**
 * <module_Name>表格
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.view.<beanName>Grid', {
    extend: 'Ext.grid.Panel',
    requires: [
        '<extjsPrefix>.viewModel.<beanName>ViewModel',
        '<extjsPrefix>.controller.<beanName>GridController',
        'kalix.view.components.common.SecurityToolbar',
        'kalix.view.components.common.PagingToolBar'
    ],
    alias: 'widget.<pomName>Grid',
    xtype: '<pomName>GridPanel',
    controller: '<pomName>GridController',
    viewModel: '<pomName>ViewModel',
    autoLoad: true,
    stripeRows: true,
    /*viewConfig: {
     forceFit: true,
     },*/
     //todo 在此修改grid显示列
    columns: [
        {
            xtype: "rownumberer",
            text: "行号",
            width: 50,
            align: 'center'
        },
        {
            text: '编号',
            dataIndex: 'id',
            hidden: true,
            flex: 1
        }, {
            text: '标题',
            dataIndex: 'title',
            flex: 1
        }, {
            text: '内容',
            dataIndex: 'content',
            flex: 3
        }, {
            text: '发布人',
            dataIndex: 'publishPeople',
            flex: 1
        }, {
            text: '发布时间',
            dataIndex: 'publishDate',
            flex: 1,
            renderer: function (value) {
                var createDate = new Date(value);
                return createDate.format("yyyy-MM-dd hh:mm:ss");
            }
        },
    ],

    tbar: {
        xtype: 'securityToolbar',

        //无需授权的按钮
        items: [
            {
                text: '查看',
                xtype: 'button',
                permission: 'admin:sysModule:permissionControl:<pomName>Menu:view',
                //icon: this.getViewModel().get("view_image_path"),
                handler: 'onView',
                bind: {
                    icon: '{view_image_path}'
                }
            },
            {
                text: '新增',
                xtype: 'button',
                permission: 'admin:sysModule:permissionControl:<pomName>Menu:add',
                handler: 'onAdd',
                bind: {
                    icon: '{add_image_path}'
                }
            },
            {
                text: '修改',
                xtype: 'button',
                permission: 'admin:sysModule:permissionControl:<pomName>Menu:update',
                handler: 'onEdit',
                bind: {
                    icon: '{edit_image_path}'
                }
            }, {
                text: '删除',
                xtype: 'button',
                permission: 'admin:sysModule:permissionControl:<pomName>Menu:delete',
                handler: 'onDelete',
                bind: {
                    icon: '{delete_image_path}'
                }
            }
        ]

        //需要验证权限后添加的按钮
        //verifyItems: []
    },

    /*
     grid 组件不自动绑定与 grid 相关的翻页工具条的 store 配置项
     需要手动指定工具条的 store
     */
    bbar: [{
        id: '<pomName>-pagingtoolbar',
        xtype: 'pagingToolBarComponent',
        border: false,
        padding: 0,
        listeners: {
            afterrender: function (c, obj) {
                this.setConfig('store', kalix.getApplication().getStore('<pomName>Store'));
            }
        }
    }
    ],

});
