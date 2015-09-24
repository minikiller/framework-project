\<blueprint xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
           xsi:schemaLocation="http://www.osgi.org/xmlns/blueprint/v1.0.0 http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd
">

    \<service id="<pomName>BeanService" interface="<packageName>.api.biz.I<beanName>BeanService"
             ref="beanServiceImpl">
    \</service>

    \<bean id="beanServiceImpl" class="<packageName>.core.biz.<beanName>BeanServiceImpl">
        \<property name="<pomName>BeanDao" ref="<pomName>BeanDao"/>
    \</bean>

    \<reference id="<pomName>BeanDao" interface="<packageName>.api.dao.I<beanName>BeanDao"/>
\</blueprint>

