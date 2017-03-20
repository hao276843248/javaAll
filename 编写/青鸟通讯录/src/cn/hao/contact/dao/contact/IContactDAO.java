package cn.hao.contact.dao.contact;


import java.util.List;

import cn.hao.contact.entity.Contact;
import cn.hao.contact.util.PageBean;

public interface IContactDAO {

	public Contact getContact(int id);
	
	
	public PageBean listContact(Integer uid,Integer gid , String name,int pageIndex, int pageSize);
	
	public void delete(int id);
	
	public void addContact(Contact contact);
	
	public List<Contact> findContact(Integer userId);
	
	public void updateContact(Contact contact);
}
