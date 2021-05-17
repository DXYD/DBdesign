关于Sping与MyBatis的整合，通过Spring实例化Bean,然后调用实例对象中的查询方法来执行MyBatis映射文件中的SQL语句，如果能够正确查询出数据库中的数据，我们就认为已经整合好，具体实现流程见下图

第一步，src目录下创建db.properties文件，配置数据库的基本四项
```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis
jdbc.username=root
jdbc.password=root
jdbc.maxTotal=30
jdbc.maxIdle=10     <!--最大空闲数-->
jdbc.initialSize=5   <!--初始化连接数-->
```

第二步，src目录下创建Spring的配置文件 ，applicationContext.xml

读取db.properties文件的配置
配置数据源
配置事务管理器并开启了事务注解
配置MyBatis工厂与Spring整合
```xml

<?xml version="1.0" encoding="UTF-8"?>
 
 
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:tx="http://www.springframework.org/schema/tx" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/tx 
    http://www.springframework.org/schema/tx/spring-tx-4.3.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
 
 
    <!--读取db.properties -->
    <context:property-placeholder location="classpath:db.properties"/>
 
 
    <!-- 配置数据源 -->
	<bean id="dataSource" 
            class="org.apache.commons.dbcp2.BasicDataSource">
        <!--数据库驱动 -->
        <property name="driverClassName" value="${jdbc.driver}" />
        <!--连接数据库的url -->
        <property name="url" value="${jdbc.url}" />
        <!--连接数据库的用户名 -->
        <property name="username" value="${jdbc.username}" />
        <!--连接数据库的密码 -->
        <property name="password" value="${jdbc.password}" />
        <!--最大连接数 -->
        <property name="maxTotal" value="${jdbc.maxTotal}" />
        <!--最大空闲连接  -->
        <property name="maxIdle" value="${jdbc.maxIdle}" />
        <!--初始化连接数  -->
        <property name="initialSize" value="${jdbc.initialSize}" />
	</bean>
 
 
	<!-- 事务管理器，依赖于数据源 --> 
	<bean id="transactionManager" class=
     "org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>	
 
 
    <!--开启事务注解 -->
	<tx:annotation-driven transaction-manager="transactionManager"/>
 
 
    <!--配置MyBatis工厂 -->
<!--MyBatis工厂构建的SqlSesstionFactory的作用：通常在配置时，需要提供两个参数，一个是数据源，一个是MyBatis的配置文件的构建路径，这样在配置时，Spring的Ioc容器就会在初始化id为sqlSessionFactory的bean时解析MyBatis的配置文件时就会与数据源一同保存在Spring的bean中-->
 
    <bean id="sqlSessionFactory" 
            class="org.mybatis.spring.SqlSessionFactoryBean">
         <!--注入数据源 -->
         <property name="dataSource" ref="dataSource" />
         <!--指定核心配置文件位置 -->
   		<property name="configLocation" value="classpath:mybatis-config.xml"/>
   </bean>
```
   
 
以下不在项目最开始的文件中，根据项目后期的要求自行添加
----开始-----
 
   <!--实例化Dao -->
	<bean id="customerDao" class="com.itheima.dao.impl.CustomerDaoImpl">
 
	<!-- 注入SqlSessionFactory对象实例-->
	     <property name="sqlSessionFactory" ref="sqlSessionFactory" />
	</bean>
-----结束----
 
 
<!-- Mapper代理开发（基于MapperScannerConfigurer）也可以理解为配置mapper扫描器 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	     <property name="basePackage" value="com.itheima.mapper" />
	</bean>
	
 
	<!-- 开启扫描 --> 
	<context:component-scan base-package="com.itheima.service" />
	
</beans>
第三步，以及MyBatis的配置文件，由于Spring的配置文件中已经配置了数据源，所以在这里就不需要在配置，
<configuration>
    <!--配置别名 -->
    <typeAliases>
        <package name="com.itheima.po" />
    </typeAliases>
    <!--配置Mapper的位置 -->
	<mappers> 
       <mapper resource="com/itheima/po/CustomerMapper.xml" />
       <!-- Mapper接口开发方式 -->
	   <mapper resource="com/itheima/mapper/CustomerMapper.xml" />
       
	</mappers>
</configuration>
第四步，创建log4j.properties文件，直接复制就行

# Global logging configuration
log4j.rootLogger=ERROR, stdout
# MyBatis logging configuration...
log4j.logger.com.itheima=DEBUG
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%5p [%t] - %m%n
第五步，实现持久层

在src目录下，创建一个po包，并创建持久层Customer
```java
public class Customer {
	private Integer id;       // 涓婚敭id
	private String username; // 瀹㈡埛鍚嶇О
	private String jobs;      // 鑱屼笟
	private String phone;     // 鐢佃瘽
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + 
				       ", jobs=" + jobs + ", phone=" + phone + "]";
	}
}
```

 在创建一个映射文件CustomerMapper.xml，该文件编写根据id查询客户信息的映射语句
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.itheima.po.CustomerMapper">
	<!--根据id查询客户信息 -->
	<select id="findCustomerById" parameterType="Integer"
		     resultType="customer">
		select * from t_customer where id = #{id}
	</select>
</mapper>
```
第六步，实现Dao层

src下创建dao包，先创建一个接口CustomerDao，在接口声明一个findCustomerById的方法
```java
import com.itheima.po.Customer;
public interface CustomerDao {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);
}
```

第七步，创建一个dao.impl包,创建CustomerDao接口的实现类CustomerDaoImpl
```java
import org.mybatis.spring.support.SqlSessionDaoSupport;
import com.itheima.dao.CustomerDao;
import com.itheima.po.Customer;
public class CustomerDaoImpl 
                      extends SqlSessionDaoSupport implements CustomerDao {
 
SqlSessionDaoSupport类在使用时需要一个SqlSessionFactory或一个SqlSessionTemplate对象，所以需要Spring在applicationContext.xml中注入一个上述的对象，这样子类可以通过调用SqlSessionDaoSupprot类的getSqlSession方法获取SqlSession对象，并使用其方法
 
	// 通过id查询客户
	public Customer findCustomerById(Integer id) {
         	return this.getSqlSession().selectOne("com.itheima.po"
				      + ".CustomerMapper.findCustomerById", id);
	}
}
```
第八步，整合测试
```java

public class DaoTest {
	@Test
	public void findCustomerByIdDaoTest(){
		ApplicationContext act = 
		    new ClassPathXmlApplicationContext("applicationContext.xml");
          // 根据容器中Bean的id来获取指定的Bean
	     CustomerDao customerDao = 
                              (CustomerDao) act.getBean("customerDao");
//	     CustomerDao customerDao = act.getBean(CustomerDao.class);
		 Customer customer = customerDao.findCustomerById(1);
		 System.out.println(customer);
	}
}
```
