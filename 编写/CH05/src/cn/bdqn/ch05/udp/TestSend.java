package cn.bdqn.ch05.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSend {

	public static void main(String[] args) {
		
		try {
			//��öԷ��ĵ�ַ
			InetAddress addr=InetAddress.getByName("localhost");
			String msg="��ã�����ʹ��UDPЭ�鷢�͵����ݣ�";
			byte[] data=msg.getBytes();
			//�������ݱ���װ����
			DatagramPacket dp=new DatagramPacket(data,data.length,addr,8800);
			DatagramSocket ds=new DatagramSocket();
			//�������ݱ�
			ds.send(dp);
			//�ر�Socket
			ds.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
