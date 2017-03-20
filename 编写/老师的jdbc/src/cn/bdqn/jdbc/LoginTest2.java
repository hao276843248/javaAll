package cn.bdqn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginTest2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�������û���");
		String name=input.nextLine();
		System.out.println("����������");
		String password=input.nextLine();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT COUNT(*) FROM Users WHERE name=? AND password=?";
			System.out.println(sql);
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			
			res=pstmt.executeQuery();
			if(res.next()){
				int rowCount=res.getInt(1);
				if(rowCount>0){
					System.out.println("��¼�ɹ�");
				}
				else{
					System.out.println("��¼ʧ��");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		
		
		
		
	}
}
















