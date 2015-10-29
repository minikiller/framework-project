\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<modelVersion>4.0.0\</modelVersion>

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId><pomName>-parent\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<artifactId><pomName>-dao\</artifactId>
    \<packaging>bundle\</packaging>
    \<name><projectName> :: <beanName> - JPA\</name>
    \<description><beanName> JPA\</description>

    \<properties>
        \<project.build.sourceEncoding>UTF-8\</project.build.sourceEncoding>
        \<bundle.symbolicName><packageName>.dao\</bundle.symbolicName>
        \<bundle.namespace>${bundle.symbolicName}\</bundle.namespace>
    \</properties>

    \<dependencies>
        \<dependency>
            \<groupId><packageName>\</groupId>
            \<artifactId><pomName>-entities\</artifactId>
            \<version><versionName>\</version>
        \</dependency>
        \<dependency>
            \<groupId><packageName>\</groupId>
            \<artifactId><pomName>-api\</artifactId>
            \<version><versionName>\</version>
        \</dependency>
    \</dependencies>

    \<build>
        \<plugins>

        \</plugins>
    \</build>
\</project>
