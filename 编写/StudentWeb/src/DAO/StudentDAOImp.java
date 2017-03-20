package DAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import util.PageBean;
import cn.bdqn.jdbc.DBHelper;
import entity.Student;
import entity.user;

public class StudentDAOImp implements IStudentDAO{

	
	public void addSudent(Student student) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("INSERT INTO STUDENT(ID,NAME,GENDER,NIANJI,MIMA,DIANHUA,SHENGRI,DIZHI,PIC) VALUES"+
			"(SEQ_STUDENT.NEXTVAL,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getGender());
			pstmt.setString(3, student.getNianji());
			pstmt.setString(4, student.getMima());
			pstmt.setString(5, student.getDianhua());
			pstmt.setDate(6,new Date(student.getShengri().getTime()));
			pstmt.setString(7, student.getDizhi());
			pstmt.setString(8, student.getPic());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}
	public List<Student> findStudent() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List<Student> ss=new ArrayList<Student>();
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT ID,NAME,GENDER,NIANJI,MIMA,DIANHUA,SHENGRI,DIZHI,PIC FROM STUDENT ORDER BY ID");
			res=pstmt.executeQuery();
			while(res.next()){
				Student s=new Student();
				s.setId(res.getInt("id"));
				s.setName(res.getString("NAME"));
				s.setGender(res.getString("GENDER"));
				s.setNianji(res.getString("NIANJI"));
				s.setMima(res.getString("MIMA"));
				s.setDianhua(res.getString("DIANHUA"));
				s.setShengri(res.getDate("SHENGRI"));
				s.setDizhi(res.getString("DIZHI"));
				s.setPic(res.getString("PIC"));
				ss.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return ss;
	}

	public Student getStudent(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Student s=new Student();
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT ID,NAME,GENDER,NIANJI,MIMA,DIANHUA,SHENGRI,DIZHI,PIC FROM STUDENT where id=? ORDER BY ID");
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next()){
				s.setId(res.getInt("id"));
				s.setName(res.getString("NAME"));
				s.setGender(res.getString("GENDER"));
				s.setNianji(res.getString("NIANJI"));
				s.setMima(res.getString("MIMA"));
				s.setDianhua(res.getString("DIANHUA"));
				s.setShengri(res.getDate("SHENGRI"));
				s.setDizhi(res.getString("DIZHI"));
				s.setPic(res.getString("PIC"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return s;
	}

	public void updateStudent(Student s) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("UPDATE STUDENT SET NAME=?,GENDER=?,NIANJI=?,MIMA=?,DIANHUA=?,SHENGRI=?,DIZHI=?,pic=?  where id=?");
			pstmt.setString(1,s.getName());
			pstmt.setString(2,s.getGender());
			pstmt.setString(3,s.getNianji());
			pstmt.setString(4,s.getMima());
			pstmt.setString(5,s.getDianhua());
			pstmt.setDate(6,new Date(s.getShengri().getTime()));
			pstmt.setString(7,s.getDizhi());
			pstmt.setString(8, s.getPic());
			pstmt.setInt(9,s.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	public void deleteStudent(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("delete from Student where id=?");
			pstmt.setInt(1,id);
			pstmt.executeQuery();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	public user getLoginName(String loginName) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		user u=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("Select id,loginname,password from users where loginName=?" );
			pstmt.setString(1,loginName);
			res=pstmt.executeQuery();
			while(res.next()){
				u=new user();
				u.setId(res.getInt("id"));
				u.setLoginName(res.getString("loginname"));
				u.setPassword(res.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return u;
	}
	@Override
	public PageBean findStudent(int pageIndex, int pageSize, String title) {
		PageBean p=new PageBean();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String countSql="SELECT COUNT(*) FROM STUDENT";
			pstmt=conn.prepareStatement(countSql);
			res=pstmt.executeQuery();
			while(res.next()){
				//获得总行数
				int rowCount=res.getInt(1);
				//计算总页数
				int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
				//计算第一行行号和最后一行行号
				int first=(pageIndex-1)*pageSize+1;
				int last=pageIndex*pageSize;
				//查询分页列表
				String sql="SELECT T.* FROM" +
						"(SELECT ROW_NUMBER() OVER(ORDER BY ID) AS RN,ID,NAME,GENDER,NIANJI,MIMA,DIANHUA,SHENGRI,DIZHI,PIC FROM STUDENT)T"
						+" WHERE T.RN BETWEEN ? AND ?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, first);
				pstmt.setInt(2, last);
				res=pstmt.executeQuery();
				List<Student> result=new ArrayList<Student>();
				while(res.next()){
					Student s=new Student();
					s.setId(res.getInt("id"));
					s.setName(res.getString("NAME"));
					s.setGender(res.getString("GENDER"));
					s.setNianji(res.getString("NIANJI"));
					s.setMima(res.getString("MIMA"));
					s.setDianhua(res.getString("DIANHUA"));
					s.setShengri(res.getDate("SHENGRI"));
					s.setDizhi(res.getString("DIZHI"));
					s.setPic(res.getString("PIC"));
					result.add(s);
				}
				//将分页参数和结果列表封装到pageBean中
				p.setPageIndex(pageIndex);
				p.setPageSize(pageSize);
				p.setRowCount(rowCount);
				p.setPageCount(pageCount);
				p.setResult(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

}
