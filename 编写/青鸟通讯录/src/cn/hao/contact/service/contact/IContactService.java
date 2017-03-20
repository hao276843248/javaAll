package cn.hao.contact.service.contact;


import java.util.List;

import cn.hao.contact.entity.Contact;
import cn.hao.contact.util.PageBean;

public interface IContactService {


	public Contact getContact(int id);
	
	public PageBean listContact(Integer uid,Integer gid , String name,int pageIndex, int pageSize);
	
	public void delete(int id);
	
	public void addContact(Contact contact);
	
	public void updateContact(Contact contact);
	
	public List<Contact> findContact(Integer userId);
	
}
