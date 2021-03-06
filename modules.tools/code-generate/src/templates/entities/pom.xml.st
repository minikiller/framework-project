\<?xml version="1.0" encoding="UTF-8"?>
\<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    \<modelVersion>4.0.0\</modelVersion>

    \<parent>
        \<groupId><packageName>\</groupId>
        \<artifactId><pomName>-parent\</artifactId>
        \<version><versionName>\</version>
    \</parent>

    \<artifactId><pomName>-entities\</artifactId>
    \<packaging>bundle\</packaging>
    \<name><projectName> :: <beanName> - Entities\</name>
    \<description><beanName> Entities\</description>

    \<properties>
        \<bundle.symbolicName><packageName>.entities\</bundle.symbolicName>
    \</properties>

    \<build>
        \<plugins>
            \<plugin>
                \<groupId>org.apache.maven.plugins\</groupId>
                \<artifactId>maven-antrun-plugin\</artifactId>
                \<executions>
                    \<execution>
                        \<phase>compile\</phase>
                        \<configuration>
                            \<tasks>
                                \<path id="enhance.path.ref">
                                    \<fileset dir="${project.build.outputDirectory}">
                                        \<include name="*Bean*/*.class"/>
                                    \</fileset>
                                \</path>
                                \<pathconvert property="enhance.files" refid="enhance.path.ref" pathsep=" "/>
                                \<java classname="org.apache.openjpa.enhance.PCEnhancer">
                                    \<arg line="-p persistence.xml"/>
                                    \<arg line="${enhance.files}"/>
                                    \<classpath>
                                        \<path refid="maven.dependency.classpath"/>
                                        \<path refid="maven.compile.classpath"/>
                                    \</classpath>
                                \</java>
                            \</tasks>
                        \</configuration>
                        \<goals>
                            \<goal>run\</goal>
                        \</goals>
                    \</execution>
                \</executions>
            \</plugin>
        \</plugins>
    \</build>
\</project>
