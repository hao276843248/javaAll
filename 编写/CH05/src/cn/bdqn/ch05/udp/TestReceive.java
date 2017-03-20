package cn.bdqn.ch05.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestReceive {

	public static void main(String[] args) {
		try {
			byte[] buf=new byte[10240];
			//创建用来接收数据的数据报
			DatagramPacket dp=new DatagramPacket(buf,10240);
			DatagramSocket ds=new DatagramSocket(8800);
			ds.receive(dp);
			//将接收到的数据转换成字符串
			String msg=new String(dp.getData(),0,dp.getLength());
			System.out.println(msg);
			ds.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
