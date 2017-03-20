package cn.hao.book.service;



import cn.hao.book.dao.BookDAO;
import cn.hao.book.dao.IBookDAO;
import cn.hao.book.entity.Book;
import cn.hao.book.entity.Users;
import cn.hao.book.util.PageBean;

public class BookServiceImpl implements IBookService{

	private IBookDAO DAO=new BookDAO();
	

	@Override
	public void addBook(Book book) {
		DAO.addBook(book);
		
	}

	@Override
	public Book getBookID(int id) {
	
		return DAO.getBookID(id);
	}

	@Override
	public void deleteBook(int id) {
		DAO.deleteBook(id);
		
	}

	@Override
	public void updateBook(Book book) {
		DAO.updateBook(book);
	}

	@Override
	public Users login(String loginName) {
	
		return DAO.login(loginName);
	}

	@Override
	public PageBean findBook(int pageIndex, int pageSize, String title) {
		return DAO.findBook(pageIndex, pageSize, title);
	}
	
}
