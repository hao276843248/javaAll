package servlet;


import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
		
		//创建文件收割机线程，在回收不再使用的File对象时自动删除临时文件
		FileCleaningTracker tracker= FileCleanerCleanup.getFileCleaningTracker(sc);
		//创建磁盘项目工厂，负责将上传的文件存入临时目录
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//设置文件收割机线程
		factory.setFileCleaningTracker(tracker);		
		//设置用来存放临时文件的目录
		factory.setRepository(new File("D:\\temp"));
		//设置字节数阈值(字节)，长度小于此值的文件数据直接保存在内存中，否则转存到磁盘目录临时文件中
		factory.setSizeThreshold(100);
		//创建上传处理器
		sfu=new ServletFileUpload(factory);
		//设置允许上传的总的最大长度(100MB)
		sfu.setSizeMax(104857600);
		//允许上传的单个文件长度不允许超过10MB
		sfu.setFileSizeMax(10485760);		
		//获得上传目录的绝对路径
		uploadPath=sc.getRealPath("/manage/upload");		
	}
	
	public void validateFileType(String fileName){
		//判断文件名是否以指定的扩展名结束
		if(FilenameUtils.isExtension(fileName,allowExtNames)==false){
			throw new InvalidFileTypeException();
		}		
	}

}
