package cn.bdqn.contact.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	private UserMapper mapper;
	
	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void addUser(User user) {
		mapper.saveUser(user);
	}
	
	@Override
	public User getUser(String userName) {
		return mapper.getUser(userName);
	}
	
	@Override
	public void updatePassword(Integer userId, String newPwd) {
		mapper.updatePassword(userId, newPwd);
	}
	

}
