package cn.hao.book.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import cn.hao.book.entity.Book;
import cn.hao.book.entity.Publisher;
import cn.hao.book.service.BookServiceImpl;
import cn.hao.book.service.IBookService;
@WebServlet("/manage/update")
public class updatebookServlet extends uploadBaseServlet {

	private IBookService bookService=new BookServiceImpl();
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private Logger logger=Logger.getLogger(updatebookServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Book book=bookService.getBookID(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out=response.getWriter();
		
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
				//pic.delete();
			
				//将表单提交的数据封装到实体对象中

				//将表单提交的数据封装到实体对象中
				Book book=new Book(
					Integer.parseInt(items.get("id").get(0).getString("utf-8")),
					items.get("author").get(0).getString("utf-8"),	
					items.get("title").get(0).getString("utf-8"),									
					Double.parseDouble(items.get("price").get(0).getString("utf-8")),
					sdf.parse(items.get("pubdate").get(0).getString("utf-8")),
					fileName				
			    );
				
				int publisherId=Integer.parseInt(items.get("publisherId").get(0).getString());
				Publisher publisher=new Publisher();
				publisher.setId(publisherId);
				book.setPublisher(publisher);
				
				//保存图书
				bookService.updateBook(book);
				
				//重定向到图书列表
				response.sendRedirect("list");
				
			}  
			catch(FileSizeLimitExceededException e){
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
				out.write("上传文件时发生错误");
				logger.error("上传文件时发生错误",e);
			}
		}
	}
}
