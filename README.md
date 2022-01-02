# 智能写作分析系统 Intelligent writing analysis system

## 功能介绍 Function description：
- 写作功能：对写作内容产生自动反馈
- 存档评分功能： 保存写作内容并添加标题和评分
- 报表功能：记录历史写作内容，展示历次评分情况
- 社区功能：分享帖子到社区，可以评论和被评论，查看评论消息
- 关于：API介绍，建议收集
- 座右铭：CSS动画

## 技术工具 Technical tools
- 开发环境：IDEA
- 数据库：MySql
- 项目管理：Maven
- 前端：jQuery,layui，Echarts
- 后端：Spring,SpringMVC,Mybatis
- 安全：Shiro
- 缓存：MyBatis Cache
- 代理：Nginx
- 版本控制：Git

## 数据库连接 Database connection
- jdbc.propertes保存了mysql的配置信息，运行前请修改用户名和密码，并建立所需的数据库和表，建表语句可以从writer1.sql中获得。

## 更新日志 Update log
- 见updatelog

# 启动步骤

1. 下载MySQL，创建数据库`writer1`，并导入`writer1.sql`

2. 下载Tomcat

3. 将项目打包为war包，放到tomcat的`webapps`目录下，然后启动tomcat

4. 浏览器访问`localhost:8080/writer1`
