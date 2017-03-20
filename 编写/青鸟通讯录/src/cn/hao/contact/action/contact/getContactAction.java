package cn.hao.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.Contact;

@Controller("getAction")
@Scope("prototype")
public class getContactAction extends BaseAcrtion{
	private int id;
	private String view="edit";
	@Override
	public String execute() throws Exception {
		ValueStack stack=ActionContext.getContext().getValueStack();
		Contact contact=contactService.getContact(id);
		stack.push(contact);
		return SUCCESS;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
