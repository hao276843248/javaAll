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

@WebServlet("/background/category/add")
public class AddCategoryServlet extends HttpServlet {
	
	private ICategoryService categoryService=new CategoryServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��װ���ύ�ķ�������
		Category category=new Category(
			request.getParameter("name")
		);
		//�������
		categoryService.addCategory(category);
		
		//�ض����б�
		response.sendRedirect("list");
	}

}









