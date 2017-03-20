package cn.hao.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hao.cms.entity.User;
import cn.hao.cms.service.user.IUserService;
import cn.hao.cms.service.user.UserServiceImpl;
@WebServlet("/background/user/addUser")
public class addUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService iu=new UserServiceImpl();
		String userName=request.getParameter("userName");
		if(userName==null){
			request.setAttribute("err_userName", "用户名不能为空");
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
		User users=iu.getUserold(userName);
		if(users!=null){
			request.setAttribute("err_userName", "用户名已存在");
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
		
		if(request.getParameter("password")==null){
			request.setAttribute("err_password", "密码不能为空");
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
		User u=new User();
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		String a=request.getParameter("password0");
		if(!a.equals(u.getPassword())){
			request.setAttribute("err_password0", "两次密码不一致");
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
		
	
		iu.addUser(u);
		response.sendRedirect("list");
		
	}
}
