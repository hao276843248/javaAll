

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
			//����������
			conn=DBHelper.getConnection();
			String sql="SELECT s.id AS ���,s.name AS ����,s.grade AS �꼶,s.birthday AS ���� FROM Student s ORDER BY s.id";
			stmt=conn.createStatement();
			//ִ��INSERT��䣬������Ӱ������
			res=stmt.executeQuery(sql);
			System.out.println(11);
			while(res.next()){
				int id=res.getInt("���");
				String name=res.getString("����");
				Date brithday=res.getDate("����");
				int grade=res.getInt("�꼶");
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(brithday);
				System.out.println(grade);
				System.out.println("-----");
			}
		} catch (SQLException e) {			
			System.out.println("�������ݿ�ʱ��������:"+e.getMessage());
		}
		finally{
			DBHelper.clossAll(conn,stmt,res);
		}
	}
}





