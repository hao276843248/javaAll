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
		
		
		
		//获得要删除的图书编号
		int id=Integer.parseInt(request.getParameter("id"));
	
		//删除图书
		bookService.deleteBook(id);
		
		//重定向回图书列表 
		response.sendRedirect("list");
	}

}




