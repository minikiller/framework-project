/**
 * <module_Name>新增和修改表单控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('<extjsPrefix>.controller.<beanName>FormController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.<pomName>FormController',
    requires: ['kalix.core.Notify'],
    /**
     * 重置操作.
     *
     */
    onReset: function () {
        var viewModel = this.getViewModel();
        var model = viewModel.get('rec');

        var modified = _.reduce(_.keys(model.getChanges()), function (memo, item) {
            memo[item] = model.getModified(item);
            return memo;
        }, {});
        model.set(modified);
    },

    /**
     * 保存/更新操作.
     *
     */
    onSave: function () {
        var viewModel = this.getViewModel();
        var model = viewModel.get('rec');
        var view = this.getView();

        if (model.isValid()) {
            Ext.Ajax.request({
                url: viewModel.get('url'),
                method: 'POST',
                params: model.toServerJSON(),
                defaultPostHeader: 'application/json',
                success: function (response, opts) {
                    var res = Ext.JSON.decode(response.responseText);
                    if (res.success) {
                        view.close();
                        kalix.getApplication().getStore('<pomName>Store').reload();
                        kalix.core.Notify.success(res.msg, CONFIG.ALTER_TITLE_SUCCESS);
                    } else {
                        Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, res.msg);
                    }
                },
                failure: function (response, opts) {
                    Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, res.msg);
                }
            });
        } else {
            viewModel.set('validation', _.pick(model.getValidation().data, function (value, key, object) {
                return value !== true;
            }));
        }
    },
});
