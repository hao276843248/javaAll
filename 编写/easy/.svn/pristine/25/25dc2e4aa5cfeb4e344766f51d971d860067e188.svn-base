package cn.hao.easybuy.controller.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.form.LoginForm;

@RequestMapping("/")
@Controller
public class LoginController extends ControllerBean{


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

		EasybuyUser user=userService.getUsers(loginForm.getUserName());
		
		if(result.hasErrors()){
			return "login";
		}
		
		if(user==null){
			result.rejectValue("userName","invalid.userName");
			return "login";
		}
		if(!user.getEuPassword().equals(loginForm.getPassword())){
			result.rejectValue("password","invalid.password");
			return "login";
		}
		
		
		session.setAttribute("user", user);
		return "redirect:index.html";
	
	}
}
