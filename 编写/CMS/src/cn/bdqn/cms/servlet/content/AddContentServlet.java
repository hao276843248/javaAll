package cn.bdqn.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.cms.entity.Content;
import cn.bdqn.cms.entity.User;
import cn.bdqn.cms.service.content.ContentServiceImpl;
import cn.bdqn.cms.service.content.IContentService;

@WebServlet("/background/content/add")
public class AddContentServlet extends HttpServlet {

	private IContentService contentService=new ContentServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//获得当前登录的用户对象
		User user=(User)session.getAttribute("user");
		
		Content content=new Content(
			Integer.parseInt(request.getParameter("categoryId")),
			user.getId(),
			request.getParameter("title"),
			request.getParameter("link"),
			request.getParameter("content"),
			request.getParameter("pic")				
		);
		
		contentService.addContent(content);
		
		response.sendRedirect("list");
		
	}

}
