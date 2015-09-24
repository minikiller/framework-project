<?xml version="1.0" encoding="UTF-8"?>
<blueprint xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://www.osgi.org/xmlns/blueprint/v1.0.0"
           xsi:schemaLocation="http://www.osgi.org/xmlns/blueprint/v1.0.0 http://www.osgi.org/xmlns/blueprint/v1.0.0/blueprint.xsd
       http://camel.apache.org/schema/blueprint http://camel.apache.org/schema/blueprint/camel-blueprint.xsd">
    <reference id="auditService" interface="cn.com.rexen.audit.api.biz.IAuditBeanService"/>
    <camelContext id="auditCamel" xmlns="http://camel.apache.org/schema/blueprint">

        <restConfiguration component="servlet" bindingMode="json"
                           contextPath="/kalix/camel/rest" host="localhost"
                           port="8181">

            <dataFormatProperty key="prettyPrint" value="true"/>
        </restConfiguration>

        <!-- defines the rest services using the context-path /area -->
        <rest path="/audits" consumes="application/json" produces="application/json">
            <description>audit rest service</description>


            <!-- this is a rest PUT to create an area -->
            <post id="route-addAudit" type="cn.com.rexen.audit.entities.AuditBean"
                  outType="cn.com.rexen.core.api.biz.JsonStatus">
                <description>Create a Audit</description>
                <to uri="bean:auditService?method=saveEntity"/>
            </post>

            <!-- this is a rest PUT to update an area -->
            <put id="route-updateAudit" type="cn.com.rexen.audit.entities.AuditBean"
                 outType="cn.com.rexen.core.api.biz.JsonStatus">
                <description>Updates a Audit</description>
                <to uri="bean:auditService?method=updateEntity"/>
            </put>

            <!-- this is a rest DELETE to delete an area -->
            <delete id="route-deleteaudit" outType="cn.com.rexen.core.api.biz.JsonStatus">
                <description>Delete a Audit</description>
                <to uri="bean:auditService?method=deleteEntity(${header.id})"/>
            </delete>

            <!-- this is a rest GET to find all areas -->
            <get id="route-getAllAudit" outType="cn.com.rexen.core.api.persistence.JsonData">
                <description>Find all Audits</description>
                <to uri="bean:auditService?method=getAllEntity(${header.page},${header.limit})"/>
            </get>


            <!-- this is a rest GET to view an user by the given id -->
            <get id="route-getaudit" uri="/{id}" outType="cn.com.rexen.audit.entities.AuditBean">
                <description>Find Audit by id</description>
                <to uri="bean:auditService?method=getEntity(${header.id})"/>
            </get>

        </rest>

    </camelContext>
</blueprint>