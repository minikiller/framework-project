/**
 * 应用组件
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.view.components.core.Application', {
    extend: 'Ext.TabPanel',
    requires: [
        'Kalix.controller.components.core.ApplicationController',
        'Kalix.view.main.MainModel'
    ],
    alias: 'widget.applicationComponent',
    controller: 'applicationComponentController',
    viewModel: 'main',
    autoWidth: true,
    autoHeight: true,
    id: "application",
    plain: true,
    frame: false,
    broder: false,
    listeners: {
        tabchange: 'onTabchange'
    },
    initComponent: function () {
        var id = this.id;
        Ext.Ajax.request({ //初始化应用组件
            url: this.getViewModel().get("application.url"),
            //url :"/resources/datas/applications.json",
            method: "GET",
            callback: function (options, success, response) {
                var applications = Ext.JSON.decode(response.responseText);
                if (applications && applications.length > 0) {
                    for (var i = 0; i < applications.length; i++) {
                        Ext.getCmp(id).add(Ext.create('Ext.Panel', {
                            id: applications[i].id,
                            title: applications[i].title,
                            icon: applications[i].icon,
                            closable: false
                        }));
                    }
                    Ext.getCmp(id).setActiveTab(0);
                }
            }
        });
        this.callParent(arguments);

    },
    items: []
});