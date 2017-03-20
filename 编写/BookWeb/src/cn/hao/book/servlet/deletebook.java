package cn.hao.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.book.service.BookServiceImpl;
import cn.hao.book.service.IBookService;
@WebServlet("/manage/delete")
public class deletebook extends HttpServlet {
	private IBookService bookService=new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		bookService.deleteBook(id);
		response.sendRedirect("list");
	}


}
