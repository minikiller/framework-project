/**
 * 字典模块控制器
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.controller.DictController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.dictController',
    requires: [
        'Kalix.view.components.common.PagingToolBar',
        'Kalix.admin.dict.view.DictGrid'
    ],
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
                    fieldLabel: '标签',
                    id: "admin_dict_labelId",
                    name: 'username'
                }]
            }, {
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '数据值',
                    id: "admin_dict_valueId",
                    name: 'name'
                }]
            }]
        };

        //form
        var formPanel =Ext.create('Ext.form.FormPanel',{
            border: false,
            layout: 'form',
            labelWidth: 65,
            labelAlign: 'right',
            items: [formPanelRow1],
            buttonAlign: 'center',
            buttons: [{
                text: '查询',
                handler: function () {
                }
            }, {
                text: '重置',
                handler: function () {
                    formPanel.reset();
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
        var dataGird= Ext.create("Kalix.admin.dict.view.DictGrid");
        return dataGird;
    }
});