package cn.hao.cms.mapper.user;

import java.util.List;

import cn.hao.cms.entity.User;

public interface UserMapper {
	public User getUser(String userName);
	
	public List<User> findUser(String userName);
	
	public User getOneUser(int id);
	
	public void delUser(int id);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUserold(String name);
}
