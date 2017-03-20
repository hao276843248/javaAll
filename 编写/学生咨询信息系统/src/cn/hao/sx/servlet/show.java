package cn.hao.sx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.resources.CalendarData;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.sx.entity.Student;
import cn.hao.sx.entity.StudentFind;
import cn.hao.sx.entity.TJ;
import cn.hao.sx.service.IStudentSrevice;
import cn.hao.sx.service.StudentServiceImpl;
@WebServlet("/show")
public class show extends HttpServlet {
	private IStudentSrevice is=new StudentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		int cid=0;
		int eid=0;
		int time=0;
		int state=0;
		int a=1;
		int b=10;
		
		if(request.getParameter("pageIndex")!=null){
			a=Integer.parseInt(request.getParameter("pageIndex"));
		}
		if(request.getParameter("pageSize")!=null){
			b=Integer.parseInt(request.getParameter("pageSize"));
		}
		if(name==null){
			name="";
		}
		if(request.getParameter("cid")!=null && !request.getParameter("cid").equals("")){
			cid=Integer.parseInt(request.getParameter("cid"));
		}
		if(request.getParameter("eid")!=null && !request.getParameter("eid").equals("")){
			eid=Integer.parseInt(request.getParameter("eid"));
		}
		if(request.getParameter("time")!=null && !request.getParameter("time").equals("")){
			time=Integer.parseInt(request.getParameter("time"));
		}
		if(request.getParameter("state")!=null && !request.getParameter("state").equals("")){
			state=Integer.parseInt(request.getParameter("state"));
		}
		
		PageParam p=new PageParam(a,b);
		TJ tj=new TJ(name, cid, eid, time, state);
		List<StudentFind> s=is.findStudent(p,tj);
		request.setAttribute("p", p);
		request.setAttribute("s", s);
		request.setAttribute("tj", tj);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
