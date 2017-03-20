package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.IServiceStudent;
import Service.ServiceStudent;
import entity.user;
@WebServlet("/login")
public class login extends HttpServlet {
	private IServiceStudent is=new ServiceStudent();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//获取表单提交的登录名和密码
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		user u=is.login(loginName);
		/*//获得表单提交的验证码
		String vcode=request.getParameter("vcode");
		//获得session中正确的验证码
		String sessionVcode=(String)session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(sessionVcode)){
			request.setAttribute("err_vcode","验证码错误");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}*/
		//使用登录名作为条件查询用户信息
		if(u==null){
			request.setAttribute("err_loginName", "登录名错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(!u.getPassword().equals(password)){
			request.setAttribute("err_password", "密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//将当前登录的用户信息存入Session	
			session.setAttribute("user", u);
			//设置Cookie对象
			Cookie cookie=new Cookie("loginName",u.getLoginName());
			//设置cookie的有效期
			cookie.setMaxAge(60*60*356);
			//添加Cookie
			response.addCookie(cookie);
			//登录成功
			response.sendRedirect("manage/show");
		}
	}

}
