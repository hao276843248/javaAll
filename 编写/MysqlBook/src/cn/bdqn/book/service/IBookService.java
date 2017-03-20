package cn.bdqn.book.service;

import java.util.List;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.util.PageBean;

public interface IBookService {

	//添加图书
	public void addBook(Book book);
	
	//修改图书
	public void updateBook(Book book);
	
	//删除图书
	public void deleteBook(int id);
	
	//根据id获取单个图书
	public Book getBook(int id);
	
	//查询图书列表
	public List<Book> findBook(String title);
	
	//分页查询图书列表
	public PageBean findBook(int pageIndex,int pageSize,String title);
}
