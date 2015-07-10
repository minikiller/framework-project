/**
 * 字典编辑表单
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('Kalix.admin.dict.view.DictEditForm', {
    extend: 'Ext.FormPanel',
    requires: [
        'Kalix.admin.dict.viewModel.DictViewModel',
        'Kalix.admin.dict.controller.DictFormController'
    ],
    alias: 'widget.dictEditForm',
    viewModel: {
        type: 'dictViewModel'
    },
    controller: 'dictFormController',
    id: "dictEditForm",
    xtype: 'dictEditForm',
    labelAlign: 'center',
    labelWidth: 75,
    autoWidth: true,
    autoHeight: true,
    bodyStyle: "padding:15px",
    frame: true,
    jsonSubmit: true,
    method:"PUT",
    defaultType: 'textfield',
    buttonAlign: "center",
    items: [
        {xtype: 'hiddenfield', name: 'id'},
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
            fieldLabel: '类型',
            name: 'type',
            editable:false,
            value:'1',
            store: [
                ['sex', '性别']
            ],
            beforeLabelTpl : [
                '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'
            ]
        },
        {
            fieldLabel: '排序',
            id: 'sortId',
            name: 'sort',
            allowBlank: false,
            beforeLabelTpl : [
                '<span style="color:red;font-weight:bold" data-qtip="必填选项">*</span>'
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
            text: '保存', type: 'submit', handler:'onUpdate'
        },
        {
            text: '重置', handler:'onEditReset'
        }
    ]
});