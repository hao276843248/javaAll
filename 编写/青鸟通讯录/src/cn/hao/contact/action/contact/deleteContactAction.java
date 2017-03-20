package cn.hao.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hao.contact.action.BaseAcrtion;

@Controller("detailAction")
@Scope("prototype")
public class deleteContactAction extends BaseAcrtion{

	private int id;

	
	@Override
	public String execute() throws Exception {
		contactService.delete(id);
		return SUCCESS;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
