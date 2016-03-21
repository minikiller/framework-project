应用管理模块
============
1. 用于管理应用以及相应的功能
2. 应用下包括功能
3. 插件管理
   osgi.bnd文件里需要写明：Kalix-Plugin
   已实现该插件的为security-impl和shiro-ext两个bundle。
   Kalix-Plugin:shiro-ext；
   Kalix-Plugin:shiro-form；

** bundleTracker 在app-core的InitActivator代码中实现