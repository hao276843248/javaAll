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

	// ����get��ʽ����/login��htmlʱ����ʾ����ͼ
	@RequestMapping(value = "login3", method = RequestMethod.GET)
	public ModelAndView login() {	
		//��ʾ���ǿ�������Ҫ��ģ���з���һ��Java���󣬸ö����������Ʊ���ʼ������
		return new  ModelAndView("login").addObject("loginform",new LoginForm());
	}

	// ����post��ʽ����/login.htmlʱ��������ύ������
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(String loginName, String password) {
		System.out.println(loginName);
		System.out.println(password);
		return "seccess";
	}

	// 1.����post��ʽ����/login.htmlʱ��������ύ������
	// ��������һ�¼�RequestParamע��
	@RequestMapping(value = "login1", method = RequestMethod.POST)
	public String do1Login(@RequestParam("loginName") String Name,
			@RequestParam("password") String pwd) {
		System.out.println(Name);
		System.out.println(pwd);
		return "seccess";
	}

	// 2.����post��ʽ����/logiHn.htmlʱ��������ύ������
	// ������̫��ʱ���Զ���һ���ζ��������
	@RequestMapping(value = "login2", method = RequestMethod.POST)
	public String do2Login(@Valid @ModelAttribute("loginform")LoginForm loginForm,
			BindingResult result) {
		if(!loginForm.getLoginName().equals("hao")){
			result.addError(new FieldError("loginform", "loginName", "�û�������"));
			return "login";
		}else if (!loginForm.getPassword().equals("123")) {
			result.addError(new FieldError("loginform", "password", "�������"));
			return "login";
		}		
		
		System.out.println(loginForm.getLoginName());
		System.out.println(loginForm.getPassword());
		return "redirect:seccess.html";
	}

	// 3.����post��ʽ����/logiHn.htmlʱ��������ύ������
		// ������̫��ʱ���Զ���һ���ζ��������
		//����Ϣ���浽session��
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
