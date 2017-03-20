package cn.hao.sx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.service.IStudentSrevice;
import cn.hao.sx.service.StudentServiceImpl;
@WebServlet("/update")
public class update extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStudentSrevice is=new StudentServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		Student s=is.getStudent(id); 
		request.setAttribute("s", s);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IStudentSrevice is=new StudentServiceImpl();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d=new Date();
		Date addtime=new Date();
		try {
			d = sdf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a="|"+request.getParameter("sex")+"|";
		System.out.println(request.getParameter("sex"));
		Student s=new Student(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("name"),
				request.getParameter("sex"),
				d, 
				Integer.parseInt(request.getParameter("course")),
				Integer.parseInt(request.getParameter("education")),
				request.getParameter("contact"),
				Integer.parseInt(request.getParameter("time")),
				Integer.parseInt(request.getParameter("state")),
				addtime
				);
		is.updateStudent(s);
		response.sendRedirect("show");
	}

}
