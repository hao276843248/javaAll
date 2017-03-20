package cn.hao.book.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import cn.hao.book.dao.BookDAOImpl;
import cn.hao.book.dao.IBookDAO;
import cn.hao.book.entity.Book;

public class BookTest {
	
	@Test
	public void DeleteBook() throws ParseException{
		//����Book���󣬷�װҪ���������
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate=sdf.parse("2000-04-1");
		Book book=new Book("Orcale���ݿ�", "��2",122, pubDate,"�ӱ���ѧ������");		
		//����DAO���󣬱���ͼ��
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.addBook(book);
	}
	
	@Test
	public void testUpdateBook()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate=sdf.parse("2015-06-30");
		Book book=new Book(1,"Java������������", "����,����",105, pubDate,"�廪��ѧ������");
		
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.updateBook(book);
	}
	
	@Test
	public void testDeleteBook(){
		IBookDAO bookDAO=new BookDAOImpl();
		bookDAO.deleteBook(1);
	}
	
	@Test
	public void testGetBook(){
		IBookDAO bookDAO=new BookDAOImpl();
		Book book=bookDAO.getBook(1);
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
