/**
 * 字典模型
 *
 * @author majian <br/>
 *         date:2015-7-4
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.admin.dict.DictModel', {
    extend: 'Ext.data.Model',
    fields: [
         {name: 'id', type: 'int'},
         {name: 'label', type: 'string'},
         {name: 'value', type: 'string'},
         {name: 'type', type: 'string'},
         {name: 'description', type: 'string'},
         {name: 'sort', type: 'int'},
         {name: 'createBy', type: 'string'},
         {name: 'creationDate', type: 'long'},
         {name: 'updateBy', type: 'string'},
         {name: 'updateDate', type: 'long'}
    ]
});