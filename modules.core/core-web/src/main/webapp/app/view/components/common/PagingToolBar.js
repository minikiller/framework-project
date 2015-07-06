/**
 * 分页工具条
 *
 * @author majian <br/>
 *         date:2015-7-6
 * @version 1.0.0
 */
Ext.define('Kalix.view.components.common.PagingToolBar', {
    extend: 'Ext.toolbar.Paging',
    alias: 'widget.pagingToolBarComponent',
    xtype:'pagingToolBarComponent',
    border: false,
    displayMsg: '本页显示 {0} - {1} 条，共计 {2} 条',
    emptyMsg: "没有数据",
    beforePageText: "当前页",
    afterPageText: "共{0}页",
    displayInfo: true

});