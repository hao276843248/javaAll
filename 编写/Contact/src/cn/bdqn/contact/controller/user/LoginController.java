package cn.bdqn.contact.controller.user;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;


import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.form.LoginForm;
import cn.bdqn.contact.service.user.IUserService;

@RequestMapping("/")
@Controller
public class LoginController {

	private IUserService userService;
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("loginForm")
	public LoginForm loginForm(){
		return new LoginForm();	
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public  String getLoginForm(){
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(
			@Valid @ModelAttribute("loginForm")LoginForm loginForm,
			BindingResult result,
			HttpSession session
	){
		String reaVcode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String vcode=loginForm.getVcode();
		User user=userService.getUser(loginForm.getUserName());
		
		if(result.hasErrors()){
			return "login";
		}
		
		if(user==null){
			result.rejectValue("userName","invalid.userName");
			return "login";
		}
		if(!user.getPassword().equals(loginForm.getPassword())){
			result.rejectValue("password","invalid.password");
			return "login";
		}
		if(StringUtils.isNotEmpty(vcode) &&!vcode.equals(reaVcode)){
			result.rejectValue("vcode","invalid.vcode");
			return "login";
		}
		
		session.setAttribute("user", user);
		return "redirect:background/index.html";
	
	}
}
