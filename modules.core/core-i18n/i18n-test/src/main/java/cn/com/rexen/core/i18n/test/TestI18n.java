package cn.com.rexen.core.i18n.test;

import cn.com.rexen.core.i18n.api.I18nService;

/**
 * Created by Administrator on 2016-01-25.
 */
public class TestI18n {
    private I18nService service;

    public void setService(I18nService  service) {
        this.service = service;
    }

    public void test(){
//        I18nService i18n = service.getI18nServiceForCurrentLocale("myapp", true); // Include parents
        String str=service.getString("hello");
        System.out.print(str);
    }
}
