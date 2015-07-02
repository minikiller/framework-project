/**
 * 主视图
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.Main', {
    extend: 'Ext.container.Container',
    requires: [
        'AppFrame.view.main.MainController',
        'AppFrame.view.main.MainModel'
    ],

    xtype: 'app-main',

    uses: ['AppFrame.view.main.region.Top', 'AppFrame.view.main.region.Left', 'AppFrame.view.main.region.Center', 'AppFrame.view.main.region.Bottom'],

    controller: 'main',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },
    listeners: {
        resize: 'onResize'
    },

    items: [{
        xtype: 'maintop',
        region: 'north'
    }, {
        xtype: 'mainleft',
        bind: {
            title: '{menu.title}'
        },
        region: 'west'
    }, {
        xtype: 'maincenter',
        region: 'center'
    }, {
        xtype: 'mainbottom',
        region: 'south'
    }]
});
