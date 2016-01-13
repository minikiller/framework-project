/**
 * <module_Name>查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('<extjsPrefix>.view.<beanName>ViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
        requires: [
            '<extjsPrefix>.viewModel.<beanName>ViewModel',
            'kalix.admin.user.store.UserStore'
        ],
        alias: 'widget.<pomName>ViewWindow',
        viewModel: '<pomName>ViewModel',
        xtype: "<pomName>ViewWindow",
        width: 400,
    //todo 在此修改查看字段
    items: [{
            defaults: {readOnly: true},
            xtype: 'baseForm',
            items: [
    <ViewWindowItems>
    /*
            {
                fieldLabel: '名称',
                allowBlank: false,
                bind: {
                    activeError: '{validation.name}',
                    value: '{rec.name}'
                }
            },
            {
                fieldLabel: '标题',
                allowBlank: false,
                bind: {
                    activeError: '{validation.title}',
                    value: '{rec.title}'
                }
            }, {
                fieldLabel: '内容',
                allowBlank: false,
                xtype: 'textarea',
                bind: {
                    activeError: '{validation.content}',
                    value: '{rec.content}'
                }
            },{
                fieldLabel: '发布时间',
                allowBlank: false,
                xtype: 'datefield',
                format: 'Y-m-d',
                bind: {
                    value: '{rec.publishDate}'
                }
                }
     */

                ]
            }

        ]


});