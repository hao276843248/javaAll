package cn.bdqn.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import cn.bdqn.book.entity.User;
import cn.bdqn.jdbc.DBHelper;

public class JDBCUserDAOImpl implements IUserDAO{
	private Logger logger=Logger.getLogger(JDBCUserDAOImpl.class);
	@Override
	public User getUser(String loginName) {
		User user=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT id,loginName,password FROM Users WHERE loginName=?");
			pstmt.setString(1,loginName);
			res=pstmt.executeQuery();
			if(res.next()){
				user=new User();
				user.setId(res.getInt("id"));
				user.setLoginName(res.getString("loginName"));
				user.setPassword(res.getString("password"));
			}
		} catch (Exception e) {
			logger.error("根据登录名查询用户时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return user;
	}
	
	

}
