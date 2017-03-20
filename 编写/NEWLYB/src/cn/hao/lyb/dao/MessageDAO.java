package cn.hao.lyb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.bdqn.jdbc.DBHelper;
import cn.hao.lyb.entity.Message;

public class MessageDAO implements IMessageDAO {

	@Override
	public void addMessage(Message message) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("INSERT INTO MESSAGE VALUes(SEQ_MESSAGE.NEXTVAL,?,?,?,?)");
			pstmt.setString(1, message.getName());
			pstmt.setString(2, message.getContent());
			pstmt.setString(3, message.getIp());
			pstmt.setTimestamp(4, new Timestamp(message.getDate().getTime()));
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
		
	}

	@Override
	public List<Message> findMessage() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List<Message> messages=new ArrayList<Message>();
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT ID,nickNAME,CONTENT,IP,ADDTIME FROM MESSAGE ORDER BY ID DESC");
			res=pstmt.executeQuery();
			while(res.next()){
				Message m=new Message();
				m.setId(res.getInt("id"));
				m.setName(res.getString("nickName"));
				m.setContent(res.getString("CONTENT"));
				m.setIp(res.getString("IP"));
				m.setDate(res.getTimestamp("addTIME"));
				messages.add(m);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return messages;
	}

	@Override
	public void deleteMessage(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("DELETE FROM MESSAGE WHERE id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}
	
}
