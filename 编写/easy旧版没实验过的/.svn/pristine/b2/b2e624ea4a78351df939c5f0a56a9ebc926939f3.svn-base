package cn.hao.easybuy.controller.comment;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.form.CommentForm;
import cn.hao.easybuy.util.PageBean;

@RequestMapping("/")
@Controller
public class GuesbookController extends ControllerBean{


	
	
	@ModelAttribute("p")
	public PageBean comment(){
		return commentService.findComment(1,3);
	}
	@ModelAttribute("comment")
	public CommentForm commentForm(){
		return new CommentForm();
	}
	
	@RequestMapping(value="guestbook",method=RequestMethod.GET)
	public String guestbook(){
		return "guestbook";
	}
	
	
	
	@RequestMapping(value="guestbook",method=RequestMethod.POST)
	public ModelAndView index(@ModelAttribute("comment")CommentForm commentForm,HttpSession session){
		if(!commentForm.getGuestName().equals("") && !commentForm.getGuestContent().equals("")){
			EasybuyComment comment=new EasybuyComment();
			comment.setEcContent(commentForm.getGuestContent());
			comment.setEcNickName(commentForm.getGuestName());
			comment.setEcCreateTime(new Date());
			commentService.addComment(comment);
			return new ModelAndView("redirect:guestbook.html");
		}
	
		PageBean p=commentService.findComment(commentForm.getPageIndex(), commentForm.getPageSize());
	
		return new ModelAndView("guestbook").addObject("p", p);
		
	}
	
}
