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
import cn.hao.cms.service.category.ICategoryService;
import cn.hao.cms.service.content.ContentServiceImpl;
import cn.hao.cms.service.content.IContentService;
@WebServlet("/background/content/add")
public class addContentServlet extends HttpServlet {
	private IContentService ic=new ContentServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//��õ�ǰ��¼���û�����
		if(request.getParameter("cid")==null || ("").equals(request.getParameter("cid"))){
			request.setAttribute("err_cid", "���಻��Ϊ��");
			request.getRequestDispatcher("add.jsp");
			return;
		}
		if(request.getParameter("title")==null || ("").equals(request.getParameter("title"))){
			request.setAttribute("err_title", "���ⲻ��Ϊ��");
			request.getRequestDispatcher("add.jsp");
			return;
		}
		if(request.getParameter("content")==null || ("").equals(request.getParameter("content"))){
			request.setAttribute("err_content", "���ݲ���Ϊ��");
			request.getRequestDispatcher("add.jsp");
			return;
		}
		User user=(User)session.getAttribute("user");
		System.out.println(request.getParameter("pic"));
		Content content=new Content(
			Integer.parseInt(request.getParameter("cid")),
			user.getId(),
			request.getParameter("title"),
			request.getParameter("link"),
			request.getParameter("content"),
			request.getParameter("pic")				
		);
		ic.addContent(content);
		response.sendRedirect("list");
	}

}
