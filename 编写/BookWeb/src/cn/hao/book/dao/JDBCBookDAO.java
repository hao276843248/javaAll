package cn.hao.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.jdbc.DBHelper;
import cn.hao.book.entity.Book;
import cn.hao.book.entity.Users;
import cn.hao.book.util.PageBean;

public class JDBCBookDAO implements JDBCIBookDAO{

	private Logger logger= Logger.getLogger(JDBCBookDAO.class);
	
	public Users login(String loginName) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		Users u=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("Select id,loginname,password from users where loginName=?" );
			pstmt.setString(1,loginName);
			res=pstmt.executeQuery();
			while(res.next()){
				u=new Users();
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
	
	public List<Book> findBook(String title) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		List<Book> books=new ArrayList<Book>();
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT id,author,title,publisher,price,pubdate,pic FROM Book WHERE title LIKE ? ORDER BY ID");
			pstmt.setString(1,"%"+title+"%");
			res=pstmt.executeQuery();
			while(res.next()){
				Book book=new Book();
				book.setId(res.getInt("id"));
				book.setTitle(res.getString("title"));
				book.setPrice(res.getDouble("PRICE"));
				book.setPubdate(res.getDate("pubdate"));
				//book.setPublisher(res.getString("PUBLISHER"));
				book.setAuthor(res.getString("AUTHOR"));
				book.setPic(res.getString("pic"));
				books.add(book);
			}
		} catch (Exception e) {
			logger.error(e);
		}finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			String sql="INSERT INTO Book(id,title,author,price,pubDate,Publisher,pic) VALUES(SEQ_BOOK.nextval,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setDouble(3,book.getPrice());
			//将java.util.Date转换为java.sql.Date
			Date pubDate=new Date(book.getPubdate().getTime());			
			pstmt.setDate(4,pubDate);
			//pstmt.setString(5,book.getPublisher());
			pstmt.setString(6, book.getPic());
			
			//执行INSERT语句
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("保存图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
	}

	@Override
	public Book getBookID(int id) {
		Book book=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String sql="SELECT id,title,author,price,pubDate,publisher,pic FROM Book WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);			
			res=pstmt.executeQuery();
			if(res.next()){
				book=new Book();
				book.setId(res.getInt("id"));
				book.setTitle(res.getString("title"));
				book.setAuthor(res.getString("author"));
				book.setPrice(res.getDouble("price"));
				book.setPubdate(res.getDate("pubDate"));
				//book.setPublisher(res.getString("publisher"));	
				book.setPic(res.getString("pic"));
			}			
		} catch (Exception e) {
			logger.error("根据id获取图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}
		
		return book;
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
			
			//执行DELETE语句
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("删除图书时发生错误",e);
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
			String sql="UPDATE Book SET title=?,author=?,price=?,pubDate=?,publisher=?,pic=? WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,book.getTitle());
			pstmt.setString(2,book.getAuthor());
			pstmt.setDouble(3,book.getPrice());
			//将java.util.Date转换为java.sql.Date
			Date pubDate=new Date(book.getPubdate().getTime());			
			pstmt.setDate(4,pubDate);
			//pstmt.setString(5,book.getPublisher());
			pstmt.setString(6, book.getPic());
			pstmt.setInt(7,book.getId());

			//执行UPDATE语句
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error("更新图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, null);
		}
		
	}

	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		PageBean pageBean=new PageBean();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			String countSql="Select  COUNT(*) FROM BOOK WHERE tItle like ?";
			pstmt=conn.prepareStatement(countSql);
			pstmt.setString(1,"%"+title+"%");
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
				String listsql="SELECT T.* FROM " +
						"(SELECT ROW_NUMBER() Over(ORDER BY ID DESC)AS RN,ID,TITLE,AUTHOR,PUBLISHER,PUBDATE,PRICE,PIC FROM BOOK WHERE TITLE LIKE ?)T " +
						"WHERE T.RN BETWEEN ? AND ?";
				pstmt=conn.prepareStatement(listsql);
				pstmt.setString(1, "%"+title+"%");
				pstmt.setInt(2, first);
				pstmt.setInt(3, last);
				res=pstmt.executeQuery();
				List<Book> result=new ArrayList<Book>();
				while(res.next()){
					Book book=new Book();
					book.setId(res.getInt("id"));
					book.setTitle(res.getString("title"));
					book.setPrice(res.getDouble("PRICE"));
					book.setPubdate(res.getDate("pubdate"));
					//book.setPublisher(res.getString("PUBLISHER"));
					book.setAuthor(res.getString("AUTHOR"));
					book.setPic(res.getString("pic"));
					result.add(book);
				}
				//将分页参数和结果列表封装到pageBean中
				pageBean.setPageIndex(pageIndex);
				pageBean.setPageSize(pageSize);
				pageBean.setRowCount(rowCount);
				pageBean.setPageCount(pageCount);
				pageBean.setResult(result);	
			}
			
		} catch (Exception e) {
			logger.error("分页查询出错", e);
		}
		return pageBean;
	}
}
