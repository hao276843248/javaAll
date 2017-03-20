package lvyou.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lvyou.dao.BaomingDao;
import lvyou.dao.ContentDao;
import lvyou.dao.PinglunDao;
import lvyou.dao.UserDao;
import lvyou.model.Baoming;
import lvyou.model.Content;
import lvyou.model.Pinglun;
import lvyou.model.User;
import lvyou.util.Pager;
import lvyou.util.Util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;






public class WangzhanAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	
	private ContentDao contentDao;

	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	
	private String url = "./";
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	//网站首页
	public String index() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Util.init(request);
		//热点新闻
		List<Content> list1 = contentDao.selectBeanList(0, 5, " where  deletestatus=0 and leixing=1 order by tuijian");
		
		//景点介绍
		List<Content> list2 = contentDao.selectBeanList(0, 5, " where  deletestatus=0 and leixing=2 order by tuijian");
		
		//旅游线路
		List<Content> list3 = contentDao.selectBeanList(0, 5, " where  deletestatus=0 and leixing=3 order by tuijian");
		
		//餐饮酒店
		List<Content> list4 = contentDao.selectBeanList(0, 5, " where  deletestatus=0 and leixing=4 order by tuijian");
		
		//人文风采
		List<Content> list5 = contentDao.selectBeanList(0, 5, " where  deletestatus=0 and leixing=5 order by tuijian");
		//线路报名
		List<Baoming> list6 = baomingDao.selectBeanList(0, 8, " where deletestatus =0 order by id desc ");
		request.setAttribute("list6", list6);
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		request.setAttribute("list5", list5);
		
		return "success";
	}
	
	
	//网站内容列表
	public String contentlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (title != null && !"".equals(title)) {

			sb.append("title like '%" + title + "%'");
			sb.append(" and ");
			request.setAttribute("title", title);
		}
		
		if (leixing != null && !"".equals(leixing)) {

			sb.append("leixing='"+leixing+"'");
			sb.append(" and ");
			request.setAttribute("leixing", leixing);
			
			
			request.setAttribute("titletitle", Util.leixing(leixing));
		}

		sb.append("  deletestatus=0 order by tuijian ,id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10  ;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = contentDao.selectBeanCount(where.replaceAll(" order by tuijian ,id desc ", ""));
		request.setAttribute("list", contentDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "wangzhanmethod!contentlist.action?leixing="+leixing, "共有" + total + "条记录"));
		
		this.setUrl("contentlist.jsp");
		return SUCCESS;

	}
	
	
	//跳转到查看网站内容页面
	public String contentupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDianjicishu(bean.getDianjicishu()+1);
		contentDao.updateBean(bean);
		
		int count = pinglunDao.selectBeanCount(" where deletestatus=0 and content.id= "+request.getParameter("id"));
		request.setAttribute("count", count);
		int count2 = baomingDao.selectBeanCount(" where deletestatus=0 and content.id= "+request.getParameter("id"));
		request.setAttribute("count2", count2);
		
		request.setAttribute("leixing", Util.leixing(bean.getLeixing()));
		request.setAttribute("bean", bean);
		this.setUrl("contentupdate3.jsp");
		return SUCCESS;
	}
	
	
	private UserDao  userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//用户注册操作
	public void register2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setTruename(request.getParameter("truename"));
		user.setLianxifangshi(request.getParameter("lianxifangshi"));
		user.setCreatetime(new Date());
		
		user.setCreatetime(new Date());
		
		User u = userDao.selectBean(" where username='"+user.getUsername()+"'");
		
		if(u==null){
			userDao.insertBean(user);
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('注册成功，您的用户名是"+user.getUsername()+",请妥善保管');window.location.href='login.jsp';</script>");
		}else{
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('注册失败！该用户名已经存在！');window.location.href='register.jsp';</script>");
		}
		
	}
	
	
	//用户登录操作
	public void login2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = userDao.selectBean(" where username='"+username+"' and password='"+password+"' and deletestatus=0");
		if(u==null){
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误！');window.location.href='login.jsp';</script>");
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('登录成功！');window.location.href='./';</script>");
		}
	}
	
	//用户退出操作
	public void loginout() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('退出成功！');window.location.href='./';</script>");
	}
	

	private PinglunDao pinglunDao;

	public PinglunDao getPinglunDao() {
		return pinglunDao;
	}

	public void setPinglunDao(PinglunDao pinglunDao) {
		this.pinglunDao = pinglunDao;
	}
	
	public String pinglun() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='login.jsp';</script>");
			return null;
		}
	
		Content bean = contentDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("content", bean);
		this.setUrl("pinglun.jsp");
		return SUCCESS;
	}
	
	
	public String pinglun2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String contentid = request.getParameter("contentid");
		String pingluncontent = request.getParameter("pingluncontent"); 
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='login.jsp';</script>");
		}else{
			Pinglun bean = new Pinglun();
			bean.setContent(contentDao.selectBean(" where id= "+contentid));
			bean.setCreatetime(new Date());
			bean.setPingluncontent(pingluncontent);
			bean.setUser(user);
			pinglunDao.insertBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('添加成功');window.location.href='wangzhanmethod!pinglunlist.action?contentid="+contentid+"';</script>");
		}
		
		
		return null;
	}
	
	
	
	//网站内容列表
	public String pinglunlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String contentid = request.getParameter("contentid");
		
		Content content = contentDao.selectBean(" where id= "+contentid);
		request.setAttribute("content", content);
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		

		sb.append("  deletestatus=0  and contentid="+contentid+" order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10  ;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = pinglunDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", pinglunDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "wangzhanmethod!pinglunlist.action?contentid="+contentid, "共有" + total + "条记录"));
		
		this.setUrl("pinglunlist.jsp");
		return SUCCESS;

	}
	
	private BaomingDao  baomingDao;

	public BaomingDao getBaomingDao() {
		return baomingDao;
	}

	public void setBaomingDao(BaomingDao baomingDao) {
		this.baomingDao = baomingDao;
	}
	
	
	public String baoming() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='login.jsp';</script>");
			return null;
		}
	
		Content bean = contentDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("content", bean);
		this.setUrl("baoming.jsp");
		return SUCCESS;
	}
	
	
	public String baoming2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String contentid = request.getParameter("contentid");
		String beizhu = request.getParameter("beizhu"); 
		String dianhua = request.getParameter("dianhua"); 
		String xingming = request.getParameter("xingming"); 
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('请先登录');window.location.href='login.jsp';</script>");
		}else{
			Baoming bean = baomingDao.selectBean(" where deletestatus=0 and content.id="+contentid+"  and user.id="+user.getId()+"");
			if(bean==null){
				bean = new Baoming();
				bean.setContent(contentDao.selectBean(" where id= "+contentid));
				bean.setCreatetime(new Date());
				bean.setBeizhu(beizhu);
				bean.setDianhua(dianhua);
				bean.setXingming(xingming);
				bean.setZhuangtai("未处理");
				bean.setUser(user);
				baomingDao.insertBean(bean);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
				response
						.getWriter()
						.print(
								"<script language=javascript>alert('添加成功');window.location.href='wangzhanmethod!baominglist.action?contentid="+contentid+"';</script>");
			}else{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
				response
						.getWriter()
						.print(
								"<script language=javascript>alert('你已经报名该线路，报名失败');window.location.href='wangzhanmethod!baominglist.action?contentid="+contentid+"';</script>");
			}
			
		}
		
		
		return null;
	}
	
	
	
	//网站内容列表
	public String baominglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String contentid = request.getParameter("contentid");
		
		Content content = contentDao.selectBean(" where id= "+contentid);
		request.setAttribute("content", content);
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		

		sb.append("  deletestatus=0  and contentid="+contentid+" order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10  ;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = baomingDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", baomingDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "wangzhanmethod!baominglist.action?contentid="+contentid, "共有" + total + "条记录"));
		
		this.setUrl("baominglist.jsp");
		return SUCCESS;

	}
	
}
