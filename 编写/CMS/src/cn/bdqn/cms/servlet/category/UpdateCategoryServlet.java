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
		//���Ҫ�༭�ķ���id
		int id=Integer.parseInt(request.getParameter("id"));
		//����id���Ҫ�༭�ķ������
		Category category=categoryService.getCategoryById(id);
		
		request.setAttribute("category",category);
		//ת�����༭��ҳ��
		request.getRequestDispatcher("edit.jsp").forward(request,response);
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��װ���ύ�ķ�������
		Category category=new Category(
			Integer.parseInt(request.getParameter("id")),	
			request.getParameter("name")
		);
		//���·���
		categoryService.updateCategory(category);
		
		//�ض����б�
		response.sendRedirect("list");
	}

}









