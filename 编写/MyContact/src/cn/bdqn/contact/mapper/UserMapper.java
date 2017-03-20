package cn.bdqn.contact.mapper;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.contact.entity.User;

public interface UserMapper {

	public void saveUser(User user);
	
	public User getUser(String userName);
	
	public void updatePassword(
		@Param("userId")Integer userId,
		@Param("newPwd")String newPwd
	);
	
}
