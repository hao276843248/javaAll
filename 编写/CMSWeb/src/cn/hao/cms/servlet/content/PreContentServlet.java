package cn.hao.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.entity.Content;
import cn.hao.cms.service.content.ContentServiceImpl;
import cn.hao.cms.service.content.IContentService;

@WebServlet("/preContent")
public class PreContentServlet extends HttpServlet {

	private IContentService contentService=new ContentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Content content=contentService.getPreContent(id);
		request.setAttribute("preContent",content);
	}

	

}
