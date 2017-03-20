import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			//加载驱动类，让驱动类向DriverManager注册
			Class.forName("oracle.jdbc.OracleDriver");			
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","ok");
			String sql="INSTER INTO EMP values()";
		
			System.out.println("连接获取成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动类加载失败");
		} catch (SQLException e) {
			System.out.println("获取数据库连接时发生错误");
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("关闭连接时发生错误");
				}
			}
		}
	}
}
