package cn.hao.lyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.lyb.entity.Message;
import cn.hao.lyb.service.IMessageService;
import cn.hao.lyb.service.MessageService;
@WebServlet("/save")
public class SaveServlet extends HttpServlet {

	private IMessageService ms=new MessageService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name=request.getParameter("nickName");
		String content=request.getParameter("content");
		String ip=request.getRemoteAddr();
	//·â×°
		Message m=new Message(name, content, new Date(), ip);
		ms.addMessage(m);
		response.sendRedirect("list");
	}

	

}
