package cn.bdqn.book.servlet;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FilenameUtils;

public class UploadBaseServlet extends HttpServlet{

	protected ServletFileUpload sfu;
	protected String uploadPath="/manage/upload";
	protected String[] allowExtNames={"jpg","gif","png","bmp"};
	
	@Override
	public void init() throws ServletException {		
		ServletContext sc=getServletContext();
		
		//读取Servlet的私有初始化参数
		//getInitParameter(name)
		
		String tempDir="D:\\temp";
		//通过ServletContext对象读取web.xml中<context-param>配置的全局初始化参数
		if(sc.getInitParameter("tempDir")!=null){
			tempDir=sc.getInitParameter("tempDir");
		}
		int sizeThreshold=100;
		if(sc.getInitParameter("sizeThreshold")!=null){
			sizeThreshold=Integer.parseInt(sc.getInitParameter("sizeThreshold"));
		}
		int sizeMax=104857600;
		if(sc.getInitParameter("sizeMax")!=null){
			sizeMax=Integer.parseInt(sc.getInitParameter("sizeMax"));
		}
		int fileSizeMax=10485760;
		if(sc.getInitParameter("fileSizeMax")!=null){
			fileSizeMax=Integer.parseInt(sc.getInitParameter("fileSizeMax"));
		}		
		if(sc.getInitParameter("uploadPath")!=null){
			uploadPath=sc.getInitParameter("uploadPath");
		}
		if(sc.getInitParameter("allowExtNames")!=null){
			allowExtNames=sc.getInitParameter("allowExtNames").split(",");
		}
		
		//创建文件收割机线程，在回收不再使用的File对象时自动删除临时文件
		FileCleaningTracker tracker= FileCleanerCleanup.getFileCleaningTracker(sc);
		//创建磁盘项目工厂，负责将上传的文件存入临时目录
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//设置文件收割机线程
		factory.setFileCleaningTracker(tracker);		
		//设置用来存放临时文件的目录
		factory.setRepository(new File(tempDir));
		//设置字节数阈值(字节)，长度小于此值的文件数据直接保存在内存中，否则转存到磁盘目录临时文件中
		factory.setSizeThreshold(sizeThreshold);
		//创建上传处理器
		sfu=new ServletFileUpload(factory);
		//设置允许上传的总的最大长度(100MB)
		sfu.setSizeMax(sizeMax);
		//允许上传的单个文件长度不允许超过10MB
		sfu.setFileSizeMax(fileSizeMax);		
		//获得上传目录的绝对路径
		uploadPath=sc.getRealPath(uploadPath);		
	}
	
	public void validateFileType(String fileName){
		//判断文件名是否以指定的扩展名结束
		if(FilenameUtils.isExtension(fileName,allowExtNames)==false){
			throw new InvalidFileTypeException();
		}		
	}
	
	
	
	
	
	
	
}
