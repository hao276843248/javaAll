package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import entity.Student;

import Service.IServiceStudent;
import Service.ServiceStudent;
@WebServlet("/manage/edit")
public class update extends uploadBaseServlet {
	private IServiceStudent is=new ServiceStudent();
	private Logger logger=Logger.getLogger(update.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Student a=is.getStudent(id);
		request.setAttribute("s", a);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(ServletFileUpload.isMultipartContent(request)){	
			
		
			try {
				Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
				//提取上传的文件
				FileItem pic=items.get("pic").get(0);
				//获得原始文件名
				String fileName=pic.getName();
				//转存文件
				pic.write(new File(uploadPath+"/"+fileName));
				//删除临时文件
				//pic.delete();\
				Student s=new Student(
						Integer.parseInt(items.get("id").get(0).getString("UTF-8")),
						items.get("name").get(0).getString("UTF-8"),
						items.get("sex").get(0).getString("UTF-8"),
						items.get("phone").get(0).getString("UTF-8"),
						items.get("nianji").get(0).getString("UTF-8"),
						sdf.parse(items.get("birthday").get(0).getString("UTF-8")),
						items.get("address").get(0).getString("UTF-8"),
						items.get("password").get(0).getString("UTF-8"),
						fileName
				);
				is.updateStudent(s);
				
				response.sendRedirect("show");
			}catch(FileSizeLimitExceededException e){
				out.write("单个文件长度超出限制");
				logger.error("单个文件长度超出限制",e);
			}
			catch(SizeLimitExceededException e){
				out.write("上传文件总长度超出限制");
				logger.error("上传文件总长度超出限制",e);
			}	
			catch(InvalidFileTypeException e){
				out.write("文件类型不允许上传");
				logger.error("文件类型不允许上传",e);
			}
			catch (Exception e) {				
				logger.error("上传文件时发生错误",e);
			}
		}
		
	}

}
