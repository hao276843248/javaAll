package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Testjie {
	public static void main(String[] args) {
		byte[] buf=new byte[10240];
		
		
		try {
			System.out.println("׼�����գ�");
			DatagramPacket dp=new DatagramPacket(buf, 10240);
			DatagramSocket ds=new DatagramSocket(8800);
			
			ds.receive(dp);
			String msg=new String(dp.getData(),0,dp.getLength());
			System.out.println(msg);
			ds.close();
			System.out.println("������ϣ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
