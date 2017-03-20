package cn.hao.book.service;

import java.util.List;

import cn.hao.book.dao.BookDAOImpl;
import cn.hao.book.dao.IBookDAO;
import cn.hao.book.entity.Book;

public class BookServiceImpl implements IBookService {
	
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
	public List<Book> findBook() {
		return bookDAO.findBook();
	}
	
}
