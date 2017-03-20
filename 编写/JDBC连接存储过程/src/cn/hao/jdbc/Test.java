package cn.hao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Types;
import java.text.SimpleDateFormat;

import cn.bdqn.jdbc.DBHelper;

public class Test {
	public static void main(String[] args) {
		get();
	}
	public static void get(){
		Connection conn=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CallableStatement cstmt=null;
		try {
			conn=DBHelper.getConnection();
			cstmt=conn.prepareCall("{call sp_add_stu(?,?,?,?)}");
			cstmt.setString(1,"李四");
			cstmt.setString(2, "男");
			String c="1990-12-3";
			
			Date a=new Date(sdf.parse(c).getTime());
			cstmt.setDate(3, a);
			
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			
			cstmt.execute();
			int id=cstmt.getInt(4);
			System.out.println("调用成功");
			System.out.println(id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DBHelper.closeAll(conn, cstmt, null);
		}
	}
	
	public static void add(){
		Connection conn=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CallableStatement cstmt=null;
		try {
			conn=DBHelper.getConnection();
			cstmt=conn.prepareCall("{call sp_add(?,?,?)}");
			cstmt.setString(1,"李四");
			cstmt.setString(2, "男");
			String c="1990-12-3";
			
			Date a=new Date(sdf.parse(c).getTime());
			cstmt.setDate(3, a);
		
			cstmt.execute();
			System.out.println("调用成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DBHelper.closeAll(conn, cstmt, null);
		}
	}
	public static void delete(){
		Connection conn=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CallableStatement cstmt=null;
		try {
			conn=DBHelper.getConnection();
			cstmt=conn.prepareCall("{call sp_delet(?)}");
			cstmt.setInt(1,3);
			cstmt.execute();
			System.out.println("调用成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DBHelper.closeAll(conn, cstmt, null);
		}
	}
}
