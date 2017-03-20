package QunLiao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JieShou extends Thread {
	private int duankou;
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	
	public JieShou(int duankou) {
		super();
		this.duankou = duankou;
	}

	@Override
	public void run() {
		do{
			try {
				byte[] buf=new byte[10240];
				//创建用来接收数据的数据报
				DatagramPacket dp=new DatagramPacket(buf,10240);
				DatagramSocket ds=new DatagramSocket(8800);
				ds.receive(dp);
				//将接收到的数据转换成字符串
				String reply=new String(dp.getData(),0,dp.getLength());
				Date now=new Date();
				String asd=sdf.format(now);
				asd="["+asd+"]:"+reply;
				System.out.println(asd);
				ds.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while(true);
		
		
	}
}
