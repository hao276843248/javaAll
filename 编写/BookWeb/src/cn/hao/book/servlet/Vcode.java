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
	
	//��������ַ���
	private String getRandomStr(int length){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++){
			//��������±�
			int index=(int)(Math.random()*CHARS.length());
			sb.append(CHARS.charAt(index));
		}		
		return sb.toString();		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������������ΪjpgͼƬ
		response.setContentType("image/jpeg");
		//�����֤��
		String vcode=getRandomStr(4);
		//����֤�����Session
		HttpSession session=request.getSession();
		session.setAttribute("vcode",vcode);
		
		//����ͼƬ����(���ߡ���ɫģʽ)
		BufferedImage img=new BufferedImage(100,30, BufferedImage.TYPE_INT_RGB);
		//��û���
		Graphics g=img.getGraphics();
		//���û�����ɫ
		g.setColor(Color.WHITE);
		//������(x���꣬y���꣬��ȣ��߶�)
		g.fillRect(0,0,100,30);
		//��������(�������ƣ��������ֺ�)
		g.setFont(new Font("Impact",Font.PLAIN,25));
		
		//���Ƹ���
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
		
		//��������
		for(int i=0;i<vcode.length();i++){
			char c=vcode.charAt(i);
			//���������ɫ(�죬�̣���)
			g.setColor(new Color(
				(int)(Math.random()*255),
				(int)(Math.random()*255),
				(int)(Math.random()*255)
			));
			//��������(�������ݣ�x���꣬y����)
			g.drawString(c+"",i*25,25);			
		}
		
		
		
		
		//���ͼƬ(ͼƬ����ͼƬ��ʽ���ֽ������)
		ImageIO.write(img,"jpeg",response.getOutputStream());
		
	}
}