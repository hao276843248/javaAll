package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class ManyToOneTest {

	//����ͼ��
	@Test
	public void testSaveBook(){
		//����ͼ����󣬷�װҪ�����ͼ������
		Book book=new Book("����","��ͨSQLServer",67,"11.jpg");
		//����������������ñ��
		Publisher publisher=new Publisher();
		publisher.setId(2);
		//����ͼ������ĳ��������
		book.setPublisher(publisher);
		
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
	
	//����id����ͼ��
	@Test
	public void testGetBook(){
		Book book=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			book=(Book)session.get(Book.class,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(book.getTitle());
		System.out.println(book.getPublisher().getId());
		System.out.println(book.getPublisher().getName());
	}

	//ʹ�������Ӳ�ѯ��ȡͼ�鼰������ĳ�������Ϣ
	@Test
	public void testInnerJoin(){
		List<Object[]> rows=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String hql="from Book b inner join b.publisher order by b.id";
			rows=session.createQuery(hql).list();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for(Object[] row:rows){
			Book book=(Book)row[0];
			Publisher publisher=(Publisher)row[1];
			System.out.println(book.getTitle()+"\t"+publisher.getName());
			
		}
		
	}
	
	//ʹ�����������Ӳ�ѯ��ȡͼ�鼰������ĳ�������Ϣ
	@Test
	public void testInnerJoinFetch(){
		List<Book> books=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			String hql="from Book b inner join fetch b.publisher order by b.id";
			books=session.createQuery(hql).list();						
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for (Book book:books) {
			System.out.println(book.getTitle()+"\t"+book.getPublisher().getName());
		}
	}
	
}










