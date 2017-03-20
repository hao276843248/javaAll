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
@WebServlet("/background/user/list")
public class findUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IUserService iu=new UserServiceImpl();
		String userName=request.getParameter("userName");
		if(userName==null || userName.equals("请输入用户名")){
			userName="";
		}
		List<User> users=iu.findUser(userName);
		request.setAttribute("users", users);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
