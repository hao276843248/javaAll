package cn.hao.cms.service.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.hao.cms.entity.User;
import cn.hao.cms.mapper.user.UserMapper;
import cn.hao.cms.util.MyBatisUtil;

public class UserServiceImpl implements IUserService{
	private Logger logger=Logger.getLogger(User.class);
	public User getUser(String userName){
		User user=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			user=mapper.getUser(userName);
		} catch (Exception e) {
			logger.error("��õ����û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return user;
	}

	@Override
	public List<User> findUser(String userName){
		List<User> users=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			users=mapper.findUser(userName);
		} catch (Exception e) {
			logger.error("����û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return users;
	}

	@Override
	public void delUser(int id) {
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			mapper.delUser(id);
			session.commit();
		} catch (Exception e) {
			logger.error("ɾ���û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public User getOneUser(int id) {
		User u=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			u=mapper.getOneUser(id);
			session.commit();
		} catch (Exception e) {
			logger.error("���һ���û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return u;
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
			logger.error("����û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
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
			logger.error("�޸��û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public User getUserold(String name) {
		User u=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			UserMapper mapper=session.getMapper(UserMapper.class);
			u=mapper.getUserold(name);
			session.commit();
		} catch (Exception e) {
			logger.error("��þ��û�ʱ��������",e);
			session.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return u;
	}
}
