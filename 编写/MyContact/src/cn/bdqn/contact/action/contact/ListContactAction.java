package cn.bdqn.contact.action.contact;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.util.PageBean;

@Controller("listContactAction")
@Scope("prototype")
public class ListContactAction extends BaseAction{
	
	//分页参数
	private int pageIndex=1;
	private int pageSize=2;
	
	//查询条件
	private Integer groupId;
	private String name;
	
	//分页结果
	private PageBean p;
	
	@Override
	public String execute() throws Exception {
		User user=(User)sessionMap.get(USER_SESSION_KEY);		
		p=contactService.findContact(pageIndex, pageSize, user.getId(), groupId, name);
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

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PageBean getP() {
		return p;
	}

	public void setP(PageBean p) {
		this.p = p;
	}
	
	
}
