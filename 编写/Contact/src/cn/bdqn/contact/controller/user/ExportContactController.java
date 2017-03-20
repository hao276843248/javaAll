package cn.bdqn.contact.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.service.contact.IContactService;

@RequestMapping("/background")
@Controller
public class ExportContactController {

	private IContactService contactService;
	
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	@RequestMapping("export")
	public ModelAndView export(
		HttpSession session	
	){
		User user=(User)session.getAttribute("user");
		//查询当前登录用户的所有联系人列表
		List<Contact> contacts=contactService.findContact(user.getId());
		
		return new ModelAndView("contactListExcelView").addObject("contacts",contacts);
	}
}
