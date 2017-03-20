package cn.bdqn.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import cn.bdqn.mybatis.entity.User;
import cn.bdqn.mybatis.util.MyBatisUtil;

public class UserTest {

	//����ִ��insert�������û�
	@Test	
	public void testAddUser()throws Exception{
		User user=new User();
		user.setLoginName("tom");
		user.setPassword("654321");
				
		SqlSession session=null;
		try {
			//���session,���Զ��ύ����
			session=MyBatisUtil.openSession();
			//ִ��insert���
			session.insert("user.addUser", user);
			//�ύ����
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			session.rollback();
		}
		finally{
			//�ر���Դ
			session.close();
		}		
	}
	
	//����ִ��select������id���ص����û�
	@Test
	public void testGetUser(){
		User user=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			//ִ��select�����ص����û�
			user=session.selectOne("user.getUser",1);			
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
	
	//����ִ��select����ѯ�û��б�
	@Test
	public void testFindUser(){
		List<User> users=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			//ִ��select����ѯ�û��б�
			users=session.selectList("user.findUser");			
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
			System.out.println("-----------------");
		}
	}
	
	//����ִ��update�������û�
	@Test
	public void testUpdateUser(){
		User user=new User();
		user.setId(2);
		user.setLoginName("tom");
		user.setPassword("abc123");
		
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			session.update("user.updateUser", user);			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally{
			session.close();
		}	
	}
	
	//����ִ��delete������idɾ���û�
	@Test
	public void testDeleteUser(){
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			session.update("user.delUser",2);			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		finally{
			session.close();
		}	
	}

}
