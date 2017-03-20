import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class test {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT ID,NAME,PASSWORD FROM USERS";
			stmt=conn.createStatement();
			res=stmt.executeQuery(sql);
			System.out.println(1111);
			while(res.next()){
				String a=res.getString(1);
				String b=res.getString(2);
				String c=res.getString(3);
				
				System.out.println(a+"  "+b+"  "+c);
			}
			System.out.println(11111);
		} catch (Exception e) {
			System.out.println("操作数据库时发生错误:"+e.getMessage());
		}
		finally{
			DBHelper.clossAll(conn, stmt, res);
			
		}
		
		
	}
}
