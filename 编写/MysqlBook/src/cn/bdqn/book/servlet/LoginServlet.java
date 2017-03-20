package cn.bdqn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.bdqn.book.entity.User;
import cn.bdqn.book.service.IUserService;
import cn.bdqn.book.service.UserServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private IUserService userService=new UserServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		//获得表单提交的验证码
		String vcode=request.getParameter("vcode");
		//获得session中正确的验证码
		String sessionVcode=(String)session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(sessionVcode)){
			request.setAttribute("err_vcode","验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		//获取表单提交的登录名和密码
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		
		//使用登录名作为条件查询用户信息
		User user=userService.getUser(loginName);
		if(user==null){
			request.setAttribute("err_loginName","登录名错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(!user.getPassword().equals(password)){
			request.setAttribute("err_password","密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{			
			//登录成功
			//将当前登录的用户信息存入Session			
			session.setAttribute("user", user);
			//将用户名存入Cookie，有效期一年
			Cookie cookie=new Cookie("loginName",user.getLoginName());
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
			
			
			response.sendRedirect("manage/list");
		}

		
	}

}










