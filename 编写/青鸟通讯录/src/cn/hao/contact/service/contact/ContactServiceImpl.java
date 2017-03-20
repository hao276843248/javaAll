package cn.hao.contact.service.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hao.contact.dao.contact.ContactDAOImpl;
import cn.hao.contact.dao.contact.IContactDAO;
import cn.hao.contact.entity.Contact;
import cn.hao.contact.util.PageBean;

@Service("contactService")
public class ContactServiceImpl implements IContactService{

	private IContactDAO ic;
	
	@Autowired
	public void setIc(IContactDAO ic) {
		this.ic = ic;
	}
	@Override
	public Contact getContact(int id) {
		return ic.getContact(id);
	}

	@Override
	public PageBean listContact(Integer uid,Integer gid, String name,int pageIndex, int pageSize) {
		return ic.listContact(uid,gid, name,pageIndex,  pageSize);
	}

	@Override
	public void delete(int id) {
		ic.delete(id);
	}

	@Override
	public void addContact(Contact contact) {
		ic.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		ic.updateContact(contact);
	}

	@Override
	public List<Contact> findContact(Integer userId) {
		return ic.findContact(userId);
	}


}
