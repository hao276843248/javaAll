package lvyou.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lvyou.dao.BaomingDao;
import lvyou.dao.ContentDao;
import lvyou.dao.ManageDao;
import lvyou.dao.PinglunDao;
import lvyou.dao.UserDao;
import lvyou.model.Baoming;
import lvyou.model.Content;
import lvyou.model.Manage;
import lvyou.model.Pinglun;
import lvyou.model.User;
import lvyou.util.Pager;
import lvyou.util.Util;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class HoutaiAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	private ManageDao manageDao;

	private String url = "./";

	

	public ManageDao getManageDao() {
		return manageDao;
	}

	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
	

	
//用户登录操作
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Manage user = manageDao.selectBean(" where username='"+username+"' and password='"+password+"' ");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("wangzhanmanage", user);
			this.setUrl("manage/index.jsp");
			return "redirect";
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');window.location.href='manage/login.jsp';</script>");
		}
		return null;
	}
//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("wangzhanmanage");
		session.invalidate();
		this.setUrl("manage/login.jsp");
		return SUCCESS;
	}
//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("manage/user/user.jsp");
		return SUCCESS;
	}
	
	
	//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		Manage u = (Manage)session.getAttribute("wangzhanmanage");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Manage bean = manageDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"'" );
		if(bean!=null){
			bean.setPassword(password2);
			manageDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('修改成功');window.location.href='houtaimethod!changepwd.action';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');window.location.href='houtaimethod!changepwd.action';</script>");
		}
	}

	private ContentDao contentDao;
	
	
	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
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
				currentpage, "houtaimethod!contentlist.action?leixing="+leixing, "共有" + total + "条记录"));
		request.setAttribute("url", "houtaimethod!contentlist.action?leixing="+leixing);
		request.setAttribute("url2", "houtaimethod!content");
		
		this.setUrl("manage/content/contentlist.jsp");
		return SUCCESS;

	}
//跳转到添加网站内容页面
	public String contentadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String leixing = request.getParameter("leixing");
		request.setAttribute("leixing", leixing);
		request.setAttribute("url", "houtaimethod!contentadd2.action");
		request.setAttribute("titletitle", Util.leixing(leixing)+"添加");
		this.setUrl("manage/content/contentadd.jsp");
		return SUCCESS;
	}
//添加网站内容操作
	public void contentadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content1");
		String leixing = request.getParameter("leixing");
		String title = request.getParameter("title");

		Content bean = new Content();
		bean.setContent(content);
		bean.setCreatetime(new Date());
		bean.setLeixing(leixing);
		bean.setTitle(title);
		bean.setTuijian("未推荐");
		contentDao.insertBean(bean);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!contentlist.action?leixing="+leixing+"';</script>");
		
		
	}
//跳转到更新网站内容页面
	public String contentupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("url", "houtaimethod!contentupdate2.action?id="+bean.getId());
		request.setAttribute("titletitle", Util.leixing(bean.getLeixing())+"修改");
		this.setUrl("manage/content/contentupdate.jsp");
		return SUCCESS;
	}
//更新网站内容操作
	public void contentupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content1");
		String title = request.getParameter("title");
		

		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setContent(content);
		bean.setTitle(title);
		contentDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!contentlist.action?leixing="+bean.getLeixing()+"';</script>");
	}
//删除网站内容操作
	public void contentdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(1);
		contentDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!contentlist.action?leixing="+bean.getLeixing()+"';</script>");
	}
	
	
	
	
	
	
	//推荐操作
	public void contentdelete2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setTuijian("推荐");
		contentDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!contentlist.action?leixing="+bean.getLeixing()+"';</script>");
	}
	
	//取消推荐操作
	public void contentdelete3() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Content bean = contentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setTuijian("未推荐");
		contentDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!contentlist.action?leixing="+bean.getLeixing()+"';</script>");
	}
	
	private UserDao userDao;
	
	private PinglunDao pinglunDao;
	
	private BaomingDao baomingDao;



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PinglunDao getPinglunDao() {
		return pinglunDao;
	}

	public void setPinglunDao(PinglunDao pinglunDao) {
		this.pinglunDao = pinglunDao;
	}

	public BaomingDao getBaomingDao() {
		return baomingDao;
	}

	public void setBaomingDao(BaomingDao baomingDao) {
		this.baomingDao = baomingDao;
	}

	
	//线路报名列表
	public String baominglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (title != null && !"".equals(title)) {

			sb.append(" content.title like '%" + title + "%'");
			sb.append(" and ");
			request.setAttribute("title", title);
		}
		
		

		sb.append("  deletestatus=0 order by zhuangtai desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10  ;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = baomingDao.selectBeanCount(where.replaceAll(" order by zhuangtai desc ", ""));
		request.setAttribute("list", baomingDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "houtaimethod!baominglist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "houtaimethod!baominglist.action");
		request.setAttribute("url2", "houtaimethod!baoming");
		request.setAttribute("titletitle", "线路报名管理");
		this.setUrl("manage/baoming/baominglist.jsp");
		return SUCCESS;

	}
	
	//处理报名操作
	public void baomingdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Baoming bean = baomingDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setZhuangtai("已处理");
		baomingDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!baominglist.action';</script>");
	}
	
	
	//评论列表
	public String pinglunlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String title = request.getParameter("title");
		

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (title != null && !"".equals(title)) {

			sb.append(" content.title like '%" + title + "%'");
			sb.append(" and ");
			request.setAttribute("title", title);
		}
		
		

		sb.append("  deletestatus=0 order by id desc ");
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
				currentpage, "houtaimethod!pinglunlist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "houtaimethod!pinglunlist.action");
		request.setAttribute("url2", "houtaimethod!pinglun");
		request.setAttribute("titletitle", "评论管理");
		this.setUrl("manage/pinglun/pinglunlist.jsp");
		return SUCCESS;

	}
	
	//处理报名操作
	public void pinglundelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Pinglun bean = pinglunDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(1);
		pinglunDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!pinglunlist.action';</script>");
	}
	
	//注册用户列表
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (username != null && !"".equals(username)) {

			sb.append(" username like '%" + username + "%'");
			sb.append(" and ");
			request.setAttribute("username", username);
		}
		
		

		sb.append("  1=1 order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 10  ;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "houtaimethod!userlist.action", "共有" + total + "条记录"));
		request.setAttribute("url", "houtaimethod!userlist.action");
		request.setAttribute("url2", "houtaimethod!user");
		request.setAttribute("titletitle", "注册用户管理");
		this.setUrl("manage/user/userlist.jsp");
		return SUCCESS;

	}
	
	//锁定账户操作
	public void userdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(1);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!userlist.action';</script>");
	}
	
	//账户解锁操作
	public void userdelete2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		bean.setDeletestatus(0);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作成功');window.location.href='houtaimethod!userlist.action';</script>");
	}
	
}
