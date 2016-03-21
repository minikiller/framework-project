package cn.com.rexen.core.i18n.test;

import cn.com.rexen.core.i18n.api.I18nService;
import cn.com.rexen.core.i18n.api.I18nServiceSelector;

import java.util.Locale;

/**
 * Created by Administrator on 2016-01-25.
 */
public class TestI18n {
    private I18nServiceSelector service;

    public void setService(I18nServiceSelector service) {
        this.service = service;
    }

    public void test(){
        I18nService i18n = service.getI18nService("myapp", Locale.SIMPLIFIED_CHINESE); // Include parents
        String str = i18n.getString("hello");
        System.out.print(str);
    }
}
