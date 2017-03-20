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
@WebServlet("/background/category/add")
public class addCategoryServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category c=new Category();
		if(request.getParameter("name")==null){
			request.setAttribute("err_name", "类名不能为空");
			request.getRequestDispatcher("add").forward(request, response);
			return;
		}
		c.setName(request.getParameter("name"));
		ICategoryService ic=new CategoryServiceImpl();
		ic.addCategory(c);
		response.sendRedirect("list");
	}

}
