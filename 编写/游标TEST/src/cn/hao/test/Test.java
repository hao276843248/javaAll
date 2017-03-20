package cn.hao.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;


import cn.bdqn.jdbc.DBHelper;

public class Test {
	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement cstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			cstmt=conn.prepareCall("{call sp_find_emp(?,?,?)}");
			cstmt.setInt(1, 20);
			cstmt.setString(2,"O");
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.execute();
			
			res=(ResultSet)cstmt.getObject(3);
			while(res.next()){
				int empno=res.getInt("EMPNO");
				String ename=res.getString("ENAME");
				int sal=res.getInt("SAL");
				System.out.println(empno);
				System.out.println(ename);
				System.out.println(sal);
				System.out.println("-------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			DBHelper.closeAll(conn, cstmt, res);
		}
	}
}
