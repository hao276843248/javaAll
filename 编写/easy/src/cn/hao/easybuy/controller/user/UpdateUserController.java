package cn.hao.easybuy.controller.user;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.form.user.RegistForm;

@RequestMapping("/manage")
@Controller
public class UpdateUserController extends ControllerBean{

	
	@RequestMapping(value="update-modify_{id}",method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")String UserName){
		EasybuyUser user=userService.getUsers(UserName);
		RegistForm userf=new RegistForm(user);
		return new ModelAndView("manage/user-modify").addObject("userForm",userf);
	}
	
	@RequestMapping(value="update-modify",method=RequestMethod.POST)
	public String update(
			@Valid
			@ModelAttribute("userForm")RegistForm userForm,
			BindingResult result
	) throws Exception{
		EasybuyUser user=userForm.getUser();
		user.setEuUserId(userForm.getUserId());
		userService.updateUser(user);
		return "redirect:user.html";
	}
	
}
