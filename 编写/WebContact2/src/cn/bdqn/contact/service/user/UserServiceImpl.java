package cn.bdqn.contact.service.user;

import cn.bdqn.contact.dao.user.IUserDAO;
import cn.bdqn.contact.dao.user.UserDAOImpl;
import cn.bdqn.contact.entity.User;

public class UserServiceImpl implements IUserService{
	
	private IUserDAO userDAO;
	
	
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
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}
	
	

}
