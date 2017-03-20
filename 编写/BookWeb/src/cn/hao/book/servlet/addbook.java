package cn.hao.book.servlet;

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

import cn.hao.book.entity.Book;
import cn.hao.book.service.BookServiceImpl;
import cn.hao.book.service.IBookService;

@WebServlet("/manage/add")
public class addbook extends uploadBaseServlet{
	private Logger logger=Logger.getLogger(addbook.class);
	private IBookService bookService=new BookServiceImpl();
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		if(request.getParameter("title")==""){
			request.setAttribute("err_title","���ⲻ��Ϊ��");
			request.getRequestDispatcher("/manage/ADD.jsp").forward(request, response);
			return;
		}else if(request.getParameter("author")==""){
			request.setAttribute("err_author","���߲���Ϊ��");
			request.getRequestDispatcher("/manage/ADD.jsp").forward(request, response);
			return;
		}else if(request.getParameter("publisher")==""){
			request.setAttribute("err_publisher","�����粻��Ϊ��");
			request.getRequestDispatcher("/manage/ADD.jsp").forward(request, response);
			return;
		}else if(request.getParameter("price")==""){
			request.setAttribute("err_price","��Ǯ����Ϊ��");
			request.getRequestDispatcher("/manage/ADD.jsp").forward(request, response);
			return;
		}else if(request.getParameter("pubdate")==""){
			request.setAttribute("err_pubdate","�������ڲ���Ϊ��");
			request.getRequestDispatcher("/manage/ADD.jsp").forward(request, response);
			return;
		}
		
		try {
			Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
			//��ȡ�ϴ����ļ�
			FileItem pic=items.get("pic").get(0);
			//���ԭʼ�ļ���
			String fileName=pic.getName();
			//ת���ļ�
			pic.write(new File(uploadPath+"/"+fileName));
			//ɾ����ʱ�ļ�
			//pic.delete();
			
			Book book=new Book();
			bookService.addBook(book);
			
			response.sendRedirect("list");
		}  
		catch(FileSizeLimitExceededException e){
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
















