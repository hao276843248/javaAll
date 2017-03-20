package cn.hao.book.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hao.book.entity.User;
import cn.hao.book.util.HibernateUtil;

public class HibernateTest {
	
	@Test
	public void getSession(){
		Session s=HibernateUtil.getSession();
		System.out.println(s);
		s.close();
	}
	
	@Test
	public void adduser(){
		User u=new User();
		u.setLoginName("qwww");
		u.setPassword("111");
		
		Session s=null;
		Transaction tx=null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
		}finally{
			s.close();
		}
	}
	
	@Test
	public void updateuser(){
		User u=new User();
		u.setLoginName("hao");
		u.setId(3);
		u.setPassword("1");
		Transaction tx=null;
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			s.close();
		}
	}
	
	@Test
	public void getuser(){
		User u=new User();
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			u=(User)s.get(User.class, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		System.out.println(u.getId());
		System.out.println(u.getLoginName());
		System.out.println(u.getPassword());
	}

	@Test
	public void finduser(){
		List<User> us=null;
		Session s=null;
		try {
			s=HibernateUtil.getSession();
			Query q=(Query)s.createQuery("from User order by id");
			us=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		for(User u:us){
			System.out.println(u.getId());
			System.out.println(u.getLoginName());
			System.out.println(u.getPassword());
			System.out.println("--------------");
		}
	}

	@Test
	public void delectuser(){
		Session s=null;
		User u=new User();
		u.setId(8);
		Transaction tx=null;
		try {
			s=HibernateUtil.getSession();
			tx=s.beginTransaction();
			s.delete(u);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			
		}finally{
			s.close();
		}
	}


}
