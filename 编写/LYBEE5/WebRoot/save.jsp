<%@page import="javax.crypto.spec.PSource"%>
<%@page import="sun.security.x509.IPAddressName"%>
<%@page import="cn.bdqn.jdbc.DBHelper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("nickName");
	String content=request.getParameter("content");
	String ip=request.getRemoteAddr();
	System.out.println(ip);
	System.out.println(name);
	System.out.println(content);
	Connection conn=null;
	PreparedStatement pstmt=null;
	try{
	conn=DBHelper.getConnection();
	String sql="INSERT INTO Message(id,nickName,content,ip) values(SEQ_MESSAGE.NEXTVal,?,?,?)";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, content);
	pstmt.setString(3, ip);
	pstmt.execute();
	
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		DBHelper.closeAll(conn, pstmt, null);
	}
	response.sendRedirect("index.jsp");
	
 %>