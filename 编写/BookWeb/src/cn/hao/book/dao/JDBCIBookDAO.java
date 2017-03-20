package cn.hao.book.dao;

import java.util.List;

import cn.hao.book.entity.Book;
import cn.hao.book.entity.Users;
import cn.hao.book.util.PageBean;

public interface JDBCIBookDAO {
	public List<Book> findBook(String title);
	
	//∑÷“≥≤È—Ø
	public PageBean findBook(int pageIndex,int pageSize,String title);
	
	public void addBook(Book book);
	
	public Book getBookID(int id);
	
	public void deleteBook(int id);
	
	public void updateBook(Book book);
	
	public Users login(String loginName);
}
