\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    \<modelVersion>4.0.0\</modelVersion>

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId><pomName>-parent\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<artifactId><pomName>-rest\</artifactId>
    \<packaging>bundle\</packaging>
    \<name><projectName> :: <beanName> - Rest\</name>
    \<description><beanName> Rest Service\</description>

    \<properties>
        \<project.build.sourceEncoding>UTF-8\</project.build.sourceEncoding>
        \<bundle.symbolicName><packageName>.rest\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>

    \<dependencies>
        \<dependency>
            \<groupId>cn.com.rexen.kalix.poms\</groupId>
            \<artifactId>poms-dm\</artifactId>
            \<version><versionName>\</version>
            \<type>pom\</type>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>

        \</plugins>
    \</build>

\</project>