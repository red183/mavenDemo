当前是一个快速开发平台基本框架
====

### 运行环境

        JAVA 7 +　Tomcat 7 +　MySQL 5.7

### 前置条件

> 创建数据库

>> 1.创建本地用户

>>>        CREATE USER 'quicksite-demo'@'localhost' IDENTIFIED BY 'quicksite-demo';

>> 2.授权本地用户所有权限

>>>        GRANT ALL PRIVILEGES ON `quicksite-demo` . * TO 'quicksite-demo'@'localhost';

>> 3.创建数据库，默认字符集采用 utf8;

>>>        CREATE DATABASE IF NOT EXISTS `quicksite-demo` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

> 数据初始化

+ 执行 db/init-db.bat 命令；
+ 定时器 db/schedule/*.sql 需要单独执行，也可以理解为重置定时器数据；

### 开发环境
        开发时使用 mvn jetty:run
