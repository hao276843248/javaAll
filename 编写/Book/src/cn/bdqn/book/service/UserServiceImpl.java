package cn.bdqn.book.service;

import cn.bdqn.book.dao.BookDAOImpl;
import cn.bdqn.book.dao.UserDAOImpl;
import cn.bdqn.book.dao.IUserDAO;
import cn.bdqn.book.entity.User;

public class UserServiceImpl implements IUserService{
	
	private IUserDAO userDAO=new UserDAOImpl();
	
	@Override
	public User getUser(String loginName) {
		return userDAO.getUser(loginName);
	}

}
