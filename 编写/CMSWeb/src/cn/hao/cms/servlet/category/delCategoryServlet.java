package cn.hao.cms.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;
@WebServlet("/background/category/delete")
public class delCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICategoryService ic=new CategoryServiceImpl();
		ic.delCategory(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("list");
	}

}
