package cn.hao.lyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.lyb.entity.Message;
import cn.hao.lyb.service.IMessageService;
import cn.hao.lyb.service.MessageService;
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	
	private IMessageService messageService=new MessageService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Message> message=messageService.findMessage();
		request.setAttribute("message", message);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
