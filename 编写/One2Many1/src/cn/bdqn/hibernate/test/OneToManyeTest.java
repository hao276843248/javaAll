package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class OneToManyeTest {

	//���Ա��������
	@Test
	public void testSavePublisher(){
		Publisher publisher=new Publisher("�廪��ѧ������");
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
	
	//���Ա���ͼ��
	@Test
	public void testSaveBook(){
		Book book=new Book(1,"����","��ͨJava", 80, "1.jpg");
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
	
	//���Լ�������������ͼ��
	@Test
	public void testSavePublisherAndBook(){
		Publisher publisher=new Publisher("���ӹ�ҵ������");
		Book book=new Book(1,"����","��ͨJSP",6,"3.jpg");
		//����������ϵ
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
	
	//����id��ȡ������
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
	
	//��ѯ�������б�
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









