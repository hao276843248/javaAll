package cn.bdqn.contact.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.contact.dao.contact.ContactDAOImpl;
import cn.bdqn.contact.dao.contact.IContactDAO;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.util.PageBean;

@Service
public class ContactServiceImpl implements IContactService{
	
	private IContactDAO contactDAO;
	
	@Autowired
	public void setContactDAO(IContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}
	
	@Override
	public PageBean findContact(int pageIndex, int pageSize, Integer userId,
			Integer groupId, String name) {
		return contactDAO.findContact(pageIndex, pageSize, userId, groupId, name);
	}

	@Override
	public Contact getContact(Integer id) {
		return contactDAO.getContact(id);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
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
