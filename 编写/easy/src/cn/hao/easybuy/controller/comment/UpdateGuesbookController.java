package cn.hao.easybuy.controller.comment;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.easybuy.controller.ControllerBean;
import cn.hao.easybuy.entity.EasybuyComment;
import cn.hao.easybuy.form.comment.CommentForm;

@RequestMapping("/manage")
@Controller
public class UpdateGuesbookController extends ControllerBean{
	
		@RequestMapping(value="guestbook-modify_{id}",method=RequestMethod.GET)
		public ModelAndView update(@PathVariable("id")int id){
			EasybuyComment comment=commentService.get(id);
			CommentForm comForm=new CommentForm(comment);
			return new ModelAndView("manage/guestbook-modify").addObject("comForm",comForm);
		}
		
		@RequestMapping(value="guestbook-modify",method=RequestMethod.POST)
		public String update(
				@Valid
				@ModelAttribute("comForm")CommentForm comForm,
				BindingResult result
		) throws Exception{
			EasybuyComment comment=comForm.getComment();
			EasybuyComment ss=commentService.get(comForm.getEcId());
			comment.setEcCreateTime(ss.getEcCreateTime());
			comment.setEcId(comForm.getEcId());
			commentService.updateComment(comment);
			return "redirect:guestbook.html";
		}

}
