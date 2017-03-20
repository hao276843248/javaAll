package cn.hao.cms.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.entity.Category;
import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;
@WebServlet("/background/category/update")
public class updateCategoryServlet extends HttpServlet {
	private ICategoryService ic=new CategoryServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category c=ic.getCategory(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("c", c);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category c=new Category();
		if(request.getParameter("name")==null){
			request.setAttribute("err_name", "类名不能为空");
			request.getRequestDispatcher("add").forward(request, response);
			return;
		}
		c.setName(request.getParameter("name"));
		c.setId(Integer.parseInt(request.getParameter("id")));
		ic.updateCategory(c);
		response.sendRedirect("list");
	}

}
