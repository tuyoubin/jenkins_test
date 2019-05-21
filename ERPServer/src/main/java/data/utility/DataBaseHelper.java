package data.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 * @author CharlieLei
 *
 */
public class DataBaseHelper {
	
	public static Connection getDataBaseConnection(String dataBaseName){		
		Connection connection = null;	
		try{
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+ dataBaseName +"?useUnicode=true&characterEncoding=utf-8&useSSL=false",
					"root","123456");
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
