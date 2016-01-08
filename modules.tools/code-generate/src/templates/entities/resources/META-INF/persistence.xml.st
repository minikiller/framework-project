\<?xml version="1.0" encoding="UTF-8"?>
\<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="1.0">
    \<persistence-unit transaction-type="JTA" name="<pomName>-cm">
        \<provider>org.apache.openjpa.persistence.PersistenceProviderImpl\</provider>
        \<non-jta-data-source>osgi:service/javax.sql.DataSource/(osgi.jndi.service.name=jdbc/ds)
        \</non-jta-data-source>
        \<class>cn.com.rexen.core.api.persistence.PersistentEntity\</class>
        \<class><packageName>.entities.<beanName>Bean\</class>
        \<properties>
            \<property name="openjpa.BrokerImpl" value="non-finalizing"/>
            \<property name="openjpa.Sequence" value="table(Table=OPENJPASEQ, Increment=100)"/>
            \<property name="openjpa.jdbc.UpdateManager"
                      value="org.apache.openjpa.jdbc.kernel.BatchingConstraintUpdateManager"/>

            \<property name="openjpa.jdbc.SynchronizeMappings" value="buildSchema"/>
            \<property name="openjpa.Log" value="SQL=Info"/>
            \<property name="openjpa.ConnectionFactoryProperties" value="PrintParameters=true"/>
            \<property name="openjpa.RuntimeUnenhancedClasses" value="supported"/>
        \</properties>
    \</persistence-unit>
\</persistence>
