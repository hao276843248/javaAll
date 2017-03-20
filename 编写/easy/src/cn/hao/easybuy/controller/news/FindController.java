package cn.hao.easybuy.controller.news;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;


@RequestMapping("/manage")
@Controller
public class FindController extends ControllerBean{
	
	@RequestMapping("newManage")
	public String find(){
		return "manage/";
		
	}
	
}
