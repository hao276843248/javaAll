package cn.hao.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;
import cn.hao.cms.service.content.ContentServiceImpl;
import cn.hao.cms.service.content.IContentService;
@WebServlet("/background/content/delete")
public class delContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IContentService ic=new ContentServiceImpl();
		ic.delContent(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("list");
	}

}
