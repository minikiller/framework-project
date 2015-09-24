\<?xml version="1.0" encoding="UTF-8"?>
\<!--suppress ALL -->
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId>modules.<pomName>\</artifactId>
        \<version>1.0.0-SNAPSHOT\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<artifactId><packageName>.core\</artifactId>

    \<properties>
        \<bundle.symbolicName><packageName>.core\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>

    \<name>Kalix :: <beanName> - Core\</name>
    \<description><beanName> Core\</description>

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
            \<groupId><packageName>\</groupId>
            \<artifactId><packageName>.api\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId><packageName>\</groupId>
            \<artifactId><packageName>.entities\</artifactId>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>
        \</plugins>
    \</build>

\</project>