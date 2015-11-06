/**
 * <module_Name>查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('<extjsPrefix>.view.<beanName>ViewForm', {
    extend: 'Ext.window.Window',
    requires: [
        '<extjsPrefix>.viewModel.<beanName>ViewModel',
        '<extjsPrefix>.controller.<beanName>FormController'
    ],
    alias: 'widget.<pomName>ViewForm',
    viewModel: '<pomName>ViewModel',
    controller: '<pomName>FormController',
    xtype: "<pomName>ViewForm",

    width: 400,
    border: false,
    modal: true,
    resizable: false,
    title: '查看<module_Name>',
    bind: {
        icon: '{view_image_path}'
    },
    //todo 在此修改查看字段
    items: [{
        xtype: 'form',
        defaultType: 'displayfield',
        bodyPadding: 10,
        buttonAlign: "center",
        items: [
        {
            fieldLabel: '名称',
            labelAlign: 'right',
            bind: {
                value: '{rec.name}'
            }
        },
        {
            fieldLabel: '标题',
            labelAlign: 'right',
            bind: {
                value: '{rec.title}'
            }
        }, {
            fieldLabel: '内容',
            labelAlign: 'right',
            bind: {
                value: '{rec.content}'
            }
        }, {
            fieldLabel: '发布人',
            labelAlign: 'right',
            bind: {
                value: '{rec.publishPeople}'
            }
        }, {
            fieldLabel: '发布时间',
            labelAlign: 'right',
            format: 'Y-m-d',
            bind: {
                value: '{rec.publishDate}'
            },
            renderer: function (value) {
                var createDate = new Date(value);
                return createDate.format("yyyy-MM-dd");
        }
        }],
        buttons: [{
            text: '关闭',
            glyph: 'xf00d@FontAwesome',
            handler: function () {
                this.up('.window').close();
            }
        }
        ]
    }
    ]
});