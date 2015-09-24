\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    \<modelVersion>4.0.0\</modelVersion>
    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId>modules.<pomName>\</artifactId>
        \<version>1.0.0-SNAPSHOT\</version>
    \</parent>

    \<artifactId><packageName>.entities\</artifactId>
    \<packaging>bundle\</packaging>
    \<name>Kalix :: <pomName> - Entities\</name>
    \<description><pomName> Entities\</description>


    \<properties>
        \<bundle.symbolicName>cn.com.rexen.<pomName>.entities\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>

    \<dependencies>
        \<dependency>
            \<groupId>cn.com.rexen.core\</groupId>
            \<artifactId>cn.com.rexen.core.api\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>cn.com.rexen.core\</groupId>
            \<artifactId>cn.com.rexen.core.impl\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>org.apache.servicemix.specs\</groupId>
            \<artifactId>org.apache.servicemix.specs.jsr303-api-1.0.0\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>org.hibernate.javax.persistence\</groupId>
            \<artifactId>hibernate-jpa-2.1-api\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>org.hibernate\</groupId>
            \<artifactId>hibernate-entitymanager\</artifactId>
            \<version>${hibernate.version}\</version>
        \</dependency>
    \</dependencies>
    \<build>
        \<plugins>
        \</plugins>
    \</build>

\</project>
