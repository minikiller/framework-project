/**
 *应用组件控制器
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.controller.components.core.ApplicationController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.applicationComponentController',
    init: function () {

    },
    onTabchange: function (tabs, newTab, oldTab) {
        var applicationId = newTab.id;
        //追加模块列表
        if (newTab) {
            Ext.getCmp("leftPanel").removeAll();
            Ext.Ajax.request({ //初始化选项卡
                url: this.getViewModel().get("module.url") + applicationId + ".json",
                //params : "appId="+newTab.id,
                method: "GET",
                callback: function (options, success, response) {
                    var modules = Ext.JSON.decode(response.responseText);
                    if (modules && modules.length > 0) {
                        for (var i = 0; i < modules.length; i++) {
                            if (modules[i]) {
                                Ext.getCmp("leftPanel").add(Ext.create("Kalix.view.components.core.Module", modules[i]));
                            }
                        }
                    }
                }
            });
        }
    }
});