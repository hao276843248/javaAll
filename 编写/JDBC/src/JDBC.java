import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC {
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			//���������࣬����������DriverManagerע��
			Class.forName("oracle.jdbc.OracleDriver");			
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","ok");
			String sql="INSTER INTO EMP values()";
		
			System.out.println("���ӻ�ȡ�ɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("���������ʧ��");
		} catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʱ��������");
		}
		finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("�ر�����ʱ��������");
				}
			}
		}
	}
}
