package cn.bdqn.cms.service.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.bdqn.cms.entity.User;
import cn.bdqn.cms.mapper.user.UserMapper;
import cn.bdqn.cms.util.MyBatisUtil;

public class UserServiceImpl implements IUserService{
	
	private Logger logger=Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public User getUserByName(String userName) {
		User user=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			user=mapper.getUserByName(userName);
		} catch (Exception e) {
			logger.error("根据用户名获取用户数据时发生错误",e);
		}
		finally{
			session.close();
		}
		return user;
	}
	
	@Override
	public List<User> findUser(String userName) {
		List<User> users=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			users=mapper.findUser("%"+userName+"%");
		} catch (Exception e) {
			logger.error("根据用户名获取用户数据时发生错误",e);
		}
		finally{
			session.close();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			user=mapper.getUserById(id);
		} catch (Exception e) {
			logger.error("根据ID获取用户数据时发生错误",e);
		}
		finally{
			session.close();
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			mapper.addUser(user);
			session.commit();
		} catch (Exception e) {
			logger.error("添加用户时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public void updateUser(User user) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			mapper.updateUser(user);
			session.commit();
		} catch (Exception e) {
			logger.error("更新用户时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}

	@Override
	public void deleteUser(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			mapper.deleteUser(id);
			session.commit();
		} catch (Exception e) {
			logger.error("删除用户时发生错误",e);
			session.rollback();
		}
		finally{
			session.close();
		}
	}
	
}






