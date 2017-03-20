package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.log4j.Logger;

import entity.Student;

import Service.IServiceStudent;
import Service.ServiceStudent;
@WebServlet("/manage/add")
public class add extends uploadBaseServlet {
	
	private IServiceStudent is=new ServiceStudent();
	private Logger logger=Logger.getLogger(add.class);
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		try {
			Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
			//��ȡ�ϴ����ļ�
			FileItem pic=items.get("pic").get(0);
			//���ԭʼ�ļ���
			String fileName=pic.getName();
			//ת���ļ�
			pic.write(new File(uploadPath+"/"+fileName));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			Student s=new Student(
					items.get("name").get(0).getString("UTF-8"),
					items.get("sex").get(0).getString("UTF-8"),
					items.get("phone").get(0).getString("UTF-8"),
					items.get("nianji").get(0).getString("UTF-8"),
					sdf.parse(items.get("birthday").get(0).getString("UTF-8")),
					items.get("address").get(0).getString("UTF-8"),
					items.get("password").get(0).getString("UTF-8"),
					fileName
					);
			is.addSudent(s);
			response.sendRedirect("show");
			
		} catch(FileSizeLimitExceededException e){
			out.write("�����ļ����ȳ�������");
			logger.error("�����ļ����ȳ�������",e);
		}
		catch(SizeLimitExceededException e){
			out.write("�ϴ��ļ��ܳ��ȳ�������");
			logger.error("�ϴ��ļ��ܳ��ȳ�������",e);
		}
		catch(InvalidFileTypeException e){
			out.write("�ļ����Ͳ������ϴ�");
			logger.error("�ļ����Ͳ������ϴ�",e);
		}
		catch (Exception e) {				
			logger.error("�ϴ��ļ�ʱ��������",e);
		}
		
	}

}
