package cn.hao.book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hao.book.entity.Book;
import cn.hao.book.service.BookServiceImpl;
import cn.hao.book.service.IBookService;
import cn.hao.book.util.PageBean;
@WebServlet("/manage/list")
public class Find extends HttpServlet {
	
	private IBookService bookService=new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageIndex=1;
		int pageSize=5;
		//��ñ���ؼ���
		String title=request.getParameter("title");
		if(title==null){
			title="";
		}
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		PageBean p=bookService.findBook(pageIndex,pageSize,title);
		//��ѯͼ���б�
		//List<Book> books=bookService.findBook(title);
		//��ͼ���б����request
		
		request.setAttribute("p",p);
		//��ȡ��Ŀ��
		//System.out.println(request.getContextPath());
		//System.out.println(request.getSession().getServletContext().getContextPath());
		//ת����index.jsp
		request.getRequestDispatcher("index.jsp").forward(request, response);	
						
	}

}
