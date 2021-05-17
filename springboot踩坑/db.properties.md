在Java中提供了 java.util.Properties 类，来读取 .properties 属性文件。在程序调用 Properties 类的 load() 方法时，系统把 .properties 属性文件的内容加载到内存中。因为 Properties 类继承了 Hashtable 类，Properties 类把“=”之间的内容，添加到Hashtable 对象的 key 值，并同时添加 key 值对应的 value 值，也就是“=”右侧的值。所有在编写 .properties 属性文件时一定要用“=”号把名称与值分隔开。

通过 .properties 属性文形式只能保存 String 类型信息。

Properties 类是线程安全的，多个线程可以共享一个Properties对象，而不需要外部同步。

使用 db.properties 文件配置数据库连接属性
示例：使用 db.properties 文件配置数据库连接属性，并实现对MySQL数据库的连接。

（1）在项目的默认路径（src目录）下创建 db.properties 属性文件，并编写MySQL数据连接的相关配置信息。
```properties
DRIVER_CLASS=com.mysql.cj.jdbc.Driver
DB_URL=jdbc:mysql://localhost:3306/db_admin?serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf8&useSSL=false
DB_USER=root
DB_PASSWORD=123456
```

（2）编写获取 db.properties 属性文件信息，并实现对MySQL数据库的连接。
```java
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
/**
 * 使用 db.properties 文件配置数据库连接属性，<br />
 * 并实现对MySQL数据库的连接
 * 
 * @author pan_junbiao
 *
 */
public class ConnTest
{
	private static String DRIVER_CLASS; // 数据库驱动
	private static String DB_URL; // 数据库连接地址
	private static String DB_USER; // 数据库用户名称
	private static String DB_PASSWORD; // 数据库用户密码
 
	public static void main(String[] args)
	{
		try
		{
			// 创建Properties类对象
			Properties properties = new Properties();
 
			// 读取properties属性文件到输入流中
			InputStream is = PropertiesTest.class.getResourceAsStream("/db.properties");
 
			// 从输入流中加载属性列表
			properties.load(is);
 
			// 获取数据库连接属性值
			DRIVER_CLASS = properties.getProperty("DRIVER_CLASS");
			DB_URL = properties.getProperty("DB_URL");
			DB_USER = properties.getProperty("DB_USER");
			DB_PASSWORD = properties.getProperty("DB_PASSWORD");
 
			// 加载数据库驱动类
			Class.forName(DRIVER_CLASS);
			System.out.println("数据库驱动加载成功");
 
			// 获取数据库连接对象
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("数据库连接成功");
 
		} catch (ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		} catch (SQLException sqle)
		{
			sqle.printStackTrace();
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
```