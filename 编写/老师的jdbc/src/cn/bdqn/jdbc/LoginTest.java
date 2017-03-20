package cn.bdqn.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("ÇëÊäÈëÓÃ»§Ãû");
		String name=input.nextLine();
		System.out.println("ÇëÊäÈëÃÜÂë");
		String password=input.nextLine();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet res=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT COUNT(*) FROM Users WHERE name='"+name+"' AND password='"+password+"'";
			System.out.println(sql);
			
			stmt=conn.createStatement();
			res=stmt.executeQuery(sql);
			if(res.next()){
				int rowCount=res.getInt(1);
				if(rowCount>0){
					System.out.println("µÇÂ¼³É¹¦");
				}
				else{
					System.out.println("µÇÂ¼Ê§°Ü");
				}
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeAll(conn, stmt, res);
		}
		
		
		
		
	}
}
















