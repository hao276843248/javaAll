package cn.hao.cms.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.entity.Category;
import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;
@WebServlet("/background/category/list")
public class findCategoryServlet extends HttpServlet {
	private ICategoryService ic=new CategoryServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		if(name==null || name.equals("请输入分类名")){
			name="";
		}
		List<Category> cs=ic.findCategory(name);
		request.setAttribute("cate",cs);
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
