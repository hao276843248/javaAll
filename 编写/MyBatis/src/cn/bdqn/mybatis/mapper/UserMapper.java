package cn.bdqn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.mybatis.entity.User;

public interface UserMapper {

	//����û�
	public void addUser(User user);
	
	//����id��ȡ�û�
	public User getUser(int id);
	
	//����ȫ���û�
	public List<User> findUser();

	//�����û�
	public void updateUser(User user);
	
	//ɾ���û�
	public void delUser(int id);
	
	//�����û����������ѯƥ���¼������
	public int countUser(
		@Param("loginName")String loginName,
		@Param("password")String password	
	);
}







