package cn.bdqn.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.service.user.IUserService;
import cn.bdqn.cms.service.user.UserServiceImpl;

@WebServlet("/background/user/delete")
public class DeleteUserServlet extends HttpServlet {

	private IUserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		userService.deleteUser(id);
		
		response.sendRedirect("list");
	}

}
