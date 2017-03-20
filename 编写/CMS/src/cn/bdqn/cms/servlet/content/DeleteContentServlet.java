package cn.bdqn.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.service.content.ContentServiceImpl;
import cn.bdqn.cms.service.content.IContentService;

@WebServlet("/background/content/delete")
public class DeleteContentServlet extends HttpServlet {

	private IContentService contentService=new ContentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		contentService.deleteContent(id);
		
		response.sendRedirect("list");
	}

}





