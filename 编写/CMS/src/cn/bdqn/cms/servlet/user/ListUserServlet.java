package cn.bdqn.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.entity.User;
import cn.bdqn.cms.service.user.IUserService;
import cn.bdqn.cms.service.user.UserServiceImpl;

@WebServlet("/background/user/list")
public class ListUserServlet extends HttpServlet {

	private IUserService userService=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得用户提交的查询条件
		String userName=request.getParameter("userName");
		if(userName==null || userName.equals("请输入用户名")){
			userName="";
		}
		
		List<User> users=userService.findUser(userName);
		
		request.setAttribute("users",users);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);				
	}

}












