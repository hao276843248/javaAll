package cn.bdqn.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;

@Controller("deleteContactAction")
@Scope("prototype")
public class DeleteContactAction extends BaseAction{
	
	private Integer id;
	
	@Override
	public String execute() throws Exception {
		contactService.deleteContact(id);
		return SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
