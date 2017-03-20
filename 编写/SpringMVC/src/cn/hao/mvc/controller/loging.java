package cn.hao.mvc.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import cn.hao.mvc.form.LoginForm;

@RequestMapping("/")
@Controller
public class loging {

	// 当以get方式访问/login。html时，显示表单视图
	@RequestMapping(value = "login3", method = RequestMethod.GET)
	public ModelAndView login() {	
		//显示表但是控制器需要在模型中放入一个Java对象，该对象用来控制表单初始化数据
		return new  ModelAndView("login").addObject("loginform",new LoginForm());
	}

	// 当以post方式访问/login.html时，处理表单提交的数据
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(String loginName, String password) {
		System.out.println(loginName);
		System.out.println(password);
		return "seccess";
	}

	// 1.当以post方式访问/login.html时，处理表单提交的数据
	// 参数名不一致加RequestParam注解
	@RequestMapping(value = "login1", method = RequestMethod.POST)
	public String do1Login(@RequestParam("loginName") String Name,
			@RequestParam("password") String pwd) {
		System.out.println(Name);
		System.out.println(pwd);
		return "seccess";
	}

	// 2.当以post方式访问/logiHn.html时，处理表单提交的数据
	// 参数名太多时可以定义一个参对象传入对象
	@RequestMapping(value = "login2", method = RequestMethod.POST)
	public String do2Login(@Valid @ModelAttribute("loginform")LoginForm loginForm,
			BindingResult result) {
		if(!loginForm.getLoginName().equals("hao")){
			result.addError(new FieldError("loginform", "loginName", "用户名错误"));
			return "login";
		}else if (!loginForm.getPassword().equals("123")) {
			result.addError(new FieldError("loginform", "password", "密码错误"));
			return "login";
		}		
		
		System.out.println(loginForm.getLoginName());
		System.out.println(loginForm.getPassword());
		return "redirect:seccess.html";
	}

	// 3.当以post方式访问/logiHn.html时，处理表单提交的数据
		// 参数名太多时可以定义一个参对象传入对象
		//将信息保存到session中
		@RequestMapping(value = "login3", method = RequestMethod.POST)
		public String do3Login(
				@Valid @ModelAttribute("loginform")LoginForm loginForm,
				BindingResult result
				,HttpSession session
				) {
			
			if(result.hasErrors()){
				return "login";
			}
			
			if(!loginForm.getLoginName().equals("hao")){
				result.rejectValue("loginName","invalid.loginName");
				return "login";
			}else if (!loginForm.getPassword().equals("123")) {
				result.rejectValue("password",null,"invalid.password");
				return "login";
			}
			session.setAttribute("userName",loginForm.getLoginName());
			System.out.println(loginForm.getLoginName());
			System.out.println(loginForm.getPassword());
			return "redirect:seccess.html";
		}
	

	@RequestMapping("seccess")
	public String seccess(){
		return "seccess";
	}
	
}
