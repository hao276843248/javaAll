package cn.bdqn.contact.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.contact.dao.user.IUserDAO;
import cn.bdqn.contact.dao.user.UserDAOImpl;
import cn.bdqn.contact.entity.User;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	private IUserDAO userDAO;
	
	@Autowired
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}
	
	@Override
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}
	
	@Override
	public void updatePassword(Integer userId, String newPwd) {
		userDAO.updatePassword(userId, newPwd);
	}
	

}
