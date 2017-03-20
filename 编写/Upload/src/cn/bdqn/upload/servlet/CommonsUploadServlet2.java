package cn.bdqn.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload2")
public class CommonsUploadServlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得ServletContext
		ServletContext sc=request.getServletContext();
		
		
		//判断是否上传文件的请求
		if(ServletFileUpload.isMultipartContent(request)){
			//创建磁盘项目工厂，负责将上传的文件存入临时目录
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//设置用来存放临时文件的目录
			factory.setRepository(new File("D:\\temp"));
			//设置字节数阈值(字节)，长度小于此值的文件数据直接保存在内存中，否则转存到磁盘目录临时文件中
			factory.setSizeThreshold(100);
			//创建上传处理器
			ServletFileUpload sfu=new ServletFileUpload(factory);
			//解析请求
			try {
				Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
				
				String title=items.get("title").get(0).getString("utf-8");
				System.out.println("title="+title);
				
				FileItem upload=items.get("upload").get(0);
				//获得原始文件名
				String fileName=upload.getName();
				System.out.println("原始文件名:"+fileName);
				//获得文件类型
				String contentType=upload.getContentType();
				System.out.println("文件类型:"+contentType);
				//获得文件长度
				long length=upload.getSize();
				System.out.println("文件长度:"+length);
				//获得/WebRoot/upload目录的绝对路径
				String uploadPath=sc.getRealPath("/upload");
				System.out.println("上传目录的绝对路径:"+uploadPath);
				//转存文件到永久目录下
				upload.write(new File(uploadPath+"/"+fileName));
				//删除临时文件
				upload.delete();
				
				
				
			} catch (FileUploadException e) {
				//上传处理过程发生错误
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}

}






