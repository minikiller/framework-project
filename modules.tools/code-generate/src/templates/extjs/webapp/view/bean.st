/**
 * 用户组件
 *
 * @author majian
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.<pomName>.view.<beanName>', {
    extend: 'Ext.panel.Panel',
    requires: [
        'Kalix.<pomName>.viewModel.<beanName>ViewModel',
        'Kalix.<pomName>.controller.<beanName>Controller'
    ],
    controller: '<pomName>Controller',
    viewModel: {
        type: '<pomName>ViewModel'
    },
    items: [],
    initComponent: function () {
        var <pomName>Controller = this.getController("<pomName>Controller");

        this.items[0] = <pomName>Controller.onInitPanel();
        /*var grid = Ext.getCmp("<pomName>DataGrid");
         var store = grid.getStore();
         store.load({params:{start:0, limit:10}});
         grid.getView().refresh();*/
        this.callParent(arguments);
    }
});