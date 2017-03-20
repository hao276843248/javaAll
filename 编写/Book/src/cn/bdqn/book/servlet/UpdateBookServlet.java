package cn.bdqn.book.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.entity.Publisher;
import cn.bdqn.book.service.BookServiceImpl;
import cn.bdqn.book.service.IBookService;

@WebServlet("/manage/update")
public class UpdateBookServlet extends UploadBaseServlet {
	private Logger logger=Logger.getLogger(AddBookServlet.class);
	private IBookService bookService=new BookServiceImpl();
	
	//�û����б�ҳ����༭�����ӣ�����get���󣬴���ͼ����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//���ͼ����
		int id=Integer.parseInt(request.getParameter("id"));
		//����ͼ���Ż�ȡͼ����Ϣ		
		Book book=bookService.getBook(id);
		
		//��ͼ����Ϣ����������
		request.setAttribute("book",book);
		
		//ת����edit.jsp
		request.getRequestDispatcher("edit.jsp").forward(request, response);		
	}

	//�û��ύ�༭��
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out=response.getWriter();
		if(ServletFileUpload.isMultipartContent(request)){		
			try {
				Map<String,List<FileItem>> items=sfu.parseParameterMap(request);
				
				//��ȡ�ϴ����ļ�
				FileItem pic=items.get("pic").get(0);
				//���ԭʼ�ļ���
				String fileName=pic.getName();
				//��֤�ļ�����
				validateFileType(fileName);
				//ת���ļ�
				pic.write(new File(uploadPath+"/"+fileName));
				
			
				//�����ύ�����ݷ�װ��ʵ�������
				Book book=new Book(
					Integer.parseInt(items.get("id").get(0).getString("utf-8")),
					items.get("author").get(0).getString("utf-8"),	
					items.get("title").get(0).getString("utf-8"),									
					Double.parseDouble(items.get("price").get(0).getString("utf-8")),
					fileName					
			    );
				
				int publisherId=Integer.parseInt(items.get("publisherId").get(0).getString());
				Publisher publisher=new Publisher();
				publisher.setId(publisherId);
				book.setPublisher(publisher);
				
				
				//����ͼ��
				bookService.updateBook(book);
				
				//�ض���ͼ���б�
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

}





