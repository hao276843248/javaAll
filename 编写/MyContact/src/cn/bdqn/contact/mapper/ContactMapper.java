package cn.bdqn.contact.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bdqn.mybatis.plugin.PageParam;

import cn.bdqn.contact.entity.Contact;


public interface ContactMapper {

	public void addContact(Contact contact);
	
	public List<Contact> findContact(
			@Param("pageParam")PageParam param,
			@Param("userId")Integer userId,
			@Param("groupId")Integer groupId,
			@Param("name")String name
	);
	
	public List<Contact> findAllContact(Integer userId);
	
	public Contact getContact(Integer id);
	
	public void updateContact(Contact contact);
	
	public void deleteContact(Integer id);
}














