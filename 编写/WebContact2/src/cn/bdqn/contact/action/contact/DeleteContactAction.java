package cn.bdqn.contact.action.contact;

import cn.bdqn.contact.action.BaseAction;

public class DeleteContactAction extends BaseAction {
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception {
		contactService.deleteContact(id);
		return SUCCESS;
	}

}
