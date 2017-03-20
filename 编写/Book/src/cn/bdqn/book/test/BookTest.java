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
		PageBean p=bookDAO.findBook(1,3,"��ͨ");
		
		System.out.println("ҳ��:"+p.getPageIndex());
		System.out.println("ÿҳ����:"+p.getPageSize());
		System.out.println("������:"+p.getRowCount());
		System.out.println("��ҳ��:"+p.getPageCount());
		
		List<Book> results=p.getResults();
		for (Book book:results) {
			System.out.println(book.getId()+"\t"+book.getTitle());
		}
		
		
	}
	
}








