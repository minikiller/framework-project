# kalix-project

1. 本项目使用karaf作为部署环境
2. 使用openjpa作为持久化数据
3. 使用Extjs作为web开发框架  <br/>
4. 使用couchdb作为上传下载服务器  <br/>
5. 使用camel rest 发布rest 服务 <br/>
6. 统一使用shiro作为rest的安全框架<br/>
7. 使用dbunit作为数据库的初始化和导出工具（under util bundle） <br/>
8. 使用shiro作为安全框架 <br/>
9. 使用bootstrap作为表现层框架 <br/>
10. core-archetype用于新建业务模块
（例如：创建一个order业务模块

 ```xml
 mvn archetype:generate -DgroupId=cn.com.rexen.order
 -DartifactId=order -Dversion=1.0-SNAPSHOT -Dpackage=cn.com.rexen.order
 -DarchetypeGroupId=cn.com.rexen.core -DarchetypeArtifactId=cn.com.rexen.core.archetype
 -DarchetypeVersion=1.0-SNAPSHOT -DarchetypeRepository=local）
 ```

11. 使用acitviti作为工作流引擎  <br/>
12. core-util的CouchdbConfig實現了osgi的configAdmin（blueprint） <br/>
13. mvn install:install-file -Dfile=d:\kaptcha-2.3.2.jar -DgroupId=com.google.code -DartifactId=kaptcha -Dversion=2.3.2 -Dpackaging=jar
14. osgi service事务控制，在blueprint里的bean定义中加入<tx:transaction method="*" value="Required"/>
15. 安装redis为window服务：redis-server --service-install redis.windows.conf
16. 使用couchdb作为cms存储attachment

```xml
feature:repo-add mvn:cn.com.rexen.tools/karaf-features/1.0.0-SNAPSHOT/xml/features
install -s mvn:org.postgresql/postgresql/9.4-1202-jdbc41
```

## 使用pax-jdbc
用于配置数据源和数据连接池

## 增加karaf的feature
打开org.apache.karaf.features.cfg 文件，增加
 mvn:cn.com.rexen.kalix/karaf-features/1.0.0-SNAPSHOT/xml/features
## 查看数据源
 ls DataSource

## 查看jpa是否安装成功

ls EntityManagerFactory

## 总体架构图

![Extensions Tab Screenshot](https://github.com/minikiller/framework-project/blob/master/construct.png)
