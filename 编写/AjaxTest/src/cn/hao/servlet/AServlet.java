package cn.hao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AServlet")
public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("Hello Ajax!!!");
		response.getWriter().print("Hello Ajax!!淡淡的倒萨阿斯阿斯!!");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nameString=request.getParameter("name");
		System.out.println("(POST: )hello ajax!!!"+nameString);
		System.out.println(nameString);
		response.getWriter().print("(POST: )Hello Ajax!!的的阿斯撒旦我阿斯顿我!!"+nameString);
		
	}

}
