package cn.bdqn.cms.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.cms.entity.User;
import cn.bdqn.cms.service.user.IUserService;
import cn.bdqn.cms.service.user.UserServiceImpl;

import com.google.code.kaptcha.Constants;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private IUserService userService=new UserServiceImpl();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//����û���д����֤��
		String userVcode=request.getParameter("vcode");
		//��Session�л����ȷ����֤��
		HttpSession session=request.getSession();
		String realVcode=(String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		
		//����û��������֤���Ƿ���ȷ
		if(!userVcode.equalsIgnoreCase(realVcode)){
			request.setAttribute("err_vcode","��֤���������");
			request.getRequestDispatcher("login.jsp").forward(request,response);
			return;
		}
		
		//����û���д���û���������
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		//�����û������Ҷ�Ӧ���û���¼
		User user=userService.getUserByName(userName);
		if(user==null){
			request.setAttribute("err_userName","�û�����д����");
			request.getRequestDispatcher("login.jsp").forward(request,response);			
		}
		else if(!user.getPassword().equals(password)){
			request.setAttribute("err_password","������д����");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		else{
			//���û���Ϣ����session
			session.setAttribute("user",user);
			//�������ض��򵽺�̨��ҳ
			response.sendRedirect("background/index.jsp");
		}
		
	}

}








