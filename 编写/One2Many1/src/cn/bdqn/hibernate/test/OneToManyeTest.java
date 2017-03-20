package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class OneToManyeTest {

	//测试保存出版社
	@Test
	public void testSavePublisher(){
		Publisher publisher=new Publisher("清华大学出版社");
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(publisher);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}
	
	//测试保存图书
	@Test
	public void testSaveBook(){
		Book book=new Book(1,"张三","精通Java", 80, "1.jpg");
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}
	
	//测试级联保存出版社和图书
	@Test
	public void testSavePublisherAndBook(){
		Publisher publisher=new Publisher("电子工业出版社");
		Book book=new Book(1,"王五","精通JSP",6,"3.jpg");
		//建立关联关系
		publisher.getBooks().add(book);
		
		Session session=null;
		Transaction tx=null;
		try {
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			session.save(publisher);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally{
			session.close();
		}
	}
	
	//根据id获取出版社
	@Test
	public void testGetPublisher(){
		Publisher publisher=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			publisher=(Publisher)session.get(Publisher.class,1);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(publisher.getId());
		System.out.println(publisher.getName());
		
		for(Book book:publisher.getBooks()){
			System.out.println(book.getTitle());
		}
		
		
		
		
		
		
	}
	
	//查询出版社列表
	@Test
	public void testFindPublisher(){
		List<Publisher> publishers=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			publishers=session.createQuery("from Publisher order by id").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Publisher publisher:publishers){
			System.out.println(publisher.getId());
			System.out.println(publisher.getName());
			
			for(Book book:publisher.getBooks()){
				System.out.println(book.getTitle());
			}
			System.out.println("--------------");
		}
		
	}

}









