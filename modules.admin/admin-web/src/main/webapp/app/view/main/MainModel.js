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
            icon: "/admin/resources/images/logo_horizontal.png",
            background: '/admin/resources/images/f2.gif',
            copyright: "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;copyright 吉林锐迅信息技术有限公司"
        },
        user: {
            url: "/admin/resources/datas/user.json",
            quit: "www.baidu.com"
        },
        application: {
            url: '/admin/resources/datas/applications.json'
        },
        module: {
            url: '/admin/resources/datas/modules'
        },
        menu: {
            title: '菜单列表'
        }
    }

    //TODO - add data, formulas and/or methods to support your view
});