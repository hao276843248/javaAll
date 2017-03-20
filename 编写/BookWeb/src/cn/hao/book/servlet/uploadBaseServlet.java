package cn.hao.book.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;


import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FilenameUtils;

public class uploadBaseServlet extends HttpServlet {

	protected  ServletFileUpload sfu;
	protected String uploadPath;
protected String[] allowExtNames={"jpg","gif","png","bmp"};
	
	@Override
	public void init() throws ServletException {		
		ServletContext sc=getServletContext();
		
		//锟斤拷锟斤拷锟侥硷拷锟秸革拷锟斤拷叱蹋锟斤拷诨锟斤拷詹锟斤拷锟绞癸拷玫锟紽ile锟斤拷锟斤拷时锟皆讹拷删锟斤拷锟斤拷时锟侥硷拷
		FileCleaningTracker tracker= FileCleanerCleanup.getFileCleaningTracker(sc);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷目锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟较达拷锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷时目录
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//锟斤拷锟斤拷锟侥硷拷锟秸革拷锟斤拷叱锟�
		factory.setFileCleaningTracker(tracker);		
		//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟绞憋拷募锟斤拷锟侥柯�
		factory.setRepository(new File("D:\\temp"));
		//锟斤拷锟斤拷锟街斤拷锟斤拷锟斤拷值(锟街斤拷)锟斤拷锟斤拷锟斤拷小锟节达拷值锟斤拷锟侥硷拷锟斤拷锟斤拷直锟接憋拷锟斤拷锟斤拷锟节达拷锟叫ｏ拷锟斤拷锟斤拷转锟芥到锟斤拷锟斤拷目录锟斤拷时锟侥硷拷锟斤拷
		factory.setSizeThreshold(100);
		//锟斤拷锟斤拷锟较达拷锟斤拷锟斤拷锟斤拷
		sfu=new ServletFileUpload(factory);
		//锟斤拷锟斤拷锟斤拷锟斤拷锟较达拷锟斤拷锟杰碉拷锟斤拷蟪ざ锟�100MB)
		sfu.setSizeMax(104857600);
		//锟斤拷锟斤拷锟较达拷锟侥碉拷锟斤拷锟侥硷拷锟斤拷锟饺诧拷锟斤拷锟斤拷锟斤拷10MB
		sfu.setFileSizeMax(10485760);		
		//锟斤拷锟斤拷洗锟侥柯硷拷木锟斤拷锟铰凤拷锟�
		uploadPath=sc.getRealPath("/manage/upload");		
	}
	
	public void validateFileType(String fileName){
		//锟叫讹拷锟侥硷拷锟斤拷锟角凤拷锟斤拷指锟斤拷锟斤拷锟斤拷展锟斤拷锟斤拷锟斤拷
		if(FilenameUtils.isExtension(fileName,allowExtNames)==false){
			throw new InvalidFileTypeException();
		}		
	}		

}
