package cn.bdqn.contact.service.user;

import cn.bdqn.contact.entity.User;

public interface IUserService {
	
	public void addUser(User user);
	
	public User getUser(String userName);
	
	//ĞŞ¸ÄÃÜÂë
	public void updatePassword(Integer userId,String newPwd);
}
