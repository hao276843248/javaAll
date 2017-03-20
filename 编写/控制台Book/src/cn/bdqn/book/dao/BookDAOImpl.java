package cn.bdqn.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.book.entity.Book;
import cn.bdqn.jdbc.DBHelper;

public class BookDAOImpl implements IBookDAO{

	private Logger logger=Logger.getLogger(BookDAOImpl.class);
	
	@Override
	public void addBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="INSERT INTO Book(id,title,author,price,pubDate,Publisher) VALUES(SEQ_BOOK.nextval,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setDouble(3,book.getPrice());
			//��java.util.Dateת��Ϊjava.sql.Date
			Date pubDate=new Date(book.getPubDate().getTime());			
			pstmt.setDate(4,pubDate);
			pstmt.setString(5,book.getPublisher());
			
			//ִ��INSERT���
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("����ͼ��ʱ��������",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
		
	}

	@Override
	public void updateBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="UPDATE Book SET title=?,author=?,price=?,pubDate=?,publisher=? WHERE id=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setDouble(3,book.getPrice());
			//��java.util.Dateת��Ϊjava.sql.Date
			Date pubDate=new Date(book.getPubDate().getTime());			
			pstmt.setDate(4,pubDate);
			pstmt.setString(5,book.getPublisher());
			pstmt.setInt(6,book.getId());

			//ִ��UPDATE���
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("����ͼ��ʱ��������",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	@Override
	public void deleteBook(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="DELETE FROM Book WHERE id=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			//ִ��DELETE���
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("ɾ��ͼ��ʱ��������",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	@Override
	public Book getBook(int id) {
		Book book=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT id,title,author,price,pubDate,publisher FROM Book WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);			
			res=pstmt.executeQuery();
			if(res.next()){
				book=new Book();
				book.setId(res.getInt("id"));
				book.setTitle(res.getString("title"));
				book.setAuthor(res.getString("author"));
				book.setPrice(res.getDouble("price"));
				book.setPubDate(res.getDate("pubDate"));
				book.setPublisher(res.getString("publisher"));			
			}			
		} catch (Exception e) {
			logger.error("����id��ȡͼ��ʱ��������",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		
		return book;
	}

	@Override
	public List<Book> findBook() {
		List<Book> books=new ArrayList<Book>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT id,title,author,price,pubDate,publisher FROM Book ORDER BY id";
			pstmt=conn.prepareStatement(sql);						
			res=pstmt.executeQuery();
			while(res.next()){
				Book book=new Book();
				book.setId(res.getInt("id"));
				book.setTitle(res.getString("title"));
				book.setAuthor(res.getString("author"));
				book.setPrice(res.getDouble("price"));
				book.setPubDate(res.getDate("pubDate"));
				book.setPublisher(res.getString("publisher"));
				
				books.add(book);				
			}			
		} catch (Exception e) {
			logger.error("����id��ȡͼ��ʱ��������",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		
		return books;		
	}

}












