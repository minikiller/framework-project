\<?xml version="1.0" encoding="UTF-8"?>

\<!-- default-activation="lazy" -->
\<blueprint
        xmlns:jpa="http://aries.apache.org/xmlns/jpa/v1.1.0"
        xmlns:tx="http://aries.apache.org/xmlns/transactions/v1.0.0"
        xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0">

    \<service interface="<packageName>.api.dao.I<beanName>BeanDao">
        \<bean class="<packageName>.dao.<beanName>BeanDaoImpl"> \<!--init-method="init">-->
            \<jpa:context property="entityManager" unitname="<pomName>-cm"/>
            \<tx:transaction method="*" value="Required"/>
        \</bean>
    \</service>
\</blueprint>

