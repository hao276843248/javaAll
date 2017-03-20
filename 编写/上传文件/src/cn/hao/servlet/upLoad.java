package cn.hao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.print.DocFlavor.STRING;
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
@WebServlet("/upload")
public class upLoad extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得servletContext
		ServletContext sc=request.getServletContext();
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setRepository(new File("D://temp"));
			factory.setSizeThreshold(100);
			
			ServletFileUpload sfu=new ServletFileUpload(factory);
			try {
				List<FileItem> items=sfu.parseRequest(request);
				//便利集合、
				for(FileItem item:items){
					String fieldName=item.getFieldName();
					System.out.println("字段名"+fieldName);
					if(item.isFormField()){
						String str=item.getString("utf-8");
						System.out.println("文件名"+str);
					}else{
						String name=item.getName();
						System.out.println("原文件名"+name);
						
						String contentype=item.getContentType();
						System.out.println("文件类型："+contentype);
						
						long size=item.getSize();
						System.out.println("文件长度"+size);
						
						String uploadpath=sc.getRealPath("/upload");
						System.out.println("上传绝对路径"+uploadpath);
						
						item.write(new File(uploadpath+"/"+name));
						//删除临时文件
						item.delete();
					}
					
				}
			
			
			
			} catch (FileUploadException e) {
				System.out.println("上传处理过程发生错误");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
