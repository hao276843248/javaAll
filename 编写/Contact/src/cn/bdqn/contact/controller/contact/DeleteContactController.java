package cn.bdqn.contact.controller.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bdqn.contact.service.contact.IContactService;

@RequestMapping("/background")
@Controller
public class DeleteContactController {

	private IContactService contactService;
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	@RequestMapping("delete_{id}")
	public String delete(@PathVariable int id){
		contactService.deleteContact(id);
		
		return "redirect:index.html"; 
	}
	
}
