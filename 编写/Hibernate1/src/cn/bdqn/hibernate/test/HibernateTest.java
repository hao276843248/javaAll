package cn.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.bdqn.hibernate.entity.User;
import cn.bdqn.hibernate.util.HibernateUtil;

public class HibernateTest {
	
	//测试获取Session
	@Test
	public void testGetSession(){
		Session session=HibernateUtil.getSession();
		System.out.println(session);
		session.close();
	}
	
	//测试保存User
	@Test
	public void testSaveUser(){
		User user=new User();
		user.setLoginName("tom");
		user.setPassword("654321");
		
		Session session=null;
		Transaction tx=null;
		try {
			//获得session
			session=HibernateUtil.getSession();
			//启动事务
			tx=session.beginTransaction();
			//保存数据
			session.save(user);
			//提交事务
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			tx.rollback();
		}
		finally{
			session.close();
		}		
	}

	//测试更新User
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
			//更新数据
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
	
	//测试根据id加载单个User对象
	@Test
	public void testGetUser(){
		User user=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//根据id加载数据
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

	//测试查询全部用户列表
	@Test
	public void testListUser(){
		List<User> users=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			//创建HQL查询
			Query query=session.createQuery("from User order by id");
			//执行查询
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
	
	//测试根据id删除用户
	@Test
	public void testDeleteUser(){
		User user=new User();
		user.setId(2);
		
		Session session=null;
		Transaction tx=null;
		try {			
			session=HibernateUtil.getSession();
			tx=session.beginTransaction();
			//删除数据
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









