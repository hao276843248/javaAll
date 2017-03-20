package QunLiao;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class FaSong extends Thread{
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	private String ip;
	private int duiduankou;
	private String name;
	
	public FaSong( String ip, int duiduankou, String name) {
	
		this.ip = ip;
		this.duiduankou = duiduankou;
		this.name = name;
	}

	public void run() {
		
		do{
			try {
				InetAddress addr=InetAddress.getByName("255.255.255.255");
				String msg=JOptionPane.showInputDialog("ÇëÊäÈë×Ö·û´®");
				Date now=new Date();
				String time=sdf.format(now);
				msg="["+time+"]"+name+":"+msg;
				byte[] data=msg.getBytes();
				
				DatagramPacket dp=new DatagramPacket(data,data.length,addr,8800);
				DatagramSocket ds=new DatagramSocket();
				
				ds.send(dp);
				ds.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
	}
}
