package cn.hao.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;

import cn.hao.cms.entity.User;
import cn.hao.cms.service.user.IUserService;
import cn.hao.cms.service.user.UserServiceImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得用户填写的验证码
		String userVcode=request.getParameter("vcode");
		//从Session中获得正确的验证码
		HttpSession session=request.getSession();
		String realVcode=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		//检查用户输入的验证码是否正确		
		if(!userVcode.equalsIgnoreCase(realVcode)){
			request.setAttribute("err_vcode","验证码输入错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			return;
		}
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		IUserService iu=new UserServiceImpl();
		User user=iu.getUser(userName);
		if(user==null){
			request.setAttribute("err_userName","用户名填写错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);			
		}
		else if(!user.getPassword().equals(password)){
			request.setAttribute("err_password","密码填写错误");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else{
			//将用户信息存入session
			session.setAttribute("user",user);
			//将请求重定向到后台首页
			response.sendRedirect("background/index.jsp");
		}
	}

}
