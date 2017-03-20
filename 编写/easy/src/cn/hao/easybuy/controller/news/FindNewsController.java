package cn.hao.easybuy.controller.news;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyNews;

@RequestMapping("/")
@Controller
public class FindNewsController extends ControllerBean{

	@RequestMapping("news-view_{id}")
	public ModelAndView getnew(@PathVariable("id") int id){
		EasybuyNews news=newsService.getNews(id);
		return new ModelAndView("news-view").addObject("newssss",news);
	}
}
