package cn.hao.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//类在跟目录下， 他是1个控制器@Controller
@RequestMapping("/")
@Controller
public class HelloController {
	//URL:--
	//http://localhost:8080/SpringMVC/hello1.html
	@RequestMapping("hello1")
	public ModelAndView hello1(){
		//创建对象
		ModelAndView mav=new ModelAndView("hello");
		//添加值
		mav.addObject("msg","Hello1,Word!");
		//返回对象
		return mav;
	}
	
	
	//方法参数为Model对象 模型
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("msg","Hello,Word!");
		return "hello";
	}
	
	//方法参数为Map也可以传值
	@RequestMapping("hello3")
	public String hello3(Map<Object,String> model){
		model.put("msg","Hello3,Word!");
		return "hello";
	}
	
	@RequestMapping("hello4")
	public String hello4(Model model){
		model.addAttribute("msg","Hello,Word!");
		return "hello";
	}
	
	

	@RequestMapping("hello2")
	public String hello2(){
		//没值的转发
		return "hello";
	}
	
	//添加ModelAttribute 注解 可以将返回值添加到request作用域中
	//方法名可以自定义
	@ModelAttribute("msg")
	public List<String> getMsg(){
		List<String> a=new ArrayList<String>();
		a.add("▇▆▅▄▃▂▁");
		a.add("Hello3,Word!");
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}




















