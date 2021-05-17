��Java���ṩ�� java.util.Properties �࣬����ȡ .properties �����ļ����ڳ������ Properties ��� load() ����ʱ��ϵͳ�� .properties �����ļ������ݼ��ص��ڴ��С���Ϊ Properties ��̳��� Hashtable �࣬Properties ��ѡ�=��֮������ݣ���ӵ�Hashtable ����� key ֵ����ͬʱ��� key ֵ��Ӧ�� value ֵ��Ҳ���ǡ�=���Ҳ��ֵ�������ڱ�д .properties �����ļ�ʱһ��Ҫ�á�=���Ű�������ֵ�ָ�����

ͨ�� .properties ��������ʽֻ�ܱ��� String ������Ϣ��

Properties �����̰߳�ȫ�ģ�����߳̿��Թ���һ��Properties���󣬶�����Ҫ�ⲿͬ����

ʹ�� db.properties �ļ��������ݿ���������
ʾ����ʹ�� db.properties �ļ��������ݿ��������ԣ���ʵ�ֶ�MySQL���ݿ�����ӡ�

��1������Ŀ��Ĭ��·����srcĿ¼���´��� db.properties �����ļ�������дMySQL�������ӵ����������Ϣ��
```properties
DRIVER_CLASS=com.mysql.cj.jdbc.Driver
DB_URL=jdbc:mysql://localhost:3306/db_admin?serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf8&useSSL=false
DB_USER=root
DB_PASSWORD=123456
```

��2����д��ȡ db.properties �����ļ���Ϣ����ʵ�ֶ�MySQL���ݿ�����ӡ�
```java
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
/**
 * ʹ�� db.properties �ļ��������ݿ��������ԣ�<br />
 * ��ʵ�ֶ�MySQL���ݿ������
 * 
 * @author pan_junbiao
 *
 */
public class ConnTest
{
	private static String DRIVER_CLASS; // ���ݿ�����
	private static String DB_URL; // ���ݿ����ӵ�ַ
	private static String DB_USER; // ���ݿ��û�����
	private static String DB_PASSWORD; // ���ݿ��û�����
 
	public static void main(String[] args)
	{
		try
		{
			// ����Properties�����
			Properties properties = new Properties();
 
			// ��ȡproperties�����ļ�����������
			InputStream is = PropertiesTest.class.getResourceAsStream("/db.properties");
 
			// ���������м��������б�
			properties.load(is);
 
			// ��ȡ���ݿ���������ֵ
			DRIVER_CLASS = properties.getProperty("DRIVER_CLASS");
			DB_URL = properties.getProperty("DB_URL");
			DB_USER = properties.getProperty("DB_USER");
			DB_PASSWORD = properties.getProperty("DB_PASSWORD");
 
			// �������ݿ�������
			Class.forName(DRIVER_CLASS);
			System.out.println("���ݿ��������سɹ�");
 
			// ��ȡ���ݿ����Ӷ���
			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("���ݿ����ӳɹ�");
 
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