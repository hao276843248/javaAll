package cn.bdqn.talk;

import java.util.Scanner;

public class Main {

	//主线程
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		System.out.println("请输入本机端口号:");
		int port=input.nextInt();
		
		System.out.println("请输入对方IP地址:");
		String ip=input.next();
		
		System.out.println("请输入对方端口号:");
		int targetPort=input.nextInt();
		
		System.out.println("请输入昵称:");
		String nickName=input.next();
		
		//创建发送线程:
		SendThread sendThread=new SendThread(ip, targetPort, nickName);
		//创建接收线程:
		ReceiveThread receiveThread=new ReceiveThread(port);
		
		//启动发送线程和接收线程
		sendThread.start();
		receiveThread.start();
		
	}
	
}








