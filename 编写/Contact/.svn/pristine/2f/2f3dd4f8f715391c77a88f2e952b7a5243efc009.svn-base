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


import cn.bdqn.contact.form.RegistForm;
import cn.bdqn.contact.service.user.IUserService;

@RequestMapping("/")
@Controller
public class RegistController {

	private IUserService userService;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("registForm")
	public RegistForm getRegistForm(){
		return new RegistForm();
	}
	
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String  regist(){
		return "regist";
	}
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(
			@Valid @ModelAttribute("registForm")RegistForm registForm,
			BindingResult result,
			HttpSession session
	){
		String reaVcode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String password=registForm.getPassword();
		String rePwd=registForm.getRePwd();
		String vcode=registForm.getVcode();
		
		
		if(StringUtils.isNotEmpty(rePwd) && !rePwd.equals(password)){
			result.rejectValue("rePwd","invalid.rePwd");
		}
		if(StringUtils.isNotEmpty(vcode) &&!vcode.equals(reaVcode)){
			result.rejectValue("vcode","invalid.vcode");
		}
		if(result.hasErrors()){
			return "regist";
		}
		
		//保存用户
		userService.addUser(registForm.getUser());
		//重定向到登录页面
		return "redirect:login.html";
	}
}
