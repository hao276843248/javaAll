package cn.bdqn.book.service;

import java.util.List;

import cn.bdqn.book.dao.BookDAOImpl;
import cn.bdqn.book.dao.IBookDAO;
import cn.bdqn.book.entity.Book;
import cn.bdqn.book.util.Context;
import cn.bdqn.book.util.PageBean;

public class BookServiceImpl implements IBookService{

	private IBookDAO bookDAO=new BookDAOImpl();
	
	@Override
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDAO.deleteBook(id);		
	}

	@Override
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	@Override
	public List<Book> findBook(String title) {
		return bookDAO.findBook(title);
	}
	
	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		System.out.println("BookServiceImpl Ïß³ÌÃû³Æ:"+Thread.currentThread().getName());
		System.out.println(Context.get());
		return bookDAO.findBook(pageIndex, pageSize, title);
	}
	
	

}
