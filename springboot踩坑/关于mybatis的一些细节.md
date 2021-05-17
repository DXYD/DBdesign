 1.使用xml文件方式从数据库查询表中数据
 
 在resources目录下编写一个接口的映射文件userDaoMapper.xml(相当于接口UserDao的实现类）
 ```xml
<?xml version="1.0" encoding="UTF-8" ?> <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <!--namespace:对应的是dao层中的接口
                   id:必须与接口中的方法的名称一致
           resultType：方法返回值的类型
           持久层dao接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字
           符串作为 key 值，可唯一定位一个 MapperStatement。在 Mybatis 中，每一个
           <select>、<insert>、<update>、<delete>标签，都会被解析为一个
           MapperStatement 对象
           -->
<mapper namespace="org.xupt.dao.UserDao">
<select id="queryAllUsers" resultType="org.xupt.entity.User">
        select * from mybatis_demo.user;
    </select>
</mapper>
```
编写mybatis的配置文件mybatis-config.xml，将mybatis与数据库连接(数据库的配置信息可以抽取出来成一个db.properties文件然后在configuration标签下面使用properties标签引入)
```xml
<?xml version="1.0" encoding="UTF-8" ?> <!DOCTYPE configuration
       PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
       "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <environments default="mysql">
       <environment id="mysql">
           <transactionManager type="JDBC"/>
           <dataSource type="POOLED">
               <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
               <property name="url" value="jdbc:mysql://localhost:3306/mybatis_demo?serverTimezone=UTC"/>
               <property name="username" value="root"/>
               <property name="password" value="123456"/>
           </dataSource>
       </environment>
   </environments>
   <mappers>
       <!--mybatis sql映射⽂件的位置-->
       <mapper resource="UserDaoMapper.xml"/>
   </mappers>
</configuration>
```
2. 使用注解的方式从数据库查询表中数据

注解方式与xml方式区别：
注解方式不需要xml映射文件 sql语句写在接口中的方法上的注解里
mybatis的配置文件中sql映射要换成接口所在位置

    public interface UserDao {
        查询数据库中所有的user
           @Select("select * from user")
           List<User> queryAllUsers();
        }

修改sql映射位置

    <mappers>
        <!--mybatis sql映射⽂件的位置-->
        <mapper class="org.xupt.dao.UserDao"/>
    </mappers>
