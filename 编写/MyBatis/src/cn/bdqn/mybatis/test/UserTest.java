package cn.bdqn.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import cn.bdqn.mybatis.entity.User;
import cn.bdqn.mybatis.util.MyBatisUtil;

public class UserTest {

	//测试执行insert语句插入用户
	@Test	
	public void testAddUser()throws Exception{
		User user=new User();
		user.setLoginName("tom");
		user.setPassword("654321");
				
		SqlSession session=null;
		try {
			//获得session,不自动提交事务
			session=MyBatisUtil.openSession();
			//执行insert语句
			session.insert("user.addUser", user);
			//提交事务
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			session.rollback();
		}
		finally{
			//关闭资源
			session.close();
		}		
	}
	
	//测试执行select语句根据id加载单个用户
	@Test
	public void testGetUser(){
		User user=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			//执行select语句加载单个用户
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
	
	//测试执行select语句查询用户列表
	@Test
	public void testFindUser(){
		List<User> users=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			//执行select语句查询用户列表
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
	
	//测试执行update语句更新用户
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
	
	//测试执行delete语句根据id删除用户
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
