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
		//处理文件上传，获得新文件名
		String fileName=upload();
		//设置照片文件名
		contact.setPhoto(fileName);
		
		//获得当前登录的用户对象
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		//设置用户
		contact.setUser(user);
		
		
		contactService.addContact(contact);
		return SUCCESS;
	}

}










