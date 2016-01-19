/**
 * 学生模型
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.app.student.viewModel.StudentViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.studentViewModel',
    data: {
        rec: null,
        validation: {},  //验证错误信息
        icon: '',
        title: '',
        view_operation: false,
        view_title: '查看学生',
        add_title: '添加学生',
        edit_title: '修改学生',
        add_image_path: '/kalix/admin/student/resources/images/student_add.png',
        view_image_path: '/kalix/admin/student/resources/images/student_view.png',
        edit_image_path: '/kalix/admin/student/resources/images/student_edit.png',
    }
});