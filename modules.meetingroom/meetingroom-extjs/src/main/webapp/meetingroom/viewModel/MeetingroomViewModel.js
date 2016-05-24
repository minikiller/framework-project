/**
 * 会议室模型
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.app.meetingroom.viewModel.MeetingroomViewModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.meetingroomViewModel',
    data: {
        rec: null,
        validation: {},  //验证错误信息
        icon: '',
        title: '',
        view_operation: false,
        view_title: '查看会议室',
        add_title: '添加会议室',
        edit_title: '修改会议室',
        add_image_path: '/kalix/app/meetingroom/resources/images/meetingroom_add.png',
        view_image_path: '/kalix/app/meetingroom/resources/images/meetingroom_view.png',
        edit_image_path: '/kalix/app/meetingroom/resources/images/meetingroom_edit.png'
    }
});