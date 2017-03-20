import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBHelper {
	public static final String KEY_DRIVER_CLASS="driver_class";
	public static final String KEY_URL="url";
	public static final String KEY_USER="user";
	public static final String KEY_PASSWORD="password";
	
	public static String url;
	public static String user;
	public static String password;
	static{
		try {
			ConfigManager cfg=ConfigManager.getInstancs();
			String driverClass=cfg.getString(KEY_DRIVER_CLASS);
			url=cfg.getString(KEY_URL);
			user=cfg.getString(KEY_USER);
			password=cfg.getString(KEY_PASSWORD);
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;	
	}
	
	
	public static void clossAll(Connection conn,Statement stmt,ResultSet res){
		if(res!=null){
			try {
				res.close();
			} catch (SQLException e) {
				System.out.println("关闭结果集发生错误");
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("关闭语句时发生错误");
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("关闭连接时发生错误:"+e.getMessage());
			}
		}
	}
}