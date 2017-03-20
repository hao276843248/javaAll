package cn.hao.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.Contact;

@Controller("deleteAction")
@Scope("prototype")
public class detailContactAction extends BaseAcrtion{
	private int id;
	
	@Override
	public String execute() throws Exception {
		ValueStack stack=ActionContext.getContext().getValueStack();
		Contact contact=contactService.getContact(id);
		stack.push(contact);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
