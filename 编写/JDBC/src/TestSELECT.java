

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestSELECT {
	public static void main(String[] args) {
		Connection conn=null;	
		Statement stmt=null;
		ResultSet res=null;
		try {
			//加载驱动类
			conn=DBHelper.getConnection();
			String sql="SELECT s.id AS 编号,s.name AS 姓名,s.grade AS 年级,s.birthday AS 生日 FROM Student s ORDER BY s.id";
			stmt=conn.createStatement();
			//执行INSERT语句，返回受影响行数
			res=stmt.executeQuery(sql);
			System.out.println(11);
			while(res.next()){
				int id=res.getInt("编号");
				String name=res.getString("姓名");
				Date brithday=res.getDate("生日");
				int grade=res.getInt("年级");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(brithday);
				System.out.println(grade);
				System.out.println("-----");
			}
		} catch (SQLException e) {			
			System.out.println("操作数据库时发生错误:"+e.getMessage());
		}
		finally{
			DBHelper.clossAll(conn,stmt,res);
		}
	}
}





