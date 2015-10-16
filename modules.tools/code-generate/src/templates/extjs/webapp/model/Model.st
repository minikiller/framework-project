/**
 * 用户模型
 *
 * @author majian
 *         date:2015-7-3
 * @version 1.0.0
 */
Ext.define('Kalix.<pomName>.model.<beanName>Model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'string'},
        {name: 'text', type: 'string'},//标题
        {name: 'content', type: 'string'},//内容
        {name: 'publishPeople', type: 'string'},//发布人
        {name: 'publishDate', type: 'int'},//发布时间
    ]
});