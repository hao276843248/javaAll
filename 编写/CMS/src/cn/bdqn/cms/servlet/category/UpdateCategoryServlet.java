package cn.bdqn.cms.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.entity.Category;
import cn.bdqn.cms.service.category.CategoryServiceImpl;
import cn.bdqn.cms.service.category.ICategoryService;

@WebServlet("/background/category/update")
public class UpdateCategoryServlet extends HttpServlet {
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得要编辑的分类id
		int id=Integer.parseInt(request.getParameter("id"));
		//根据id获得要编辑的分类对象
		Category category=categoryService.getCategoryById(id);
		
		request.setAttribute("category",category);
		//转发到编辑表单页面
		request.getRequestDispatcher("edit.jsp").forward(request,response);
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//封装表单提交的分类数据
		Category category=new Category(
			Integer.parseInt(request.getParameter("id")),	
			request.getParameter("name")
		);
		//更新分类
		categoryService.updateCategory(category);
		
		//重定向到列表
		response.sendRedirect("list");
	}

}









