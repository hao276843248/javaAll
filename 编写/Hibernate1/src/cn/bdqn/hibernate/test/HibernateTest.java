package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.User;
import cn.bdqn.hibernate.util.HibernateUtil;

public class HibernateTest {
	
	//���Ի�ȡSession
	@Test
	public void testGetSession(){
		Session session=HibernateUtil.getSession();
		System.out.println(session);
		session.close();
	}
	
	//���Ա���User
	@Test
	public void testSaveUser(){
		User user=new User();
		user.setLoginName("tom");
		user.setPassword("654321");
		
		Session session=null;
		Transaction tx=null;
		try {
			//���session
			session=HibernateUtil.getSession();
			//��������
			tx=session.beginTransaction();
			//��������
			session.save(user);
			//�ύ����
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}

	//���Ը���User
	@Test
	public void testUpdateUser(){
		User user=new User();
		user.setId(2);
		user.setLoginName("tom");
		user.setPassword("abc123");
		
		Session session=null;
		Transaction tx=null;
		try {			
			session=HibernateUtil.getSession();			
			tx=session.beginTransaction();
			//��������
			session.update(user);			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();			
			tx.rollback();
		}
		finally{
			session.close();
		}		
		
		
		
		
		
		
	}
	
	//���Ը���id���ص���User����
	@Test
	public void testGetUser(){
		User user=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//����id��������
			user=(User)session.get(User.class,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(user.getId());
		System.out.println(user.getLoginName());
		System.out.println(user.getPassword());
	}

	//���Բ�ѯȫ���û��б�
	@Test
	public void testListUser(){
		List<User> users=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//����HQL��ѯ
			Query query=session.createQuery("from User order by id");
			//ִ�в�ѯ
			users=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(User user:users){
			System.out.println(user.getId());
			System.out.println(user.getLoginName());
			System.out.println(user.getPassword());
			System.out.println("--------------");
		}
	}
	
	//���Ը���idɾ���û�
	@Test
	public void testDeleteUser(){
		User user=new User();
		user.setId(2);
		
		Session session=null;
		Transaction tx=null;
		try {			
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			//ɾ������
			session.delete(user);
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









