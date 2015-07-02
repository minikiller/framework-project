/**
 * 中部面板
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.region.Center', {
    extend: 'Ext.panel.Panel',

    /*
     Uncomment to give this component an xtype
     xtype: 'center',
     */
    alias: 'widget.maincenter',


    id: 'centerPanel',
    items: [{
        xtype: 'tabpanel',
        id: 'centerTabPanel',
        items: [{
            title: '首页',
            html: '<h2>Content appropriate for the current navigation.</h2>'
        }]
    }
    ]
});