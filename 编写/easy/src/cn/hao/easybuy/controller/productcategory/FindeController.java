package cn.hao.easybuy.controller.productcategory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;

@RequestMapping("/manage")
@Controller
public class FindeController extends ControllerBean{
	
	@RequestMapping("productClass")
	public String product(){
		return "manage/productClass";
	}
}
