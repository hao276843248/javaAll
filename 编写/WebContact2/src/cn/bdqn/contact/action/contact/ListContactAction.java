package cn.bdqn.contact.action.contact;

import java.util.List;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.util.PageBean;

public class ListContactAction extends BaseAction {
	
	//分页参数
	//页号
	private int pageIndex=1;
	//每页行数
	private int pageSize=1;
	//查询条件
	private String name;
	private Integer groupId;
	
	//查询结果
	private PageBean p;
	
	@Override
	public String execute() throws Exception {
		User user=(User)sessionMap.get(USER_SESSION_KEY);
		p=contactService.listContact(pageIndex, pageSize, name, user.getId(), groupId);
		/*List<Contact> contacts =p.getResults();
		for(Contact contact:contacts){
			System.out.println(contact.getName()+"-"+contact.getPhone());
		}*/
		return SUCCESS;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public PageBean getP() {
		return p;
	}

	public void setP(PageBean p) {
		this.p = p;
	}
	
	
	

}
