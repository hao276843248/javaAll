package cn.bdqn.book.dao;

import cn.bdqn.book.entity.User;

public interface IUserDAO {

	public User getUser(String loginName);
	
}
