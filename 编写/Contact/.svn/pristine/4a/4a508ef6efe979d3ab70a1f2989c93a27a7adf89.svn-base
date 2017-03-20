package cn.bdqn.contact.controller.contact;

import java.io.File;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.google.code.kaptcha.Constants;
import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;


import cn.bdqn.contact.entity.Contact;
import cn.bdqn.contact.entity.Group;
import cn.bdqn.contact.entity.User;
import cn.bdqn.contact.form.ContactForm;

import cn.bdqn.contact.service.contact.IContactService;
import cn.bdqn.contact.service.group.IGroupService;
@RequestMapping("/background")
@Controller
public class AddContactController {

	private IContactService contactService;
	private IGroupService groupService;
	
	@Autowired
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	@Autowired
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	@ModelAttribute("contactForm")
	public ContactForm contactForm(){
		return new ContactForm();
	}

	@ModelAttribute("group")
	public List<Group> groupForm(){
		return groupService.findGroup();
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(){
		return "background/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@Valid @ModelAttribute("contactForm")ContactForm contactForm,
			BindingResult result,
			HttpSession session
	) throws Exception{
		User user=(User) session.getAttribute("user");
		String reaVcode=(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String vcode=contactForm.getVcode();
		
		if(result.hasErrors()){
			return "background/add";
		}
		
		if(StringUtils.isNotEmpty(vcode) &&!vcode.equals(reaVcode)){
			result.rejectValue("vcode","invalid.vcode");
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
		contactService.addContact(contact);
		return "redirect:index.html";
	}
	
}
