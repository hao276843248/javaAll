package cn.bdqn.contact.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/")
@Controller
public class LogoutController {

	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login.html";
	}
}
