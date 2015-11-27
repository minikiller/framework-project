/**
 * <module_Name>表格
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.view.<beanName>Grid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        '<extjsPrefix>.controller.<beanName>GridController',
        '<extjsPrefix>.store.<beanName>Store',
    ],
    alias: 'widget.<pomName>Grid',
    xtype: '<pomName>GridPanel',
    controller: {
        type: '<pomName>GridController',
        storeId: '<pomName>Store',
        cfgForm: '<extjsPrefix>.view.<beanName>Window',
        cfgViewForm: '<extjsPrefix>.view.<beanName>ViewWindow',
        cfgModel: '<extjsPrefix>.model.<beanName>Model'
    },
    store: {
        type: '<pomName>Store'
    },

    //todo 在此修改grid显示列
    columns: {
        defaults: {flex: 1,renderer: 'addTooltip'},
        items: [
            {
                xtype: "rownumberer",
                text: "行号",
                width: 50,
                align: 'center',
                renderer:this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true,
            }, {
                text: '标题',
                dataIndex: 'title',
            }, {
                text: '名称',
                dataIndex: 'name',
            },
            {
                text: '内容',
                dataIndex: 'content',
            }, {
                text: '发布人',
                dataIndex: 'publishPeople',
            }, {
                text: '发布时间',
                dataIndex: 'publishDate',
                xtype: 'datecolumn',
                format: 'Y-m-d'
            },
            {
                xtype: 'securityGridColumnRUD',
                //todo change permission
                permissions: [
                    'roffice:deployModule:<pomName>Menu:view',
                    'roffice:deployModule:<pomName>Menu:edit',
                    'roffice:deployModule:<pomName>Menu:delete'
                ]
            }
        ]
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                //todo change permission
                permission: 'roffice:deployModule:<pomName>Menu:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
