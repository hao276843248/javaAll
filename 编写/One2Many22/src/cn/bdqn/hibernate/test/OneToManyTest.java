package cn.bdqn.hibernate.test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class OneToManyTest {

	//������������缰�������ͼ��
	@Test
	public void testSavePublisherAndBook(){
		Publisher publisher=new Publisher();
		publisher.setName("ˮ��������");
		
		Book book=new Book("����","��ͨPhotoShopͼ�δ���",90,"12.jpg");
		
		//����˫�����
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





