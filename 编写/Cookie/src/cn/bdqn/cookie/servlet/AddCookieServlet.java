package cn.bdqn.cookie.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str=URLEncoder.encode("��ã�����!","utf-8");
		
		Cookie cookie=new Cookie("msg",str);
		//����cookie����Ч��
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}

}







