\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<modelVersion>4.0.0\</modelVersion>

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId><pomName>-parent\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<artifactId><pomName>-api\</artifactId>
    \<name><projectName> :: <beanName> - API\</name>
    \<description><beanName> API\</description>
    \<packaging>bundle\</packaging>

    \<properties>
        \<bundle.symbolicName><packageName>.api\</bundle.symbolicName>
    \</properties>

    \<dependencies>
        \<dependency>
            \<groupId><packageName>\</groupId>
            \<artifactId><pomName>-entities\</artifactId>
            \<version><versionName>\</version>
        \</dependency>
    \</dependencies>
\</project>