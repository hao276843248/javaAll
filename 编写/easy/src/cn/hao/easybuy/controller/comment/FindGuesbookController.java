package cn.hao.easybuy.controller.comment;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.form.SearchForm;
import cn.hao.easybuy.util.PageBean;
@RequestMapping("/manage")
@Controller
public class FindGuesbookController extends ControllerBean{

	@RequestMapping(value="guestbook")
	public ModelAndView index(@ModelAttribute("searchForm")SearchForm searchForm,HttpSession session){
		
		PageBean p=commentService.findComment(searchForm.getPageIndex(), searchForm.getPageSize());
	
		return new ModelAndView("manage/guestbook").addObject("p", p);
		
	}
	
	
	
}
