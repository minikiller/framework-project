\<?xml version="1.0" encoding="UTF-8"?>
\<!--suppress ALL -->
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<parent>
        \<!--\<relativePath>../poms/compiled/\</relativePath>-->
        \<groupId>cn.com.rexen.platform.kalix-project.build\</groupId>
        \<artifactId>compiled-bundle-settings\</artifactId>
        \<version>1.0.0-SNAPSHOT\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<groupId><packageName>\</groupId>
    \<artifactId>modules.<pomName>\</artifactId>

    \<name>Kalix :: Modules - <beanName>\</name>

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
            \<dependency>
                \<groupId><packageName>\</groupId>
                \<artifactId><packageName>.core\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
            \<dependency>
                \<groupId><packageName>\</groupId>
                \<artifactId><packageName>.api\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
            \<dependency>
                \<groupId><packageName>\</groupId>
                \<artifactId><packageName>.entities\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
            \<dependency>
                \<groupId><packageName>\</groupId>
                \<artifactId><packageName>.persist.openjpa\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
            \<dependency>
                \<groupId>cn.com.rexen.core\</groupId>
                \<artifactId>cn.com.rexen.core.api\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
            \<dependency>
                \<groupId>cn.com.rexen.core\</groupId>
                \<artifactId>cn.com.rexen.core.impl\</artifactId>
                \<version>1.0.0-SNAPSHOT\</version>
                \<scope>provided\</scope>
            \</dependency>
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
            \<groupId>cn.com.rexen.core\</groupId>
            \<artifactId>cn.com.rexen.core.util\</artifactId>
            \<version>1.0.0-SNAPSHOT\</version>
            \<scope>provided\</scope>
        \</dependency>
        \<dependency>
            \<groupId>log4j\</groupId>
            \<artifactId>log4j\</artifactId>
        \</dependency>
    \</dependencies>

\</project>