package cn.hao.contact.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hao.contact.service.contact.ContactServiceImpl;
import cn.hao.contact.service.contact.IContactService;
import cn.hao.contact.service.group.GroupServiceImpl;
import cn.hao.contact.service.group.IGroupService;
import cn.hao.contact.service.user.IUserService;
import cn.hao.contact.service.user.UserService;

import com.opensymphony.xwork2.ActionSupport;



public class BaseAcrtion extends ActionSupport implements SessionAware,RequestAware{
	public static final String USER_SESSION_KEY="user";
	
	protected IUserService userService;
	protected IGroupService groupService;
	protected IContactService contactService;
	
	protected Map<String, Object> sessionMap;
	protected Map<String, Object> requestMap;
	private  String vcode;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}


	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}


	

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;
		
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	

}
