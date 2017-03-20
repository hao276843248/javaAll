package cn.hao.sx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.sx.service.IStudentSrevice;
import cn.hao.sx.service.StudentServiceImpl;
@WebServlet("/delete")
public class delete extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStudentSrevice is=new StudentServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		is.delStudent(id);
		response.sendRedirect("show");
	}

}
