package cn.hao.lyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.lyb.service.IMessageService;
import cn.hao.lyb.service.MessageService;
@WebServlet("/delete")
public class DeleteMessage extends HttpServlet {
	
	private IMessageService m=new MessageService();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int  a=Integer.parseInt(request.getParameter("id")) ;
		m.deleteMessage(a);
		response.sendRedirect("list");
	}

}
