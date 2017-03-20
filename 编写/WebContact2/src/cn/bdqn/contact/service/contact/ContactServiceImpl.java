package cn.bdqn.contact.service.contact;

import java.util.List;

import cn.bdqn.contact.dao.contact.ContactDAOImpl;
import cn.bdqn.contact.dao.contact.IContactDAO;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.PageBean;

public class ContactServiceImpl implements IContactService {
	
	private IContactDAO contactDAO ;
	

	public void setContactDAO(IContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);

	}

	@Override
	public PageBean listContact(int pageIndex, int pageSize, String name,
			Integer uid, Integer gid) {
		return contactDAO.listContact(pageIndex, pageSize, name, uid, gid);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
		
	}

	@Override
	public Contact getContact(Integer id) {
		return contactDAO.getContact(id);
	}

	@Override
	public void deleteContact(Integer id) {
		contactDAO.deleteContact(id);
		
	}

	@Override
	public List<Contact> findContact(Integer userId) {
		
		return contactDAO.findContact(userId);
	}

}
