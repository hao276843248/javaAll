package cn.bdqn.contact.dao.user;

import cn.bdqn.contact.entity.User;

public interface IUserDAO {

	public void addUser(User user);
	
	public User getUser(String userName);
	
	//�޸�����
	public void updatePassword(Integer userId,String newPwd);
}
