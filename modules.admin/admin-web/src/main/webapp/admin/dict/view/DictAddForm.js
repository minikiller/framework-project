/**
 * 字典新增表单
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.view.DictAddForm', {
    extend: 'Ext.FormPanel',
    requires: [
        'Kalix.admin.dict.viewModel.DictViewModel',
        'Kalix.admin.dict.controller.DictFormController'
    ],
    alias: 'widget.dictAddForm',
    viewModel: {
        type: 'dictViewModel'
    },
    controller: 'dictFormController',
    id: "dictAddForm",
    xtype: "dictAddForm",
    labelAlign: 'center',
    labelWidth: 75,
    autoWidth: true,
    autoHeight: true,
    jsonSubmit: true,
    bodyStyle: "padding:15px",
    frame: true,
    buttonAlign: "center",
    defaultType: 'textfield',
    items: [
        {
            fieldLabel: '标签名',
            id: 'labelId',
            name: 'label',
            allowBlank: false,
            blankText: '标签名不能为空!',
            beforeLabelTpl : [
                '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'
            ]
        },
        {
            fieldLabel: '数据值',
            id: 'valueId',
            name: 'value',
            allowBlank: false,
            blankText: '数据值不能为空!',
            beforeLabelTpl : [
                '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'
            ]
        },
        {
            xtype: 'combobox',
            fieldLabel: '状态',
            name: 'available',
            editable:false,
            value:'1',
            store: [
                ['1', '启用'],
                ['0', '停用']
            ],
            beforeLabelTpl : [
                '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'
            ]
        },
        {
            fieldLabel: '排序',
            id: 'sortId',
            name: 'sort',
            allowBlank: true,
            beforeLabelTpl : [
                '<span  >&nbsp;&nbsp;</span>'
            ]
        },
        {
            xtype:'textarea',
            fieldLabel: '备注',
            id: 'descriptionId',
            name: 'description',
            beforeLabelTpl : [
                '<span  >&nbsp;&nbsp;</span>'
            ]
        }
    ],
    buttons: [
        {
            text: '保存', type: 'submit', handler:'onSave'
        },
        {
            text: '重置', handler:'onAddReset'
        }
    ]
});