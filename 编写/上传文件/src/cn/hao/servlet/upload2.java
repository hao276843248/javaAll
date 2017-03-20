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
		//���servletContext
				ServletContext sc=request.getServletContext();
				
				if(ServletFileUpload.isMultipartContent(request)){
					DiskFileItemFactory factory=new DiskFileItemFactory();
					factory.setRepository(new File("D://temp"));
					factory.setSizeThreshold(100);
					
					ServletFileUpload sfu=new ServletFileUpload(factory);
					try {
						Map<String, List<FileItem>> items=sfu.parseParameterMap(request);
						String title=items.get("title").get(0).getString("utf-8");
						System.out.println("�ֶ���"+title);
						FileItem upload=items.get("upload").get(0);
						//���ԭʼ�ļ���
						String fileName=upload.getName();
						System.out.println("ԭʼ�ļ���:"+fileName);
						//����ļ�����
						String contentType=upload.getContentType();
						System.out.println("�ļ�����:"+contentType);
						//����ļ�����
						long length=upload.getSize();
						System.out.println("�ļ�����:"+length);
						//���/WebRoot/uploadĿ¼�ľ���·��
						String uploadPath=sc.getRealPath("/upload");
						System.out.println("�ϴ�Ŀ¼�ľ���·��:"+uploadPath);
						//ת���ļ�������Ŀ¼��
						upload.write(new File(uploadPath+"/"+fileName));
						//ɾ����ʱ�ļ�
						upload.delete();
							
						}catch (FileUploadException e) {
						System.out.println("�ϴ�������̷�������");
						e.printStackTrace();
						} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}	
				}
	}

}
