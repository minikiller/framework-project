\<?xml version="1.0" encoding="UTF-8"?>
\<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="1.0">
    \<persistence-unit transaction-type="JTA" name="<pomName>-cm">
        \<provider>org.hibernate.jpa.HibernatePersistenceProvider\</provider>
        \<jta-data-source>osgi:service/javax.sql.DataSource/(osgi.jndi.service.name=jdbc/ds)
        \</jta-data-source>
        \<class>cn.com.rexen.core.api.persistence.PersistentEntity\</class>
        \<class><packageName>.entities.<beanName>Bean\</class>
        \<properties>
            \<property name="hibernate.hbm2ddl.auto" value="update"/>
            \<property name="hibernate.archive.autodetection" value="class"/>
            \<property name="hibernate.id.new_generator_mappings" value="true"/>
            \<property name="hibernate.cache.use_second_level_cache" value="false"/>
            \<property name="hibernate.show_sql" value="true"/>
        \</properties>
    \</persistence-unit>
\</persistence>
