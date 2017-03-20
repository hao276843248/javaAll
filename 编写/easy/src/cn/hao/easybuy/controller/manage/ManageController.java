package cn.hao.easybuy.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manage")
@Controller
public class ManageController {

	@RequestMapping("index")
	public String index(){
		return "manage/index";
	}
}
