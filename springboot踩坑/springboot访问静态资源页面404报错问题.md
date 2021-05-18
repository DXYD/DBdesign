Spring Boot 访问静态资源，默认有两个默认目录：

classpath/static 目录：src/mian/resource
ServletContext 根目录下： src/main/webapp
啥是 classpath呢 ?

这里简要的介绍下，classpath 即 WEB-INF 下面的 classes 目录 ，在 Spring Boot 项目中就是src/main/resource 目录。

2.1 classpath 目录下-访问默认文件夹名为 static

这里有人就想说，我可不可以修改一下访问路径呢，答案是肯定的，肯定可以。

在 properties文件里面设置 spring.resources.static-locations 就ok了。

spring.resources.static-locations 的默认值是：classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/

图示修改：我将默认路径改成了 src/main/resource/static/images/,在里面我写了一个 index.html 里面写的 html img

ServletContext 根目录下( src/main/webapp ) - webapp 就是默认访问文件夹
这个可能很多人就不陌生了，一般来说 src/main/java 里面放Java代码，resource 里面放配置文件, xml， webapp里面放页面，js之类的。

ServletContent 根目录就是 src/main/webapp

一般创建的maven项目里面都没有 webapp 文件夹，在这里我们自己在 src/main 目录下创建一个 webapp


三、Spring Boot 访问静态资源解决方案
上面知识点主要做些科普，至于如何在 Spring Boot 访问静态资源，可以通过以下两种方案来解决以上问题：

3.1 第一种方案（推荐）
修改 application.yml , 添加以下配置：

# 放开 Spring Boot 项目中 /static 目录下静态资源的拦截
spring:
  mvc:
    static-path-pattern: /static/**
application.properties 文件添加如下：

spring.mvc.static-path-pattern=/static/**
3.2 第二种方案
添加一个 WebMvcConfig.java 配置类，告诉 springboot 静态资源的加载路径:

```java
package com.exception.qms.config;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
/**
 * @author www.exception.site 异常教程
 * @date 2019/2/5
 * @time 14:37
 * @discription
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
```