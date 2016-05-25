\<?xml version="1.0" encoding="UTF-8"?>
\<!--suppress ALL -->
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<parent>
        \<groupId><parentPackageName>\</groupId>
        \<artifactId><parentName>\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<modelVersion>4.0.0\</modelVersion>
    \<groupId><packageName>\</groupId>
    \<artifactId><pomName>-parent\</artifactId>

    \<name><projectName> :: Modules - <beanName>\</name>

    \<packaging>pom\</packaging>

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
                \<groupId>cn.com.rexen.kalix.poms\</groupId>
                \<artifactId>poms-dm\</artifactId>
                \<version>${globle.version}\</version>
                \<type>pom\</type>
                \<scope>import\</scope>
            \</dependency>
        \</dependencies>
    \</dependencyManagement>

    \<dependencies>
        \<dependency>
            \<groupId>cn.com.rexen.kalix.poms\</groupId>
                 \<artifactId>poms-dm\</artifactId>
                 \<type>pom\</type>
                 \<version>${globle.version}\</version>
        \</dependency>
    \</dependencies>
\</project>