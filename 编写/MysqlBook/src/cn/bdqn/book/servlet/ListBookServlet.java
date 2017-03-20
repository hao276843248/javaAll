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
	
		
		System.out.println("ListBookServlet �߳�����:"+Thread.currentThread().getName());
		Context.set("Hello,"+Thread.currentThread().getName());
		
		
		int pageIndex=1;
		int pageSize=3;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		
		
		//��ñ���ؼ���
		String title=request.getParameter("title");
		if(title==null){
			title="";
		}
		//��ѯͼ���б�
		//List<Book> books=bookService.findBook(title);
		PageBean p=bookService.findBook(pageIndex, pageSize, title);
		
		//��ͼ���б����request
		//request.setAttribute("books",books);
		request.setAttribute("p",p);
		
		
		//ת����index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}






