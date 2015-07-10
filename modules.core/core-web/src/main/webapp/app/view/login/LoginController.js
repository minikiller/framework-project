/**
 * 登陆视图控制器
 *
 * @author majian <br/>
 *         date:2015-7-10
 * @version 1.0.0
 */
Ext.define('Kalix.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    onLogin:function(){
        var form=Ext.getCmp("loginForm");
        if (form.isValid()) {
            form.submit({
                url:this.getView().getViewModel().get("loginUrl"),
                waitMsg:'登陆中....',
                waitTitle:'提示',
                success: function (form, action) {
                    if(action.result.status){
                        window.location.href=action.result.location;
                    }else{
                        Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, action.result.msg);
                    }
                }
            });
        }
    },
    onReset:function(){
        Ext.getCmp("loginForm").reset();
    }

});