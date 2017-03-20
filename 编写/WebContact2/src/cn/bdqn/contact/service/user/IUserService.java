package cn.bdqn.contact.service.user;

import cn.bdqn.contact.entity.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public User getUser(String userName);
	
	public void updateUser(User user);
}
