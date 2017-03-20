package cn.bdqn.contact.controller.contact;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.form.ContactForm;
import cn.bdqn.contact.service.contact.IContactService;
import cn.bdqn.contact.service.group.IGroupService;

@RequestMapping("/background")
@Controller
public class UpdateContactController {

	private IGroupService groupService;
	private IContactService contactService;
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	@Autowired
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	@ModelAttribute("group")
	public List<Group> groups(){
		return groupService.findGroup();
	}

	@RequestMapping(value="update_{id}",method=RequestMethod.GET)
	public ModelAndView update(
			@PathVariable int id){
		ContactForm c=new ContactForm(contactService.getContact(id));
		return new  ModelAndView("background/update").addObject("contactForm", c);
				
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(
			@Valid
			@ModelAttribute("contactForm")ContactForm contactForm,
			BindingResult result,
			HttpSession session
	) throws Exception{
		User user=(User) session.getAttribute("user");
		
		if(result.hasErrors()){
			return "background/update";
		}
		//获得上传文件
		MultipartFile upload=contactForm.getUpload();
		//获得文件扩展名
		String exName=FilenameUtils.getExtension(upload.getOriginalFilename());
		//生成新文件名
		String newFileName=user.getId()+"_"+System.currentTimeMillis()+"."+exName;
		
		//获得绝对路径
		ServletContext cs=session.getServletContext();
		String uploadPath=cs.getRealPath("/upload");
		//转存文件
		upload.transferTo(new File(uploadPath+"/"+newFileName));
		
		
		//获得实体
		Contact contact=contactForm.getContact();
		
		contact.setPhoto(newFileName);
		contact.setUser(user);
		contactService.updateContact(contact);
		return "redirect:index.html";
	}
	
}
