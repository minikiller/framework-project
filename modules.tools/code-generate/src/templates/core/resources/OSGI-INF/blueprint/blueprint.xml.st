\<blueprint xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
           xsi:schemaLocation="http://www.osgi.org/xmlns/blueprint/v1.0.0 http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd
">

    \<service id="<pomName>BeanService" interface="<packageName>.api.biz.I<beanName>BeanService"
             ref="beanServiceImpl">
    \</service>

    \<bean id="beanServiceImpl" class="<packageName>.core.biz.<beanName>BeanServiceImpl">
        \<property name="dao" ref="<pomName>BeanDao"/>
        \<property name="shiroService" ref="shiroService"/>
    \</bean>

    \<reference id="<pomName>BeanDao" interface="<packageName>.api.dao.I<beanName>BeanDao"/>
    \<reference id="shiroService" interface="cn.com.rexen.core.api.security.IShiroService"/>
\</blueprint>

