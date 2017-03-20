package cn.hao.easybuy.controller.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;
@RequestMapping("/manage")
@Controller
public class DeleteGuesbookController extends ControllerBean{
	
	@RequestMapping("deleteCommetn_{id}")
	public String delete(@PathVariable("id")int id){
		commentService.delete(id);
		return "redirect:guestbook.html"; 
	}
}