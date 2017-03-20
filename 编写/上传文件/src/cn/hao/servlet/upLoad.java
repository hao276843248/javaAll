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
		//���servletContext
		ServletContext sc=request.getServletContext();
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setRepository(new File("D://temp"));
			factory.setSizeThreshold(100);
			
			ServletFileUpload sfu=new ServletFileUpload(factory);
			try {
				List<FileItem> items=sfu.parseRequest(request);
				//�������ϡ�
				for(FileItem item:items){
					String fieldName=item.getFieldName();
					System.out.println("�ֶ���"+fieldName);
					if(item.isFormField()){
						String str=item.getString("utf-8");
						System.out.println("�ļ���"+str);
					}else{
						String name=item.getName();
						System.out.println("ԭ�ļ���"+name);
						
						String contentype=item.getContentType();
						System.out.println("�ļ����ͣ�"+contentype);
						
						long size=item.getSize();
						System.out.println("�ļ�����"+size);
						
						String uploadpath=sc.getRealPath("/upload");
						System.out.println("�ϴ�����·��"+uploadpath);
						
						item.write(new File(uploadpath+"/"+name));
						//ɾ����ʱ�ļ�
						item.delete();
					}
					
				}
			
			
			
			} catch (FileUploadException e) {
				System.out.println("�ϴ�������̷�������");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
