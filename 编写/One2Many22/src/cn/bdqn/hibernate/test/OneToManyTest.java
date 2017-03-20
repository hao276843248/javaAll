package cn.bdqn.hibernate.test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class OneToManyTest {

	//级联保存出版社及其关联的图书
	@Test
	public void testSavePublisherAndBook(){
		Publisher publisher=new Publisher();
		publisher.setName("水利出版社");
		
		Book book=new Book("赵六","精通PhotoShop图形处理",90,"12.jpg");
		
		//建立双向关联
		publisher.getBooks().add(book);
		book.setPublisher(publisher);
		
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
	
	
}





