package cn.bdqn.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
public class CommonsUploadServlet extends HttpServlet {
	
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
				List<FileItem> items=sfu.parseRequest(request);
				//����FileItem����
				for(FileItem item:items){
					//��ñ�Ԫ�ص��ֶ���
					String fieldName=item.getFieldName();
					System.out.println("�ֶ���:"+fieldName);					
					//�ж��Ƿ���ͨ��Ԫ��
					if(item.isFormField()){
						//��ȡ��Ԫ���ύ���ı�����
						String str=item.getString("utf-8");
						System.out.println("�ı�:"+str);						
					}
					else{
						//���ԭʼ�ļ���
						String fileName=item.getName();
						System.out.println("ԭʼ�ļ���:"+fileName);
						//����ļ�����
						String contentType=item.getContentType();
						System.out.println("�ļ�����:"+contentType);
						//����ļ�����
						long length=item.getSize();
						System.out.println("�ļ�����:"+length);
						//���/WebRoot/uploadĿ¼�ľ���·��
						String uploadPath=sc.getRealPath("/upload");
						System.out.println("�ϴ�Ŀ¼�ľ���·��:"+uploadPath);
						//ת���ļ�������Ŀ¼��
						item.write(new File(uploadPath+"/"+fileName));
						//ɾ����ʱ�ļ�
						item.delete();
					}
				}
				
				
				
			} catch (FileUploadException e) {
				//�ϴ�������̷�������
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}

}






