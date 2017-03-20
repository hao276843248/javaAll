package cn.hao.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.service.user.IUserService;
import cn.hao.cms.service.user.UserServiceImpl;
@WebServlet("/background/user/delete")
public class delUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService iu=new UserServiceImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		iu.delUser(id);
		response.sendRedirect("list");
	}

}