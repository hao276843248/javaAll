package cn.hao.dvd.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.jdbc.DBHelper;
import cn.hao.dvd.entity.DVD;

public class DVDDAOImpl implements IDVDDAO{
	
	public static Logger logger=Logger.getLogger(DVDDAOImpl.class);
	
	@Override
	public void addDVD(DVD dvd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="INSERT INTO DVD(ID,NAME,ZT,JieDate,CS,DAOYAN,GESHOU) VALUES(SEQ_DVD.nextval,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dvd.getName());
			pstmt.setString(2, dvd.getZt());
			
			Date jiedate=new Date(dvd.getJieDate().getTime());
			pstmt.setDate(3, jiedate);
			
			pstmt.setInt(4, dvd.getCs());
			pstmt.setString(5, dvd.getDaoyan());
			pstmt.setString(6, dvd.getGeshou());
	
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("保存DVD时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
		
	}

	@Override
	public void upDateDVD(DVD dvd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="UPDATE DVD SET NAME=?,ZT=?,JIEDATE=?,CS=?,DAOYAN=?,GESHOU=? WHERE ID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dvd.getName());
			pstmt.setString(2, dvd.getZt());
			
			Date jiedate=new Date(dvd.getJieDate().getTime());
			pstmt.setDate(3, jiedate);
			
			pstmt.setInt(4, dvd.getCs());
			pstmt.setString(5, dvd.getDaoyan());
			pstmt.setString(6, dvd.getGeshou());
			pstmt.setInt(7, dvd.getId());
	
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("更新DVD发生错误", e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	@Override
	public void deleteDVD(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="DELETE FROM DVD WHERE ID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("删除DVD发生错误", e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
		
	}

	@Override
	public DVD getDVD(int id) {
		DVD dvd=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT ID,NAME,ZT,JIEDATE,CS,DAOYAN,GESHOU FROM DVD WHERE ID=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			while(res.next()){
				dvd=new DVD();
				dvd.setId(id);
				dvd.setName(res.getString("NAME"));
				dvd.setZt(res.getString("ZT"));
				dvd.setJieDate(res.getDate("JIEDATE"));
				dvd.setCs(res.getInt("CS"));
				dvd.setDaoyan(res.getString("DAOYAN"));
				dvd.setGeshou(res.getString("GESHOU"));
			}
		} catch (Exception e) {
			logger.error("获取DVD发生错误", e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return dvd;
	}

	@Override
	public List<DVD> findDVD() {
		List<DVD> dvds=new ArrayList<DVD>();
		DVD dvd=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT ID,NAME,ZT,JIEDATE,CS,DAOYAN,GESHOU FROM DVD ORDER BY ID";
			pstmt=conn.prepareStatement(sql);
			res=pstmt.executeQuery();
			while(res.next()){
				dvd=new DVD();
				dvd.setId(res.getInt("id"));
				dvd.setName(res.getString("NAME"));
				dvd.setZt(res.getString("ZT"));
				dvd.setJieDate(res.getDate("JIEDATE"));
				dvd.setCs(res.getInt("CS"));
				dvd.setDaoyan(res.getString("DAOYAN"));
				dvd.setGeshou(res.getString("GESHOU"));
				
				dvds.add(dvd);
			}
		} catch (Exception e) {
			logger.error("获取DVD发生错误", e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return dvds;
	}
	
}
