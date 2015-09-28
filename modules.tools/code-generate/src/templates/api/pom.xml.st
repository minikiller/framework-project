\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId>modules.<pomName>\</artifactId>
        \<version>1.0.0-SNAPSHOT\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<artifactId><packageName>.api\</artifactId>

    \<properties>
        \<bundle.symbolicName><packageName>.api\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>

    \<name>Kalix :: <beanName> - API\</name>
    \<description><beanName> API\</description>

    \<packaging>bundle\</packaging>

    \<dependencies>
        \<dependency>
            \<groupId>org.osgi\</groupId>
            \<artifactId>org.osgi.core\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>org.osgi\</groupId>
            \<artifactId>org.osgi.compendium\</artifactId>
        \</dependency>
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
            \<artifactId>org.apache.servicemix.specs.jsr339-api-m10\</artifactId>
        \</dependency>

        \<dependency>
            \<groupId>cn.com.rexen.kalix.<pomName>\</groupId>
            \<artifactId>cn.com.rexen.kalix.<pomName>.entities\</artifactId>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>

        \</plugins>
    \</build>
\</project>