package cn.bdqn.hibernate.test;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.Book;
import cn.bdqn.hibernate.entity.Publisher;
import cn.bdqn.hibernate.util.HibernateUtil;

public class ttttttt {
	@Test
	public void savebook(){
		Book b=new Book("²Á²Á", "dassawwwwwwwwww", 22, "1212.pic");
		Session s=null;
		Publisher p=new Publisher();
		p.setId(4);
		b.setPublisher(p);
		Transaction tx=null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.save(b);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
			
		}finally{
			s.close();
		}		
	}
	
	@Test
	public void getbook(){
		Book b=new Book();
		Session s=null;
		Publisher p=new Publisher();
		p.setId(4);
		b.setPublisher(p);
		Transaction tx=null;
		try {
			s=HibernateUtil.getSession();
			b=(Book)s.get(Book.class, 24);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			s.close();
		}
		System.out.println(b.getTitle());
		System.out.println(b.getPublisher().getId());
	}
}
