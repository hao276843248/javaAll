package cn.bdqn.talk;

import java.util.Scanner;

public class Main {

	//���߳�
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("�����뱾���˿ں�:");
		int port=input.nextInt();
		
		System.out.println("������Է�IP��ַ:");
		String ip=input.next();
		
		System.out.println("������Է��˿ں�:");
		int targetPort=input.nextInt();
		
		System.out.println("�������ǳ�:");
		String nickName=input.next();
		
		//���������߳�:
		SendThread sendThread=new SendThread(ip, targetPort, nickName);
		//���������߳�:
		ReceiveThread receiveThread=new ReceiveThread(port);
		
		//���������̺߳ͽ����߳�
		sendThread.start();
		receiveThread.start();
		
	}
	
}








