``application.yml的配置一定要注意数据库``
```yaml
spring:
  datasource:
    username: root
    password:
    url: jdbc:mysql://localhost:3306/dbdesign
    driver-class-name: com.mysql.cj.jdbc.Driver
mybatis:
    #  配置要扫描的JavaBean
    type-aliases-package: com.dbdesign.keshe.model
    #  配置到时候要扫描的mapper文件
    mapper-locations: classpath:/mappers/*.xml
```