package cn.bdqn.contact.controller.contact;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.form.SearchForm;
import cn.bdqn.contact.service.contact.IContactService;
import cn.bdqn.contact.service.group.IGroupService;
import cn.bdqn.contact.util.PageBean;

@RequestMapping("/background")
@Controller
public class ListContactController {

	private IContactService contactService;
	private IGroupService groupService;
	
	@Autowired
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	@ModelAttribute("searchForm")
	public SearchForm searchForm(){
		return new SearchForm();
	}
	
	@ModelAttribute("group")
	public List<Group> groupForm(){
		List<Group> groups=groupService.findGroup();
		groups.add(0,new Group("所有分组"));
		return groups;
	}
	
	
	@RequestMapping(value="index")
	public ModelAndView index(@ModelAttribute("searchForm")SearchForm searchForm,HttpSession session){
		User user=(User) session.getAttribute("user");
		PageBean p=contactService.findContact(searchForm.getPageIndex(), searchForm.getPageSize(),user.getId(), searchForm.getGroupId(),searchForm.getName());
	
		return new ModelAndView("background/index").addObject("p", p);
		
	}
	
}
