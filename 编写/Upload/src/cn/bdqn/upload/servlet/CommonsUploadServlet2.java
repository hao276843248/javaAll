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
		//���ServletContext
		ServletContext sc=request.getServletContext();
		
		
		//�ж��Ƿ��ϴ��ļ�������
		if(ServletFileUpload.isMultipartContent(request)){
			//����������Ŀ�����������ϴ����ļ�������ʱĿ¼
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//�������������ʱ�ļ���Ŀ¼
			factory.setRepository(new File("D:\\temp"));
			//�����ֽ�����ֵ(�ֽ�)������С�ڴ�ֵ���ļ�����ֱ�ӱ������ڴ��У�����ת�浽����Ŀ¼��ʱ�ļ���
			factory.setSizeThreshold(100);
			//�����ϴ�������
			ServletFileUpload sfu=new ServletFileUpload(factory);
			//��������
			try {
				Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
				
				String title=items.get("title").get(0).getString("utf-8");
				System.out.println("title="+title);
				
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
				
				
				
			} catch (FileUploadException e) {
				//�ϴ�������̷�������
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}

}






