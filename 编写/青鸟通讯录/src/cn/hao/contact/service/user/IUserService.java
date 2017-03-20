package cn.hao.contact.service.user;

import cn.hao.contact.entity.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public User getUser(String userName);
	
	public void updatePassword(User user);
}
