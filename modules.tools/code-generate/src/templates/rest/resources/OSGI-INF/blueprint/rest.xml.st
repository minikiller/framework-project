\<?xml version="1.0" encoding="UTF-8"?>
\<blueprint xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
           xsi:schemaLocation="http://www.osgi.org/xmlns/blueprint/v1.0.0 http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd
       http://camel.apache.org/schema/blueprint http://camel.apache.org/schema/blueprint/camel-blueprint.xsd">
    \<reference id="<pomName>Service" interface="<packageName>.api.biz.I<beanName>BeanService"/>
    \<camelContext id="<pomName>Camel" xmlns="http://camel.apache.org/schema/blueprint">

        \<restConfiguration component="servlet" bindingMode="json"
                           contextPath="/kalix/camel/rest" host="localhost"
                           port="8181">
            \<dataFormatProperty key="prettyPrint" value="true"/>
        \</restConfiguration>

        \<!-- defines the rest services using the context-path /<pomName> -->
        \<rest path="/<pomName>s" consumes="application/json" produces="application/json">
            \<description><pomName> rest service\</description>

            \<!-- this is a rest PUT to create an <pomName> -->
            \<post id="route-add<beanName>" type="<packageName>.entities.<beanName>Bean"
                  outType="cn.com.rexen.core.api.biz.JsonStatus">
                \<description>Create a <beanName>\</description>
                \<to uri="bean:<pomName>Service?method=saveEntity"/>
            \</post>

            \<!-- this is a rest PUT to update a <pomName> -->
            \<put id="route-update<beanName>" type="<packageName>.entities.<beanName>Bean"
                 outType="cn.com.rexen.core.api.biz.JsonStatus">
                \<description>Updates a <beanName>\</description>
                \<to uri="bean:<pomName>Service?method=updateEntity"/>
            \</put>

            \<!-- this is a rest DELETE to delete a <pomName> -->
            \<delete id="route-delete<beanName>" outType="cn.com.rexen.core.api.biz.JsonStatus">
                \<description>Delete a <beanName>\</description>
                \<to uri="bean:<pomName>Service?method=deleteEntity(${header.id})"/>
            \</delete>

            \<!-- this is a rest GET to find all <pomName> -->
            \<get id="route-getAll<beanName>" outType="cn.com.rexen.core.api.persistence.JsonData">
                \<description>Find all <beanName>s\</description>
                \<to uri="bean:<pomName>Service?method=getAllEntity(${header.page},${header.limit})"/>
            \</get>

            \<!-- this is a rest GET to view a <pomName> by the given id -->
            \<get id="route-get<beanName>" uri="/{id}" outType="<packageName>.entities.<beanName>Bean">
                \<description>Find <beanName> by id\</description>
                \<to uri="bean:<pomName>Service?method=getEntity(${header.id})"/>
            \</get>

        \</rest>
    \</camelContext>
\</blueprint>