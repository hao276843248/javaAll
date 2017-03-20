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
		//��ȡ���ύ�ĵ�¼��������
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		user u=is.login(loginName);
		/*//��ñ��ύ����֤��
		String vcode=request.getParameter("vcode");
		//���session����ȷ����֤��
		String sessionVcode=(String)session.getAttribute("vcode");
		if(!vcode.equalsIgnoreCase(sessionVcode)){
			request.setAttribute("err_vcode","��֤�����");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return;
		}*/
		//ʹ�õ�¼����Ϊ������ѯ�û���Ϣ
		if(u==null){
			request.setAttribute("err_loginName", "��¼������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(!u.getPassword().equals(password)){
			request.setAttribute("err_password", "�������");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//����ǰ��¼���û���Ϣ����Session	
			session.setAttribute("user", u);
			//����Cookie����
			Cookie cookie=new Cookie("loginName",u.getLoginName());
			//����cookie����Ч��
			cookie.setMaxAge(60*60*356);
			//���Cookie
			response.addCookie(cookie);
			//��¼�ɹ�
			response.sendRedirect("manage/show");
		}
	}

}
