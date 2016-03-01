/**
 * 消息表格控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.message.receiver.controller.MessageGridController', {
    extend: 'kalix.controller.BaseGridController',
    alias: 'controller.messageReceiverGridController',
    onView: function (grid, rowIndex, colIndex) {
        var selModel = grid.getStore().getData().items[rowIndex];
        var scope = this;
        var args = arguments;
        var store = grid.getStore();

        if (0 == selModel.get('read')) {
            this.callParent(arguments);
        }
        else {
            selModel.set('read', 0);
            selModel.set('message_state',0);
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
    }
});
