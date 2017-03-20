package cn.bdqn.ch05.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSend {

	public static void main(String[] args) {
		
		try {
			//获得对方的地址
			InetAddress addr=InetAddress.getByName("localhost");
			String msg="你好！这是使用UDP协议发送的数据！";
			byte[] data=msg.getBytes();
			//创建数据报封装数据
			DatagramPacket dp=new DatagramPacket(data,data.length,addr,8800);
			DatagramSocket ds=new DatagramSocket();
			//发送数据报
			ds.send(dp);
			//关闭Socket
			ds.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
