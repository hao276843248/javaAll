package cn.bdqn.book.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.bdqn.book.dao.BookDAOImpl;
import cn.bdqn.book.dao.IBookDAO;
import cn.bdqn.book.entity.Book;

public class BookTest {

	//���Ա���ͼ�����
	@Test
	public void testAddBook()throws Exception{
		//����Book���󣬷�װҪ���������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate=sdf.parse("2015-06-20");
		Book book=new Book("Java���������", "����",95, pubDate,"�廪��ѧ������");
		//����DAO���󣬱���ͼ��
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.addBook(book);
	}
	
	
	@Test
	public void testUpdateBook()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate=sdf.parse("2015-06-30");
		Book book=new Book(4,"Java������������", "����,����",105, pubDate,"�廪��ѧ������");
		
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.updateBook(book);
	}
	
	@Test
	public void testDeleteBook(){
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBook(4);
	}
	
	@Test
	public void testGetBook(){
		IBookDAO bookDAO=new BookDAOImpl();
		Book book=bookDAO.getBook(2);
		if(book!=null){
			System.out.println(book.getId());
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor());
			System.out.println(book.getPrice());
			System.out.println(book.getPubDate());
			System.out.println(book.getPublisher());
		}
	}
	
	@Test
	public void testFindBook(){
		IBookDAO bookDAO=new BookDAOImpl();
		List<Book> books=bookDAO.findBook();
		for(Book book:books){
			System.out.println(book.getId());
			System.out.println(book.getTitle());
			System.out.println(book.getAuthor());
			System.out.println(book.getPrice());
			System.out.println(book.getPubDate());
			System.out.println(book.getPublisher());
			System.out.println("-------------------------");
		}
	}
	
}









