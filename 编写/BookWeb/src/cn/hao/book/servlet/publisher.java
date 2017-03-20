package cn.hao.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.book.dao.Ipublisher;
import cn.hao.book.dao.publisherImlp;
import cn.hao.book.entity.Publisher;
@WebServlet("/manage/publisher")
public class publisher extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ipublisher ip=new publisherImlp();
		List<Publisher> p=null;
		p=ip.findpublisher();
		request.setAttribute("p", p);
		
	}
}
