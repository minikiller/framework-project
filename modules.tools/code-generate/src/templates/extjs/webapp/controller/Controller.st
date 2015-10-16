/**
 * 用户模块控制器
 *
 * @author majian
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.<pomName>.controller.<beanName>Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.<pomName>Controller',
    requires: [
        'Kalix.view.components.common.PagingToolBar',
        'Kalix.<pomName>.view.<beanName>Grid',
        'Kalix.<pomName>.store.<beanName>Store'
    ],
    /**
     * 初始化面板.
     * @returns {Ext.panel.Panel}
     */
    onInitPanel: function () {

        var panel = Ext.create("Ext.panel.Panel", {
            border: false,
            autoScroll: true,
            height: 640,
            items: [this.onInitSearchPanel(), this.onInitDataGrid()]
        })

        return panel;
    },
    /**
     * 初始化查询面板.
     * @returns {Ext.panel.Panel}
     */
    onInitSearchPanel: function () {
        var formPanelRow1 = {
            layout: 'column',
            items: [{
                columnWidth: .2,
                border: false,
                layout: 'form',
                items: [{
                    xtype: 'textfield',
                    fieldLabel: '标题',
                    itemId: "<pomName>_title",
                    name: 'text'
                }]
            }]

        };


        //form
        var formPanel = Ext.create('Ext.form.FormPanel', {
            border: false,
            layout: 'form',
            labelWidth: 65,
            labelAlign: 'right',
            items: [formPanelRow1],
            buttonAlign: 'center',
            buttons: [{
                text: '查询',
                glyph: 0xf002,
                type: 'submit',
                handler: function () {
                    store.on('beforeload', function () {
                        store.proxy.extraParams = {
                            username_LIKE_STRING: Ext.getCmp('username')
                                .getValue(),
                            nickname_LIKE_STRING: Ext.getCmp('nickname')
                                .getValue(),
                            sex_EQ_INT: Ext.getCmp('sex').getValue(),
                            registDate_GT_DATE: Ext.getCmp('registDateFrom')
                                .getValue(),
                            registDate_LT_DATE: Ext.getCmp('registDateTo')
                                .getValue()
                        };
                    });
                    store.load({
                        params: {
                            start: 0,
                            limit: 10
                        }
                    });
                }
            }, {
                text: '重置',
                glyph: 0xf0e2,
                handler: function () {
                    formPanel.getForm().reset();
                }
            }]
        });


        var searchPanel = Ext.create("Ext.panel.Panel", {
            text: '条件查询',
            border: false,
            items: [formPanel]
        });

        return searchPanel;
    },
    /**
     * 初始化数据表格.
     * @returns {Ext.panel.Panel}
     */
    onInitDataGrid: function () {
        var <pomName>Store = Ext.create('Kalix.<pomName>.store.<beanName>Store');
        var dataGird = Ext.create("Kalix.<pomName>.view.<beanName>Grid",
            {
                store: <pomName>Store,
                bbar: [{
                    xtype: 'pagingToolBarComponent',
                    store: <pomName>Store
                }]
            });
        return dataGird;
    }
});