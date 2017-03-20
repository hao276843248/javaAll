package cn.bdqn.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.entity.User;
import cn.bdqn.cms.service.user.IUserService;
import cn.bdqn.cms.service.user.UserServiceImpl;

@WebServlet("/background/user/update")
public class UpdateUserServlet extends HttpServlet {

	private IUserService userService=new UserServiceImpl();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		int id=Integer.parseInt(request.getParameter("id"));
		User user=userService.getUserById(id);
		request.setAttribute("user",user);
		request.getRequestDispatcher("edit.jsp").forward(request, response);		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		User user=new User(
			Integer.parseInt(request.getParameter("id")),
			request.getParameter("userName"),
			request.getParameter("password")
		);
		
		userService.updateUser(user);
		
		response.sendRedirect("list");
		
	}

}
