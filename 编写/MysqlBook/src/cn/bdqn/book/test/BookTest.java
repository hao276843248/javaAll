package cn.bdqn.book.test;

import java.util.List;

import org.junit.Test;

import cn.bdqn.book.dao.JDBCBookDAOImpl;
import cn.bdqn.book.dao.IBookDAO;
import cn.bdqn.book.entity.Book;
import cn.bdqn.book.util.PageBean;

public class BookTest {

	@Test
	public void testFindBook(){
		IBookDAO bookDAO=new JDBCBookDAOImpl();
		PageBean p=bookDAO.findBook(1,3,"精通");
		
		System.out.println("页号:"+p.getPageIndex());
		System.out.println("每页行数:"+p.getPageSize());
		System.out.println("总行数:"+p.getRowCount());
		System.out.println("总页数:"+p.getPageCount());
		
		List<Book> results=p.getResults();
		for (Book book:results) {
			System.out.println(book.getId()+"\t"+book.getTitle());
		}
		
		
	}
	
}








