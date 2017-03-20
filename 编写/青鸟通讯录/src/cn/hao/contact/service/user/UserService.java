package cn.hao.contact.service.user;

import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.contact.dao.user.UserDAOImpl;
import cn.hao.contact.entity.User;

@Service("userService")
public class UserService implements IUserService {
	
	private UserDAOImpl userDao;
	
	@Autowired
	public void setUserDao(UserDAOImpl userDao) {
		this.userDao = userDao;
	}
	@Override
	public User getUser(String userName) {
		
		return userDao.getUser(userName);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public void updatePassword(User user) {
		userDao.updatePassword(user);
	}

}
