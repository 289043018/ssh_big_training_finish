# ssh_big_training_finish
整合后的ssh大练习

使用calsspath内的ssh_training_v1.9.sql文件导入数据库，数据库名字为ssh_training。
数据库设置可以在classpath内的config.properties文件进行修改。
可以先在数据库的user表中添加用户信息再进行登录。
先清理一下项目：mvn clean
然后在重新编译：mvn compile
然后使用tomcat运行：mvn tomcat:run
最后在浏览器中输入：http://localhost:8080/ssh_big_training/jsp/login.jsp进行登录。
