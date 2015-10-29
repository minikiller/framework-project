\<?xml version="1.0" encoding="UTF-8"?>
\<!--suppress ALL -->
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<parent>
        \<groupId><parentPackageName>\</groupId>
        \<artifactId><parentName>-parent\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<groupId><packageName>\</groupId>
    \<artifactId><pomName>-parent\</artifactId>

    \<name><projectName> :: Modules - <beanName>\</name>

    \<packaging>pom\</packaging>

    \<properties>

    \</properties>
    \<modules>
        \<module><pomName>-entities\</module>
        \<module><pomName>-api\</module>
        \<module><pomName>-dao\</module>
        \<module><pomName>-core\</module>
        \<module><pomName>-rest\</module>
        \<module><pomName>-web\</module>
        \<module><pomName>-extjs\</module>
    \</modules>

    \<dependencyManagement>
        \<dependencies>
        \</dependencies>
    \</dependencyManagement>

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
            \<groupId>cn.com.rexen.kalix.core\</groupId>
            \<artifactId>core-api\</artifactId>
            \<version><versionName>\</version>
        \</dependency>

        \<dependency>
            \<groupId>cn.com.rexen.kalix.core\</groupId>
            \<artifactId>core-impl\</artifactId>
            \<version><versionName>\</version>
        \</dependency>

        \<dependency>
            \<groupId>cn.com.rexen.kalix.core\</groupId>
            \<artifactId>core-util\</artifactId>
            \<version><versionName>\</version>
        \</dependency>
        \<dependency>
            \<groupId>log4j\</groupId>
            \<artifactId>log4j\</artifactId>
        \</dependency>
    \</dependencies>

\</project>