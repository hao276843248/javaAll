package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.PageBean;

import entity.Student;

import Service.IServiceStudent;
import Service.ServiceStudent;
@WebServlet("/manage/show")
public class find extends HttpServlet {
	private IServiceStudent is=new ServiceStudent();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageIndex=1;
		int pageSize=5;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		 PageBean p=is.findStudent(pageIndex,pageSize,"");
		request.setAttribute("p", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
