/**
 * 菜单组件
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.controller.components.core.MenuController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.menuComponentController',

    init: function () {

    },
    onBeforeload: function () {
        this.getView().getBody().mask("载入中...");
    },
    onLoad: function () {
        this.getView().getBody().unmask();
    },
    onItemClick: function (view, record, item, index, e) {
        if (record.data.leaf) {
            var centerTabPanel = Ext.getCmp("centerTabPanel");

            var currentTab = centerTabPanel.getComponent(record.data.component.id);
            if (!currentTab) {
                Ext.require(record.data.component.componentClass);
                currentTab = new Ext.Panel({
                    id: record.data.component.id,
                    title: record.data.component.title,
                    icon: record.data.component.icon,
                    loadMask: true,
                    closable: true,
                    items: [Ext.create(record.data.component.componentClass)],
                    autoScroll: true
                });
                centerTabPanel.add(currentTab);
            }
            centerTabPanel.setActiveTab(currentTab);
        }
    }
});