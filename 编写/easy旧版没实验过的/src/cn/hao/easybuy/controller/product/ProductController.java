package cn.hao.easybuy.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.util.PageBean;

@RequestMapping("/")
@Controller
public class ProductController extends ControllerBean{
	
	
	@ModelAttribute("product1")
	public PageBean product(){
		PageBean p=productService.find(1, 8, 1);
		return p;
	}
	
	@ModelAttribute("product2")
	public PageBean product2(){
		PageBean p=productService.find(1, 8, 2);
		return p;
	}
	
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
			
			
			
			

}
