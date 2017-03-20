package cn.bdqn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.book.entity.Book;
import cn.bdqn.book.service.BookServiceImpl;
import cn.bdqn.book.service.IBookService;
import cn.bdqn.book.util.Context;
import cn.bdqn.book.util.PageBean;

@WebServlet("/manage/list")
public class ListBookServlet extends HttpServlet {

	private IBookService bookService=new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		System.out.println("ListBookServlet 线程名称:"+Thread.currentThread().getName());
		Context.set("Hello,"+Thread.currentThread().getName());
		
		
		int pageIndex=1;
		int pageSize=3;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		
		
		//获得标题关键字
		String title=request.getParameter("title");
		if(title==null){
			title="";
		}
		//查询图书列表
		//List<Book> books=bookService.findBook(title);
		PageBean p=bookService.findBook(pageIndex, pageSize, title);
		
		//将图书列表存入request
		//request.setAttribute("books",books);
		request.setAttribute("p",p);
		
		
		//转发到index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}






