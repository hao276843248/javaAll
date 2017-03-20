package cn.bdqn.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.entity.Content;
import cn.bdqn.cms.service.content.ContentServiceImpl;
import cn.bdqn.cms.service.content.IContentService;

@WebServlet(urlPatterns={"/background/content/update","/get"})
public class UpdateContentServlet extends HttpServlet {

	private IContentService contentService=new ContentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Content content=contentService.getContentById(id);
		
		request.setAttribute("content",content);
		
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("edit.jsp").forward(request,response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Content content=new Content(
			Integer.parseInt(request.getParameter("id")),
			Integer.parseInt(request.getParameter("categoryId")),
			0,
			request.getParameter("title"),
			request.getParameter("link"),
			request.getParameter("content"),
			request.getParameter("pic")
		);
		
		contentService.updateContent(content);
		
		response.sendRedirect("list");
		
		
	}

}








