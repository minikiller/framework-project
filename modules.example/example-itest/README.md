#### 使用PAX Exam 4.7.0进行集成测试
    MavenArtifactUrlReference karafUrl = maven()
                .groupId("org.apache.karaf")
                .artifactId("apache-karaf")
                .version(karafVersion())
                .type("zip");
上面代码用于获得karaf的zip包



