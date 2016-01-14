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
                flex: 0,
                align: 'center',
                renderer:this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true,
            },
            <GridItems>
            {
                xtype: 'securityGridColumnRUD',
                //todo change permission
                permissions: [
                    '<permission_app>:<permission_module>:<permission_menu>:view',
                    '<permission_app>:<permission_module>:<permission_menu>:edit',
                    '<permission_app>:<permission_module>:<permission_menu>:delete'
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
                permission: '<permission_app>:<permission_module>:<permission_menu>:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
