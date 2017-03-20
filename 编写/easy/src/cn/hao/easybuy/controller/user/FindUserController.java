package cn.hao.easybuy.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.util.PageBean;

@RequestMapping("/manage")
@Controller
public class FindUserController extends ControllerBean{

	
	@ModelAttribute("pUser")
	public PageBean users(){
		return userService.findUsers(1,8);
	}
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	public String find(){
		return "manage/user";
	}
}
