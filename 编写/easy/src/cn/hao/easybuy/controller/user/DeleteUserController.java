package cn.hao.easybuy.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;


@RequestMapping("/manage")
@Controller
public class DeleteUserController extends ControllerBean{

	
	@RequestMapping("delete_{id}")
	public String delete(@PathVariable("id")String userName){
		userService.deleteUser(userName);
		
		return "redirect:user.html"; 
	}
}
