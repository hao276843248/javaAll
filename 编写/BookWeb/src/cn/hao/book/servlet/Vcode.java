package cn.hao.book.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/vcode.jpg")
public class Vcode extends HttpServlet {
private static final String CHARS="ABCDEFGHJKLMNPQRSTUVWXY3456789";
	
	//生成随机字符串
	private String getRandomStr(int length){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++){
			//生成随机下标
			int index=(int)(Math.random()*CHARS.length());
			sb.append(CHARS.charAt(index));
		}		
		return sb.toString();		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置内容类型为jpg图片
		response.setContentType("image/jpeg");
		//获得验证码
		String vcode=getRandomStr(4);
		//将验证码存入Session
		HttpSession session=request.getSession();
		session.setAttribute("vcode",vcode);
		
		//创建图片对象(宽、高、颜色模式)
		BufferedImage img=new BufferedImage(100,30, BufferedImage.TYPE_INT_RGB);
		//获得画布
		Graphics g=img.getGraphics();
		//设置画笔颜色
		g.setColor(Color.WHITE);
		//填充矩形(x坐标，y坐标，宽度，高度)
		g.fillRect(0,0,100,30);
		//设置字体(字体名称，字体风格，字号)
		g.setFont(new Font("Impact",Font.PLAIN,25));
		
		//绘制干扰
		for(int i=0;i<10;i++){
			g.setColor(new Color(
				(int)(Math.random()*255),
				(int)(Math.random()*255),
				(int)(Math.random()*255)
			));
			
			g.fillOval(
				(int)(Math.random()*100),
				(int)(Math.random()*30),
				(int)(Math.random()*20),
				(int)(Math.random()*20)			
			);
			
		}
		
		//绘制文字
		for(int i=0;i<vcode.length();i++){
			char c=vcode.charAt(i);
			//随机生成颜色(红，绿，蓝)
			g.setColor(new Color(
				(int)(Math.random()*255),
				(int)(Math.random()*255),
				(int)(Math.random()*255)
			));
			//绘制文字(文字内容，x坐标，y坐标)
			g.drawString(c+"",i*25,25);			
		}
		
		
		
		
		//输出图片(图片对象，图片格式，字节输出流)
		ImageIO.write(img,"jpeg",response.getOutputStream());
		
	}
}