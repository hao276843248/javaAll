package cn.bdqn.book.service;

import java.util.List;

import cn.bdqn.book.entity.Book;

public interface IBookService {
	
	//添加图书
	public void addBook(Book book);
	
	//更新图书
	public void updateBook(Book book);
	
	//删除图书
	public void deleteBook(int id);
	
	//根据ID查找单条图书信息
	public Book getBook(int id);
	
	//查找全部数据
	public List<Book> findBook();
}
