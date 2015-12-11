#### 说明

1.提供osgi的类加载器



2.需要在osgi.bnd加入

    Delegation-Annotations:*

3.在实体上加入如下

    @Provide(context = {"foo", "bar"}, alias = "mtestbean")
    public class TestBean implements Serializable {

4.在其他的bundle里面获得bean

    Class entityClass=new DelegatedClassLoadingHelper(bundleContext).loadClass(entityName);
