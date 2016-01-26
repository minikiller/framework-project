# 说明
用于提供osgi环境下的国际化的支持
1.  分成2个bundle，一个为api，一个为impl实现包
2.  impl包中是采用felix ipojo发布osgi service的。

```java
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
```

## reference
http://wiki.chameleon.ow2.org/xwiki/bin/view/Main.Catalog/i18nService
