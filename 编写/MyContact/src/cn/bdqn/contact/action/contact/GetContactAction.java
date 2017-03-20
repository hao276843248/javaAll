package cn.bdqn.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;

@Controller("getContactAction")
@Scope("prototype")
public class GetContactAction extends BaseAction{
	
	private Integer id;
	private String view="edit";
	
	@Override
	public String execute() throws Exception {
		Contact contact=contactService.getContact(id);
		ActionContext.getContext().getValueStack().push(contact);
		return SUCCESS;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}

}
