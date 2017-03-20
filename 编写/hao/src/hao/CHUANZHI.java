package hao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class CHUANZHI {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*	生成验证码！图片
		 * 
		 * Image、ImageIO、BufferedImage、Icon、ImageIcon
		*/
		BufferedImage bi=new BufferedImage(70,35, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2=(Graphics2D)bi.getGraphics();
		g2.fillRect(0,0, 70, 35);
		g2.setColor(Color.RED);
		g2.setFont(new Font("黑体",Font.BOLD,18));
		g2.setColor(Color.BLACK);
		g2.drawString("as15", 5,20);
		ImageIO.write(bi, "jpeg",new FileOutputStream("f:/a.jpg"));
		
	}
}
