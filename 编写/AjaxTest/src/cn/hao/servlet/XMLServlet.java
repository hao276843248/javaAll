package cn.hao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/XML")
public class XMLServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String xml="<students> "+
						"<student number='123123'>"+
							"<name>ÕÅÈý</name>"+
							"<age>12</age>"+
							"<sex>male</sex>"+
						"</student>"+
					"</students>";
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xml);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
