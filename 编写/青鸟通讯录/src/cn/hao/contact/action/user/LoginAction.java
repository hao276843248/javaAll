package cn.hao.contact.action.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.code.kaptcha.Constants;
import com.opensymphony.xwork2.ActionContext;

import cn.hao.contact.action.BaseAcrtion;
import cn.hao.contact.entity.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAcrtion {

	
	private String userName;
	private String password;
	//private String vcode;
	
	@Override
	public void validate() {
		System.out.println(getVcode());
		System.out.println(sessionMap.get("KAPTCHA_SESSION_KEY"));
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute("KAPTCHA_SESSION_KEY"));
		//String realVcode=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
	}
	
	@Override
	public String execute() throws Exception {
		User user=userService.getUser(userName);
		if(user==null){
			addFieldError("userName", getText("username.invalid"));
			return INPUT;
		}else if(!user.getPassword().equals(password)){
			addFieldError("password",getText("password.invalid"));
			return INPUT;			
		}
		else{
			sessionMap.put(USER_SESSION_KEY,user);
			return SUCCESS;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

/*	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}*/
	
	
	
}















