\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId>modules.<pomName>\</artifactId>
        \<version>1.0.0-SNAPSHOT\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<artifactId><packageName>.rest\</artifactId>
    \<packaging>bundle\</packaging>
    \<name>Kalix :: <beanName> - Rest\</name>
    \<description><beanName> Rest Service\</description>

    \<properties>
        \<project.build.sourceEncoding>UTF-8\</project.build.sourceEncoding>
        \<bundle.symbolicName><packageName>.rest\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>
    \<dependencies>
        \<!-- camel -->
        \<dependency>
            \<groupId>org.apache.camel\</groupId>
            \<artifactId>camel-core\</artifactId>
        \</dependency>

        \<dependency>
            \<groupId>org.apache.camel\</groupId>
            \<artifactId>camel-servlet\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>org.apache.camel\</groupId>
            \<artifactId>camel-metrics\</artifactId>
        \</dependency>

        \<!-- swagger api -->
        \<dependency>
            \<groupId>org.apache.camel\</groupId>
            \<artifactId>camel-swagger\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId>cn.com.rexen.core\</groupId>
            \<artifactId>cn.com.rexen.core.api\</artifactId>
            \<scope>provided\</scope>
        \</dependency>

        \<!-- use for json binding -->
        \<dependency>
            \<groupId>org.apache.camel\</groupId>
            \<artifactId>camel-jackson\</artifactId>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>

        \</plugins>
    \</build>

\</project>