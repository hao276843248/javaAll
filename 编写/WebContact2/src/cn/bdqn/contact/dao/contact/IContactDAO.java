package cn.bdqn.contact.dao.contact;

import java.util.List;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.PageBean;

public interface IContactDAO {
	
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
	//�����û���Ż���û�ȫ����ϵ��
	public List<Contact> findContact(Integer userId);

}
