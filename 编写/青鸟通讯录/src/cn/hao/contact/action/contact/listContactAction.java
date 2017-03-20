package cn.hao.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.User;
import cn.hao.contact.util.PageBean;


@Controller("listAction")
@Scope("prototype")
public class listContactAction extends BaseAcrtion{
	
	private String name;
	private Integer groupID;
	//分页参数
	//页号
	private int pageIndex=1;
	//每页行数
	private int pageSize=5;
	
	private PageBean p;
	@Override
	public String execute() throws Exception {
		User user=(User) sessionMap.get(USER_SESSION_KEY);
		p=contactService.listContact(user.getId(), groupID, name, pageIndex, pageSize);
		return SUCCESS;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGroupID() {
		return groupID;
	}
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
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
	public PageBean getP() {
		return p;
	}
	public void setP(PageBean p) {
		this.p = p;
	}
	
	
}
