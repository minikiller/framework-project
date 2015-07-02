/**
 * 主视图模型
 *
 * @author majian <br/>
 *         date:2015-6-18
 * @version 1.0.0
 */
Ext.define('AppFrame.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'AppFrame',

        system: {
            name: '应用开发框架',
            version: "V1.0",
            icon: "/admine/resources/images/logo_horizontal.png",
            background: '/admine/resources/images/f2.gif',
            copyright: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;copyright 吉林锐迅信息技术有限公司"
        },
        user: {
            url: "/admine/resources/datas/user.json",
            quit: "www.baidu.com"
        },
        application: {
            url: '/admine/resources/datas/applications.json'
        },
        module: {
            url: '/admine/resources/datas/modules'
        },
        menu: {
            title: '菜单列表'
        }
    }

    //TODO - add data, formulas and/or methods to support your view
});