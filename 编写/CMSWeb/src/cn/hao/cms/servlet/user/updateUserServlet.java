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
@WebServlet("/background/user/updateUser")
public class updateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService iu=new UserServiceImpl();
		User u=iu.getOneUser(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("u", u);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		IUserService iu=new UserServiceImpl();
		String userName=request.getParameter("userName");
		User uu=iu.getUserold(userName);
		if(uu!=null){
			request.setAttribute("err_userName", "用户名已存在");
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			return;
		}
		if(userName==null){
			request.setAttribute("err_userName", "用户名不能为空");
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			return;
		}
		if(request.getParameter("password")==null){
			request.setAttribute("err_password", "密码不能为空");
			request.getRequestDispatcher("add.jsp").forward(request, response);
			return;
		}
		User u=new User();
		u.setId(Integer.parseInt(request.getParameter("id")));
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		String a=request.getParameter("password0");
		if(!a.equals(u.getPassword())){
			request.setAttribute("err_password0", "两次密码不一致");
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			return;
		}
		iu.updateUser(u);
		response.sendRedirect("list");
	}

}
