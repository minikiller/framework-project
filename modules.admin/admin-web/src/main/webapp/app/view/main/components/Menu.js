/**
 * 菜单组件
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.components.Menu', {
    extend: 'Ext.tree.Panel',
    requires: [
        'AppFrame.controller.MenuController'
    ],
    alias: 'widget.menuComponent',
    controller: 'menuComponentController',
    rootVisible: false,
    lines: true,
    autoScroll: true,
    listeners: {
        //beforeload:'onBeforeload',
        //load:'onLoad',
        itemClick: 'onItemClick'
    },
    border: false,
    constructor: function (config) {

        if (config) {
            var _tree = {root: {children: []}};
            _tree.root.children = config.menus;
            this.store = Ext.create('Ext.data.TreeStore', _tree);
        }
        this.callParent();
    }
});