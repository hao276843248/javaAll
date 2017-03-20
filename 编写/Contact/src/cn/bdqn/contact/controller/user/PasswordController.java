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
import cn.bdqn.contact.form.PasswordForm;
import cn.bdqn.contact.service.user.IUserService;

@RequestMapping("/background")
@Controller
public class PasswordController {

	private IUserService userService;
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("passwordForm")
	public PasswordForm passwordForm(){
		return new PasswordForm();
	}
	@RequestMapping(value="password",method=RequestMethod.GET)
	public String password(){
		return "background/password";
	}
	
	@RequestMapping(value="password",method=RequestMethod.POST)
	public String password( @Valid @ModelAttribute("passwordForm")PasswordForm passwordForm,
			BindingResult result,
			HttpSession session){
		User user=(User) session.getAttribute("user");
		String reaVcode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String vcode=passwordForm.getVcode();
		
		if(result.hasErrors()){
			return "background/password";
		}
		
		if(!user.getPassword().equals(passwordForm.getOldPwd())){
			result.rejectValue("oldPwd","invalid.oldPwd");
			return "background/password";
		}
		if(user.getPassword().equals(passwordForm.getNewPwd())){
			result.rejectValue("newPwd","invalid.password1");
			return "background/password";
		}
		if(!passwordForm.getNewPwd().equals(passwordForm.getRePwd())){
			result.rejectValue("rePwd", "invalid.rePwd");
			return "background/password";
		}
		
		if(StringUtils.isNotEmpty(vcode) &&!vcode.equals(reaVcode)){
			result.rejectValue("vcode","invalid.vcode");
			return "background/password";
		}
		
		userService.updatePassword(user.getId(),passwordForm.getNewPwd());
		return "redirect:/login.html";
		
	}
}
