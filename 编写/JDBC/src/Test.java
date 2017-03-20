import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Test {
	public static void main(String[] args) {
		Statement stmt=null;
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","tom","ok");
			String sql="INSERT INTO Student VALUES(1,'����',TO_DATE('1995-07-24','YYYY-MM-DD'),2)";	
			stmt=conn.createStatement();
			int rows=stmt.executeUpdate(sql);
			if(rows==1){
				System.out.println("������ӳɹ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("���������ʧ��:"+e.getMessage());
		} catch (SQLException e) {			
			System.out.println("�������ݿ�ʱ��������:"+e.getMessage());
		}
		finally{
				if(stmt!=null){
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						System.out.println("�ر�����ʱ��������:"+e.getMessage());
					}
				}
			
		}

	}

	
}	
