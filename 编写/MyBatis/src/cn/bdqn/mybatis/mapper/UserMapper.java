package cn.bdqn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.mybatis.entity.User;

public interface UserMapper {

	//添加用户
	public void addUser(User user);
	
	//根据id获取用户
	public User getUser(int id);
	
	//查找全部用户
	public List<User> findUser();

	//更新用户
	public void updateUser(User user);
	
	//删除用户
	public void delUser(int id);
	
	//根据用户名和密码查询匹配记录的行数
	public int countUser(
		@Param("loginName")String loginName,
		@Param("password")String password	
	);
}







