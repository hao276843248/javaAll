package cn.bdqn.cms.mapper.user;

import java.util.List;

import cn.bdqn.cms.entity.User;

public interface UserMapper {

	public User getUserByName(String userName);
	
	public List<User> findUser(String userName);
	
	public User getUserById(int id);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
}
