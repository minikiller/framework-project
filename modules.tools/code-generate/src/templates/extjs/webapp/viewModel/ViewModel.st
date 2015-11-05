/**
 * <module_Name>模型
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.viewModel.<beanName>ViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.<pomName>ViewModel',
    requires: [
        '<extjsPrefix>.model.<beanName>Model'
    ],
    data: {
        url: '/kalix/camel/rest/<pomName>s',
        rec: Ext.create('<extjsPrefix>.model.<beanName>Model'),
        validation: {},  //验证错误信息
        icon: '',
        title: '',
        add_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_add.png',
        view_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_view.png',
        delete_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_delete.png',
        edit_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_edit.png',
    }
});