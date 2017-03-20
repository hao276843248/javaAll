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

@WebServlet("/background/user/add")
public class AddUserServlet extends HttpServlet {

	private IUserService userService=new UserServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		User user=new User(
			request.getParameter("userName"),
			request.getParameter("password")
		);
		
		userService.addUser(user);
		
		response.sendRedirect("list");
		
	}

}
