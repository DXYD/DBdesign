（1） @RestController注解是@controller和@ResponseBody的合集，表示这个控制器，并且是将方法的返回值直接放入到HTTP响应体中，是REST风格的控制器；

（2） @RequestMapping是一个用来处理请求地址映射的注解，可以用在类和方法上

（3） @RequestBody和@RequestParam区别

@RequestBody可以用来解析json字符串（还可以解析xml）,并将字符串映射到对应的实体中，实体字段名和json中的键名要对应，注意提交请求的时候要在请求头指定content-type为application/json charset=utf-8

问题描述：

由于项目是前后端分离，因此后台使用的是spring boot，做成微服务，只暴露接口。接口设计风格为restful的风格，在get请求下，后台接收参数的注解为RequestBody时会报错；在post请求下，后台接收参数的注解为RequestParam时也会报错

问题原因：

由于spring的RequestParam注解接收的参数是来自于requestHeader中，即请求头，也就是在url中，格式为xxx?username=123&password=456，而RequestBody注解接收的参数则是来自于requestBody中，即请求体中。

解决方法：

如果为get请求时，后台接收参数的注解应该为RequestParam，如果为post请求时，则后台接收参数的注解就是为RequestBody

（4） @PathVariable注解

通过@PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable("xxx") 绑定到操作方法的入参中

v2-df883db9a1b16268eadab2bc7241401c_b.jpg
（5） 在dao层使用较多的注解：@Param

@Param注解的作用是给参数命名，参数命名后就能根据名称得到参数值，正确的将参数传入sql语句中

实例一：@Param注解单一属性

Public User selectUser(@param(“userName”) String name,@param(“userpassword”) String password);

xml映射：

<select id=" selectUser" resultMap="BaseResultMap">

select * from user_user_t where user_name = #{userName，jdbcType=VARCHAR} and user_password=#{userPassword,jdbcType=VARCHAR}

</select>

采用#{}的方式把@Param注解括号内的参数进行引用（括号内参数对应的是形参如 userName对应的是name）

实例二：@Param注解JavaBean对象

public List<user> getUserInformation(@Param("user") User user);