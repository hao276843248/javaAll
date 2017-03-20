package cn.bdqn.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.User;

@Controller("addContactAction")
@Scope("prototype")
public class AddContactAction extends BaseAction implements ModelDriven<Contact>{
	
	private Contact contact=new Contact();
	
	@Override
	public Contact getModel() {
		return contact;
	}
	
	@Override
	public String execute() throws Exception {
		//�����ļ��ϴ���������ļ���
		String fileName=upload();
		//������Ƭ�ļ���
		contact.setPhoto(fileName);
		
		//��õ�ǰ��¼���û�����
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		//�����û�
		contact.setUser(user);
		
		
		contactService.addContact(contact);
		return SUCCESS;
	}

}










