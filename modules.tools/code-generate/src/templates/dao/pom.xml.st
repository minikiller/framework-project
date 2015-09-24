\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    \<modelVersion>4.0.0\</modelVersion>
    \<parent>
            \<groupId><packageName>\</groupId>
            \<artifactId>modules.<pomName>\</artifactId>
            \<version>1.0.0-SNAPSHOT\</version>
        \</parent>

    \<artifactId><packageName>.dao\</artifactId>
    \<packaging>bundle\</packaging>
    \<name>Kalix :: <beanName> - JPA\</name>
    \<description><beanName> JPA\</description>

    \<properties>
        \<project.build.sourceEncoding>UTF-8\</project.build.sourceEncoding>
        \<bundle.symbolicName><packageName>.dao\</bundle.symbolicName>
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
            \<groupId><packageName>\</groupId>
            \<artifactId><packageName>.entities\</artifactId>
        \</dependency>
        \<dependency>
            \<groupId><packageName>\</groupId>
            \<artifactId><packageName>.api\</artifactId>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>

        \</plugins>
    \</build>
\</project>
