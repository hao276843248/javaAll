package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.IServiceStudent;
import Service.ServiceStudent;
@WebServlet("/manage/delete")
public class delete extends HttpServlet {

	private IServiceStudent is=new ServiceStudent();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("id"));
		is.deleteStudent(a);
		response.sendRedirect("show");
	}

}
