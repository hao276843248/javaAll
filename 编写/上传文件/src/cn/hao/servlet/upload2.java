package cn.hao.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upload2 extends HttpServlet {

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
						Map<String, List<FileItem>> items=sfu.parseParameterMap(request);
						String title=items.get("title").get(0).getString("utf-8");
						System.out.println("字段名"+title);
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
							
						}catch (FileUploadException e) {
						System.out.println("上传处理过程发生错误");
						e.printStackTrace();
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}	
				}
	}

}
