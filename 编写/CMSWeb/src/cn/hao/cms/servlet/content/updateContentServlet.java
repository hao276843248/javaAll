package cn.hao.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.hao.cms.entity.Category;
import cn.hao.cms.entity.Content;
import cn.hao.cms.entity.User;
import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.content.ContentServiceImpl;
import cn.hao.cms.service.content.IContentService;
@WebServlet(urlPatterns={"/background/content/update","/get"})
public class updateContentServlet extends HttpServlet {
	private IContentService ic=new ContentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Content c=ic.getContent(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("c", c);
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得当前登录的用户对象
		if(request.getParameter("cid")==null || ("").equals(request.getParameter("cid"))){
			request.setAttribute("err_cid", "分类不能为空");
			request.getRequestDispatcher("edit.jsp");
			return;
		}
		if(request.getParameter("title")==null || ("").equals(request.getParameter("title"))){
			request.setAttribute("err_title", "标题不能为空");
			request.getRequestDispatcher("edit.jsp");
			return;
		}
		if(request.getParameter("content")==null || ("").equals(request.getParameter("content"))){
			request.setAttribute("err_content", "内容不能为空");
			request.getRequestDispatcher("edit.jsp");
			return;
		}
		System.out.println(request.getParameter("pic"));
		Content content=new Content(
			Integer.parseInt(request.getParameter("cid")),
			null,
			request.getParameter("title"),
			request.getParameter("link"),
			request.getParameter("content"),
			request.getParameter("pic")				
		);	
		ic.updateContent(content);
		response.sendRedirect("list");
	}

}
