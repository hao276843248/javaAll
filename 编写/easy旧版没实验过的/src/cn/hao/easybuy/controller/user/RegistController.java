package cn.hao.easybuy.controller.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.form.RegistForm;


@RequestMapping("/")
@Controller
public class RegistController extends ControllerBean{

		
	@ModelAttribute("registForm")
	public RegistForm registForm(){
		return new RegistForm();
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String  regist(){
		return "register";
	}
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String regist(
			@Valid @ModelAttribute("registForm")RegistForm registForm,
			BindingResult result,
			HttpSession session
	){
		
		String password=registForm.getPassWord();
		String rePwd=registForm.getRePassword();
	
		
		if(StringUtils.isNotEmpty(rePwd) && !rePwd.equals(password)){
			result.rejectValue("rePwd","invalid.rePwd");
			return "register";
		}
		
		if(result.hasErrors()){
			return "register";
		}
		EasybuyUser user=registForm.getUser();
		user.setEuUserId(registForm.getUserId());
		//保存用户
		userService.addUser(user);
		
		//重定向到登录页面
		return "redirect:login.html";
	}
}
