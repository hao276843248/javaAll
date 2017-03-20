package cn.bdqn.cms.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.entity.Category;
import cn.bdqn.cms.service.category.CategoryServiceImpl;
import cn.bdqn.cms.service.category.ICategoryService;

@WebServlet("/background/category/list")
public class ListCategoryServlet extends HttpServlet {
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String name=request.getParameter("name");
		if(name==null || name.equals("�����������")){
			name="";			
		}
		
		List<Category> categorys=categoryService.findCategory(name);
		
		request.setAttribute("categorys",categorys);
		
		//���Servlet���Ǳ�ҳ�����(��������в���������include�Ĳ���)
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("list.jsp").forward(request,response);
		}
		
		
	
	}

}









