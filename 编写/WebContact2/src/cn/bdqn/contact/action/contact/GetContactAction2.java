package cn.bdqn.contact.action.contact;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;

public class GetContactAction2 extends BaseAction {
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		Contact contact =contactService.getContact(id);
		//System.out.println(contact.getPhoto());
		ValueStack stack =ActionContext.getContext().getValueStack();
		stack.push(contact);
		return SUCCESS;
	}

}
