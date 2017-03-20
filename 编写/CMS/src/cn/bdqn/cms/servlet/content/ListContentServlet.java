package cn.bdqn.cms.servlet.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.cms.service.content.ContentServiceImpl;
import cn.bdqn.cms.service.content.IContentService;
import cn.bdqn.cms.util.PageBean;

@WebServlet(urlPatterns={"/background/content/list","/list"})
public class ListContentServlet extends HttpServlet {

	private IContentService contentService=new ContentServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得分页参数
		int pageIndex=1;
		int pageSize=10;
		
		String pageIndexParam=request.getParameter("pageIndex");
		if(pageIndexParam!=null && !pageIndexParam.equals("")){
			pageIndex=Integer.parseInt(pageIndexParam);
		}
		
		String pageSizeParam=request.getParameter("pageSize");
		if(pageSizeParam!=null && !pageSizeParam.equals("")){
			pageSize=Integer.parseInt(pageSizeParam);
		}
		
		//获得查询条件
		Integer categoryId=null;
		String title="";
		String categoryName="";
		
		if(request.getParameter("categoryId")!=null && !request.getParameter("categoryId").equals("")){
			categoryId=Integer.parseInt(request.getParameter("categoryId"));
		}
		if(request.getParameter("title")!=null && !request.getParameter("title").equals("请输入标题")){
			title=request.getParameter("title");
		}
		if(request.getParameter("categoryName")!=null){
			categoryName=request.getParameter("categoryName");
		}
		
		PageBean p=contentService.findContent(pageIndex, pageSize, categoryId, title,categoryName);
		
		request.setAttribute("p",p);
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("list.jsp").forward(request,response);
		}
		
		
	}

}








