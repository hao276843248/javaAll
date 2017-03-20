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

//���ڸ�Ŀ¼�£� ����1��������@Controller
@RequestMapping("/")
@Controller
public class HelloController {
	//URL:--
	//http://localhost:8080/SpringMVC/hello1.html
	@RequestMapping("hello1")
	public ModelAndView hello1(){
		//��������
		ModelAndView mav=new ModelAndView("hello");
		//���ֵ
		mav.addObject("msg","Hello1,Word!");
		//���ض���
		return mav;
	}
	
	
	//��������ΪModel���� ģ��
	@RequestMapping("hello")
	public String hello(Model model){
		model.addAttribute("msg","Hello,Word!");
		return "hello";
	}
	
	//��������ΪMapҲ���Դ�ֵ
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
		//ûֵ��ת��
		return "hello";
	}
	
	//���ModelAttribute ע�� ���Խ�����ֵ��ӵ�request��������
	//�����������Զ���
	@ModelAttribute("msg")
	public List<String> getMsg(){
		List<String> a=new ArrayList<String>();
		a.add("�~�}�|�{�z�y�x");
		a.add("Hello3,Word!");
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}




















