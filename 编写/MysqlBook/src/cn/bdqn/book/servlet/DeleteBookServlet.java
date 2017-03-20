package cn.bdqn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.book.service.BookServiceImpl;
import cn.bdqn.book.service.IBookService;

@WebServlet("/manage/delete")
public class DeleteBookServlet extends HttpServlet {

	private IBookService bookService=new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//���Ҫɾ����ͼ����
		int id=Integer.parseInt(request.getParameter("id"));
	
		//ɾ��ͼ��
		bookService.deleteBook(id);
		
		//�ض����ͼ���б� 
		response.sendRedirect("list");
	}

}




