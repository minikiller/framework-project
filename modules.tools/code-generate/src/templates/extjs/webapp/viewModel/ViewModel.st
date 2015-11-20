/**
 * <module_Name>模型
 *
 * @author
 * @version 1.0.0
 */

Ext.define('<extjsPrefix>.viewModel.<beanName>ViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.<pomName>ViewModel',
    data: {
        rec: null,
        validation: {},  //验证错误信息
        icon: '',
        title: '',
        view_operation: false,
        view_title: '查看<module_Name>',
        add_title: '添加<module_Name>',
        edit_title: '修改<module_Name>',
        add_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_add.png',
        view_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_view.png',
        edit_image_path: '/kalix/roffice/<pomName>/resources/images/<pomName>_edit.png',
    }
});