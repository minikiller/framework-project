/**
 * �ײ����
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.region.Bottom', {
    extend: 'Ext.panel.Panel',

    alias: 'widget.mainbottom',

    items: [
        {
            xtype: "label",
            bind: {
                html: '{system.copyright}'
            }
        }
    ]
});