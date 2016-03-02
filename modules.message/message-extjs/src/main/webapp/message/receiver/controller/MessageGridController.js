/**
 * 消息表格控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.receiver.controller.MessageGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: [
        'kalix.message.sender.view.MessageWindow',
        'kalix.message.sender.model.MessageModel'
    ],
    alias: 'controller.messageReceiverGridController',
    onView: function (grid, rowIndex, colIndex) {
        var selModel = grid.getStore().getData().items[rowIndex];
        var scope = this;
        var args = arguments;
        var store = grid.getStore();

        if (true == selModel.get('read')) {//已读消息
            this.callParent(arguments);
        }
        else {
            selModel.set('read', true);
            selModel.set('state', 0);
            selModel.modified = selModel.data;
            grid.getStore().sync({//修改为已读已通知
                success: function () {
                    selModel.dirty = false;
                },
                callback: function (batch) {
                    store.currentPage = 1;
                    store.load();
                    var res = Ext.JSON.decode(batch.operations[0].getResponse().responseText);
                    if (batch.operations[0].success) {
                        scope.onView(args[0], args[1], args[2]);//参数分别传入
                    }
                    else {
                        Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, res.msg);
                    }
                }
            });
        }
    },
    onSender: function () {
        var view = Ext.create('kalix.message.sender.view.MessageWindow');
        var vm = view.lookupViewModel();

        vm.set('rec', Ext.create('kalix.message.sender.model.MessageModel'));
        vm.set('icon', '/kalix/message/resources/images/message_add.png');
        vm.set('title', '发件');
        view.show();
    },
    onDeleteAll: function () {
        var selModel = this.getView().getSelectionModel();
        if (selModel.hasSelection()) {
            Ext.Msg.confirm("警告", "确定要删除吗？", function (button) {
                if (button == "yes") {
                    //var deleteUrl = this.getView().getViewModel().get("url");
                    var rows = selModel.getSelected();
                    var ids = "";
                    for (var i = 0; i < rows.length; i++) {
                        var row = rows.getAt(i);
                        if (row != null && row.id != null) {
                            ids += row.id;
                            if (i + 1 != rows.length) {
                                ids += ":";
                            }
                        }
                    }
                    Ext.Ajax.request({
                        url: deleteUrl + "?id=" + rec.id,
                        method: 'DELETE',
                        callback: function (options, success, response) {
                            var resp = Ext.JSON.decode(response.responseText);
                            if (resp.success) {
                                kalix.core.Notify.success("操作成功", "提示", {timeOut: 1500});
                                var store = grid.getStore();
                                store.reload();
                            }
                        }
                    });
                }
            });
        } else {
            Ext.Msg.show({
                title: '提示',
                message: '至少应该选择一条记录进行操作',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.WARNING,
                fn: null
            });
        }
    }
});
