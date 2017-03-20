package cn.hao.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.hao.mvc.form.UploadForm;

@RequestMapping("/")
@Controller
public class upload {

	
	@RequestMapping(value="upload",method=RequestMethod.GET)
	public ModelAndView  upload(){
		return new ModelAndView("upload").addObject("uploadForm",new UploadForm());
	}
	
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public ModelAndView upload(
			@Valid @ModelAttribute("uploadForm")UploadForm uploadForm,BindingResult result,HttpSession session) throws Exception{
		if (result.hasErrors()) {
			return new ModelAndView("upload");
		}
		System.out.println(uploadForm.getTitle());
		MultipartFile file=uploadForm.getUpload();
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		System.out.println(file.getOriginalFilename());
		System.out.println();
		
		String houString=FilenameUtils.getExtension(file.getOriginalFilename());
		
		String newname=System.currentTimeMillis()+"."+houString;
		
		ServletContext sc=session.getServletContext();
		String uploadpath=sc.getRealPath("/upload");
		
		file.transferTo(new File(uploadpath+"/"+newname));
		System.out.println(newname);
		return new ModelAndView("show").addObject("newname",newname);
	}
}
