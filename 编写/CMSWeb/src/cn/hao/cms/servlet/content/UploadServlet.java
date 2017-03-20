package cn.hao.cms.servlet.content;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet("/background/content/upload")
public class UploadServlet extends HttpServlet {
	private String uploadPath;
	private String[] allowExtNames={"jpg","png","gif","bmp"};
	@Override
	public void init() throws ServletException {
		ServletContext sc=getServletContext();
		uploadPath=sc.getRealPath("/upload");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MultipartRequest mrequest=new MultipartRequest(request,"D:\\temp",10485760,new DefaultFileRenamePolicy());
			//����ϴ����ļ�
			File file=mrequest.getFile("file");			
			//����ϴ��ļ����ļ���
			String fileName=file.getName();
			if(FilenameUtils.isExtension(fileName, allowExtNames)){
				//�������ļ�
				fileName=System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);						
				//ת���ļ�
				FileUtils.copyFile(file,new File(uploadPath+"/"+fileName));
				
				
				
				request.setAttribute("fileName",fileName);
				request.getRequestDispatcher("success.jsp").forward(request,response);
			}else{
				request.setAttribute("err_msg","�ļ����Ͳ������ϴ�");
				request.getRequestDispatcher("error.jsp").forward(request,response);
			}
			//ɾ����ʱĿ¼�µ��ļ�
			file.delete();
			} catch (Exception e) {
			request.setAttribute("err_msg","�ϴ��ļ�ʱ��������");
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
	}

}
