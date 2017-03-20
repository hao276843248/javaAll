package cn.hao.contact.dao.user;

import cn.hao.contact.entity.User;

public interface IUserDAO {
	public void addUser(User user);
	
	public User getUser(String userName);
	
	public void updatePassword(User user);
}
