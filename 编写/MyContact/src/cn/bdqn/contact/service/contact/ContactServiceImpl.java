package cn.bdqn.contact.service.contact;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bdqn.mybatis.plugin.PageParam;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.mapper.ContactMapper;
import cn.bdqn.contact.util.PageBean;

@Service("contactService")
public class ContactServiceImpl implements IContactService{
	
	private ContactMapper mapper;
	
	@Autowired
	public void setMapper(ContactMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public void addContact(Contact contact) {
		mapper.addContact(contact);
	}
	
	@Override
	public PageBean findContact(int pageIndex, int pageSize, Integer userId,
			Integer groupId, String name) {
		
		if(StringUtils.isEmpty(name)){
			name=null;
		}
		PageParam param=new PageParam(pageIndex, pageSize);
		List<Contact> results=mapper.findContact(param, userId, groupId, name);
		
		PageBean pageBean=new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(param.getRowCount());
		pageBean.setPageCount(param.getPageCount());
		pageBean.setResults(results);
		return pageBean;
	}

	@Override
	public Contact getContact(Integer id) {
		return mapper.getContact(id);
	}

	@Override
	public void updateContact(Contact contact) {
		mapper.updateContact(contact);
	}

	@Override
	public void deleteContact(Integer id) {
		mapper.deleteContact(id);
	}
	
	@Override
	public List<Contact> findContact(Integer userId) {
		return mapper.findAllContact(userId);
	}
	

}
