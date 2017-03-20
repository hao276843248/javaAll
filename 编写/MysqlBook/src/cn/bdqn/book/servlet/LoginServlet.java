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
		//��ñ��ύ����֤��
		String vcode=request.getParameter("vcode");
		//���session����ȷ����֤��
		String sessionVcode=(String)session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(sessionVcode)){
			request.setAttribute("err_vcode","��֤�����");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		//��ȡ���ύ�ĵ�¼��������
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		
		//ʹ�õ�¼����Ϊ������ѯ�û���Ϣ
		User user=userService.getUser(loginName);
		if(user==null){
			request.setAttribute("err_loginName","��¼������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if(!user.getPassword().equals(password)){
			request.setAttribute("err_password","�������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else{			
			//��¼�ɹ�
			//����ǰ��¼���û���Ϣ����Session			
			session.setAttribute("user", user);
			//���û�������Cookie����Ч��һ��
			Cookie cookie=new Cookie("loginName",user.getLoginName());
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
			
			
			response.sendRedirect("manage/list");
		}

		
	}

}










