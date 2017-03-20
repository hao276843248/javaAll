package cn.bdqn.contact.service.contact;

import java.util.List;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.PageBean;

public interface IContactService {
	
	public void addContact(Contact contact);
	
	public PageBean listContact(
			int pageIndex,
			int pageSize,
			String name,
			Integer uid,
			Integer gid
		);
	
	public void updateContact(Contact contact);
	
	public Contact getContact(Integer id);
	
	public void deleteContact(Integer id);
	public List<Contact> findContact(Integer userId);
}
