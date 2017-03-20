package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) {
		try {
			InetAddress addr=InetAddress.getByName("255.255.255.255");
			String msg="你好！这是使用UDP协议发送的数据";
			
			byte[] data=msg.getBytes();
			
			DatagramPacket dp=new DatagramPacket(data,data.length,addr,8800);
			DatagramSocket ds=new DatagramSocket();
			
			ds.send(dp);
			ds.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
