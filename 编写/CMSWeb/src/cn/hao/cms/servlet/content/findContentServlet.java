package cn.hao.cms.servlet.content;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.mybatis.plugin.PageParam;
import cn.hao.cms.entity.Category;
import cn.hao.cms.entity.Content;
import cn.hao.cms.service.category.CategoryServiceImpl;
import cn.hao.cms.service.category.ICategoryService;
import cn.hao.cms.service.content.ContentServiceImpl;
import cn.hao.cms.service.content.IContentService;
@WebServlet(urlPatterns={"/background/content/list","/list"})
public class findContentServlet extends HttpServlet {
	private IContentService ic=new ContentServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title=request.getParameter("title");
		if(title==null || title.equals("«Î ‰»Î±ÍÃ‚")){
			title="";
		}
		String cname=request.getParameter("cname");
		if(cname==null || cname.equals("")){
			cname="";
		}
		
		
		Integer cid=null;
		if (request.getParameter("cid")!=null && !request.getParameter("cid").equals("")) {
			cid=Integer.parseInt(request.getParameter("cid"));
		}
		int pageIndex=1;
		int pageSize=10;
		if(request.getParameter("pageIndex")!=null && !request.getParameter("pageIndex").equals("")){
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
		
		if(request.getParameter("pageSize")!=null && !request.getParameter("pageSize").equals("")){
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		
		PageParam p=new PageParam(pageIndex, pageSize);
		List<Content> cs=ic.findContent(p,title,cname,cid);
		request.setAttribute("p", p);
		request.setAttribute("cs",cs);
		if(request.getParameter("include")==null){
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
