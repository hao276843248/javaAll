package cn.bdqn.contact.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.bdqn.contact.service.contact.ContactServiceImpl;
import cn.bdqn.contact.service.contact.IContactService;
import cn.bdqn.contact.service.group.GroupServiceImpl;
import cn.bdqn.contact.service.group.IGroupService;
import cn.bdqn.contact.service.user.IUserService;
import cn.bdqn.contact.service.user.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware {
	public static final String USER_SESSION_KEY="user";
	
	//与请求作用域对应的Map集合
	protected Map<String, Object> requestMap;
	//与会话作用域对应的Map集合
	protected Map<String,Object> sessionMap;
	//用户模块业务逻辑层
	protected IUserService userService;
	
	protected IGroupService groupService ;
	
	protected IContactService contactService;
	
	private String vcode;
	

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap=sessionMap;

	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap=requestMap;

	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	
	

}
