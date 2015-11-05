/**
 * <module_Name>首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.Main', {
    extend: 'Ext.container.Container',
    requires: [
        '<extjsPrefix>.store.<beanName>Store',  //用户模型集合
        '<extjsPrefix>.view.<beanName>Grid',
        '<extjsPrefix>.view.<beanName>SearchForm'
    ],
    items: [
        {
            title: '<module_Name>查询',
            xtype: '<pomName>SearchForm'
        }, {
            xtype: '<pomName>GridPanel',
            id: '<pomName>GridPanel',
            title: '<module_Name>列表',
            margin: 10,
            store: {
                type: '<pomName>Store'
            }
        }
    ]
});
