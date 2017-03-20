package cn.bdqn.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.util.PageBean;
import cn.bdqn.jdbc.DBHelper;

public class JDBCBookDAOImpl implements IBookDAO {
	
	private Logger logger=Logger.getLogger(JDBCBookDAOImpl.class);

	@Override
	public void addBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("INSERT INTO Book(id,author,title,publisher,price,pic) VALUES(SEQ_BOOK.nextval,?,?,?,?,?)");
			pstmt.setString(1,book.getAuthor());
			pstmt.setString(2,book.getTitle());
			pstmt.setString(3,book.getPublisher());
			pstmt.setDouble(4,book.getPrice());
			pstmt.setString(5,book.getPic());
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("保存图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn,pstmt,null);			
		}		
	}

	@Override
	public void updateBook(Book book) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("UPDATE Book SET author=?,title=?,publisher=?,price=?,pic=? WHERE id=?");
			pstmt.setString(1,book.getAuthor());
			pstmt.setString(2,book.getTitle());
			pstmt.setString(3,book.getPublisher());
			pstmt.setDouble(4,book.getPrice());
			pstmt.setString(5,book.getPic());
			pstmt.setInt(6,book.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("更新图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn,pstmt,null);			
		}		
	}

	@Override
	public void deleteBook(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("DELETE FROM Book WHERE id=?");
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.error("删除图书时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn,pstmt,null);			
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
			pstmt=conn.prepareStatement("SELECT id,author,title,publisher,price,pic FROM Book WHERE id=?");
			pstmt.setInt(1,id);
			res=pstmt.executeQuery();
			if(res.next()){
				book=new Book();
				book.setId(res.getInt("id"));
				book.setAuthor(res.getString("author"));
				book.setTitle(res.getString("title"));
				book.setPublisher(res.getString("publisher"));
				book.setPrice(res.getDouble("price"));
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
	public List<Book> findBook(String title) {
		List<Book> books=new ArrayList<Book>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			pstmt=conn.prepareStatement("SELECT id,author,title,publisher,price,pic FROM Book WHERE title LIKE ?");
			pstmt.setString(1,"%"+title+"%");
			res=pstmt.executeQuery();
			while(res.next()){
				Book book=new Book();
				book.setId(res.getInt("id"));
				book.setAuthor(res.getString("author"));
				book.setTitle(res.getString("title"));
				book.setPublisher(res.getString("publisher"));
				book.setPrice(res.getDouble("price"));
				book.setPic(res.getString("pic"));
				books.add(book);
			}					
		} catch (Exception e) {
			logger.error("查询图书列表时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);			
		}		
		return books;
	}
	
	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		PageBean pageBean=new PageBean();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		try {
			conn=DBHelper.getConnection();
			//查询总行数
			String countSql="SELECT COUNT(*) FROM BOOK WHERE title LIKE ?";
			pstmt=conn.prepareStatement(countSql);
			pstmt.setString(1,"%"+title+"%");
			res=pstmt.executeQuery();
			if(res.next()){
				//获得总行数
				int rowCount=res.getInt(1);
				//计算总页数
				int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
				//计算第一行行号和最后一行行号
				int first=(pageIndex-1)*pageSize+1;
				int last=pageIndex*pageSize;
				//查询分页列表
				String listSql="SELECT t.* FROM "+
							   "(SELECT ROW_NUMBER() OVER(ORDER BY id DESC) AS rn,id,title,author,publisher,price,pic FROM Book WHERE title LIKE ?) t "+
							   "WHERE t.rn BETWEEN ? AND ?";
				
				pstmt=conn.prepareStatement(listSql);
				pstmt.setString(1,"%"+title+"%");
				pstmt.setInt(2,first);
				pstmt.setInt(3,last);
				
				res=pstmt.executeQuery();
				List<Book> results=new ArrayList<Book>();
				while(res.next()){
					Book book=new Book();
					book.setId(res.getInt("id"));
					book.setAuthor(res.getString("author"));
					book.setTitle(res.getString("title"));
					book.setPublisher(res.getString("publisher"));
					book.setPrice(res.getDouble("price"));
					book.setPic(res.getString("pic"));
					results.add(book);
				}
				
				//将分页参数和结果列表封装到pageBean中
				pageBean.setPageIndex(pageIndex);
				pageBean.setPageSize(pageSize);
				pageBean.setRowCount(rowCount);
				pageBean.setPageCount(pageCount);
				pageBean.setResults(results);				
			}			
		} catch (Exception e) {
			logger.error("分页查询图书列表时发生错误",e);
		}
		finally{
			DBHelper.closeAll(conn, pstmt, res);
		}

		return pageBean;
	}

}










