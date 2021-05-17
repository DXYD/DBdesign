springboot的5种读取配置方式（1）：直接读取bean

springboot的5种读取配置方式（2）：通过config读取指定文件

springboot的5种读取配置方式（3）：通过application.properties读取

springboot的5种读取配置方式（4）：通过application.yml读取

springboot的5种读取配置方式（5）：通过applicationContext.xml读取

https://blog.csdn.net/weixin_39220472/article/details/80194899


---
spring 配置文件 主配置文件名叫applicationContext.xml   

C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210514023219661.png

​ spring配置文件是用于指导Spring工厂进行Bean生产、依赖关系注入（装配）及Bean实例分发的"图纸"。Spring框架的配置文件是基于xml的，Spring强大的功能依赖于类型繁多的配置项，

https://haoyongliang.gitee.io/2020/06/10/spring/Spring%E6%95%B4%E5%90%88mybatis/#%E6%A1%88%E4%BE%8B%E4%BB%8B%E7%BB%8D

https://www.cnblogs.com/mengd/p/13493502.html#:~:text=%E5%B0%86%20MyBatis%E4%B8%8E%20Spring%20%E8%BF%9B%E8%A1%8C%E6%95%B4%E5%90%88%EF%BC%8C%E4%B8%BB%E8%A6%81%E8%A7%A3%E5%86%B3%E7%9A%84%E9%97%AE%E9%A2%98%E5%B0%B1%E6%98%AF%E5%B0%86%20SqlSessionFactory%20%E5%AF%B9%E8%B1%A1%E4%BA%A4%E7%94%B1%20Spring%E6%9D%A5%E7%AE%A1%E7%90%86%E3%80%82%20%E6%89%80%E4%BB%A5%EF%BC%8C%E8%AF%A5%E6%95%B4%E5%90%88%EF%BC%8C%E5%8F%AA%E9%9C%80%E8%A6%81%E5%B0%86,SqlSessionFactory%20%E7%9A%84%E5%AF%B9%E8%B1%A1%E7%94%9F%E6%88%90%E5%99%A8%20SqlSessionFactoryBean%20%E6%B3%A8%E5%86%8C%E5%9C%A8%20Spring%20%E5%AE%B9%E5%99%A8%E4%B8%AD%EF%BC%8C%E5%86%8D%E5%B0%86%E5%85%B6%E6%B3%A8%E5%85%A5%E7%BB%99%20Dao%20%E7%9A%84%E5%AE%9E%E7%8E%B0%E7%B1%BB%E5%8D%B3%E5%8F%AF%E5%AE%8C%E6%88%90%E6%95%B4%E5%90%88

https://img2020.cnblogs.com/blog/1212924/202008/1212924-20200812223419126-1607246661.png

---

mybatis 配置文件 mybatis-config.xml

---
springboot 配置文件

SpringBoot默认配置文件
SpringBoot使用默认的全局的配置文件：application.properties/application.yml

配置文件名固定是是application
```properties
`application.properties`
	语法结构: key=value
```

```yaml
`application.yml`
	语法结构: key：空格 value
```
https://gitee.com/zhong_siru/images/raw/master//img/image-20200920122317741.png