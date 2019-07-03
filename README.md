# Spring Boot Security Test
测试Spring Boot以及一些组件的安全机制

### MybatisGenerator的安全问题
##### MySql数据库
```bash
docker pull mysql/mysql-server:5.7.26

docker run -d --env MYSQL_ROOT_PASSWORD=changeme --env MYSQL_USER=test --env MYSQL_PASSWORD=changeme --env MYSQL_DATABASE=test --publish 3306:3306 mysql/mysql-server:5.7.26
```
##### 配置mybatis generator
- 引入maven依赖
- 编写配置文件
##### 执行mybatis generator生成pojos和sql语句
```bash
mvn mybatis-generator:generate
```