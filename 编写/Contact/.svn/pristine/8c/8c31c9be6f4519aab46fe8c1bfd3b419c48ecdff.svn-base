package cn.bdqn.contact.dao.contact;

import java.util.List;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.PageBean;

public interface IContactDAO {
	
	//添加联系人
	public void addContact(Contact contact);
	
	//查询联系人分页列表
	public PageBean findContact(int pageIndex,int pageSize,Integer userId,Integer groupId,String name);
	
	//根据id获取联系人
	public Contact getContact(Integer id);
	
	//更新联系人
	public void updateContact(Contact contact);
	
	//根据id删除联系人
	public void deleteContact(Integer id);
	
	//根据用户编号获得用户全部联系人
	public List<Contact> findContact(Integer userId);
	
	
}
















