## 一、开发环境
### 1、JDK
    版本：jdk-8u66-windows-x64
### 2、IntelliJ IDEA
    版本： 15.0.2
    破解：需联网，Help菜单下的Register...，在弹出的窗口中首先选择License server，
    然后在license server address:下输入地址http://15.idea.lanyus.com/，
    最后点击按钮Discover server，再点击按钮OK即可。
### 3、Maven
    版本：apache-maven-3.3.3
    说明：简化和标准化项目建设过程。处理编译，分配，文档，团队协作和其他任务的无缝连接。
### 4、Karaf
    版本：apache-karaf-4.0.4
    说明：Karaf是一个基于OSGi的运行环境，Karaf提供了一个轻量级的OSGi容器，可以用于部署各种组件，应用程序。
### 5、PostgreSQL
    版本：postgresql-9.4.4-3-windows-x64
    说明：对象关系型数据库管理系统（ORDBMS）。
### 6、Redis
    版本：Redis-x64-2.8.21
    说明：Redis是一个开源的、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并提供多种语言的API。
### 7、Git
    版本：git-1.9.2
    说明：Git是一个开源的分布式版本控制系统，用以有效、高速的处理从很小到非常大的项目版本管理。
### 8、CouchDB
    版本：couchdb-1.6.1_R16B02
    说明：CouchDB是一个面向文档的数据库，在它里面所有文档域（Field）都是以键值对的形式存储的。
### 9、OpenJPA
    版本：2.3.0
    说明：OpenJPA 是 Apache 组织提供的开源项目，它实现了 EJB 3.0 中的 JPA 标准，为开发者提供功能强大、
         使用简单的持久化数据管理框架。OpenJPA 封装了和关系型数据库交互的操作，让开发者把注意力集中在编写业务逻辑上。
### 10、ExtJs
    版本：extjs 6.0.0
    说明：前端js脚本框架。
### 11、操作系统
    版本：Windows 7,64位。

## 二、项目结构
### 1、kalix-project
    modules.admin
    描述：后台管理功能模块的接口类。包括工作组管理服务接口、用户管理服务接口、角色管理服务接口、权限服务接口、机构管理服务接口、
    系统消息服务接口、字典管理服务接口、部门管理服务接口、区域管理服务接口、系统版本服务接口等。
    modules.app
    描述：应用服务、功能服务、插件服务
    modules.audit
    描述：审计
    modules.core
    描述：
        cn.com.rexen.core.api.biz：
        cn.com.rexen.core.api.cache：
        cn.com.rexen.core.api.dao：
        cn.com.rexen.core.api.internal：
        cn.com.rexen.core.api.osgi：
        cn.com.rexen.core.api.persistence：
        cn.com.rexen.core.api.security：
        cn.com.rexen.core.api.system：
        cn.com.rexen.core.api.web：
    modules.demo
    描述：
    modules.docs
    描述：
    modules.duty
    描述：
    modules.example
    描述：
    modules.middleware
    描述：
    modules.notice
    描述：
    modules.osgi
    描述：
    modules.poms
    描述：
    modules.security
    描述：
    modules.student
    描述：
    modules.tools
    描述：

### 2、各模块相关目录结构说明
    ***-api:
        cn.com.rexen.***.api.biz：各功能的Service接口类，命名规则I***Service，如IUserBeanService。
        cn.com.rexen.***.api.dao：各功能的Dao接口类命名规则I***Dao如IUserBeanDao。
        cn.com.rexen.***.api.internal：bundle的启动和停止。
        src/main/resources：存放Bundle相关的资源。
    ***-core：
        cn.com.rexen.***.core：各功能的Service接口的实现类，命名规则***ServiceImpl，如UserBeanServiceImpl。
        cn.com.rexen.***.core.internal：bundle的初始化工作。
        resources：存放Bundle相关的资源。
    ***-dto：
        cn.com.rexen.***.dto：各功能的组合模型类，命名规则***DTO，如部门模型类DepartmentDTO。
    ***-entities：
        cn.com.rexen.a***.entities：各功能的实体实现类，命名规则***Bean，如UserBean。
    ***-persist-jpa(***-dao)：
        cn.com.rexen.***.persist.openjpa：各功能的DAO实现类，命名规则***DaoImpl，如UserBeanDaoImpl。
    ***-rest：
        cn.com.rexen.***.rest.internal：bundle的启动和停止。
        src/main/resources：
    ***-extjs：
        controller：控制器，命名规则：***GridController.js
        model：模型，命名规则：***Model.js
        store：数组仓库，命名规则：***Store.js
        view：
            ***Grid.js：列表
            ***SearchForm.js：查询表单
            ***DutyViewWindow.js：查看表单
            ***Window.js：新增和修改表单
        viwModel：
            ***ViewModel.js：查看模型
        Main.js：
    ***-web：
        cn.com.rexen.***.web.impl：菜单实现类
        src/main/resources/OSGI-INF.blueprint：
            ***-web.xml服务发布
    pom.xml：
        项目的对象模型，作为maven项目的实现，主要描述了项目：包括配置文件；开发者需要遵循的规则，
        缺陷管理系统，组织和licenses，项目的url，项目的依赖性，以及其他所有的项目相关因素。

### 2、Cache


