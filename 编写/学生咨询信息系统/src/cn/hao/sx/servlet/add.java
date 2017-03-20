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

import sun.misc.Perf.GetPerfAction;

import cn.hao.sx.entity.Student;
import cn.hao.sx.service.IStudentSrevice;
import cn.hao.sx.service.StudentServiceImpl;
@WebServlet("/add")
public class add extends HttpServlet {

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
		System.out.println(request.getParameter("sex"));
		Student s=new Student(
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
		is.addStudent(s);
		response.sendRedirect("show");
	}

}
