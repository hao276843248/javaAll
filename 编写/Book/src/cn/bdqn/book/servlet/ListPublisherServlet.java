package cn.bdqn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.book.entity.Publisher;
import cn.bdqn.book.service.IPublisherService;
import cn.bdqn.book.service.PublisherServiceImpl;

@WebServlet("/manage/publishers")
public class ListPublisherServlet extends HttpServlet {

	private IPublisherService publisherService=new PublisherServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Publisher> publishers=publisherService.findPublihser();
		request.setAttribute("publishers", publishers);		
	}

}








