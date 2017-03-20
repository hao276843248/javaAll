package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class ManyToOneTest {

	//保存图书
	@Test
	public void testSaveBook(){
		//创建图书对象，封装要保存的图书数据
		Book book=new Book("赵六","精通SQLServer",67,"11.jpg");
		//创建出版社对象，设置编号
		Publisher publisher=new Publisher();
		publisher.setId(2);
		//设置图书关联的出版社对象
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
	
	//根据id加载图书
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

	//使用内连接查询获取图书及其关联的出版社信息
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
	
	//使用迫切内连接查询获取图书及其关联的出版社信息
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










