package cn.bdqn.talk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiveThread extends Thread{
	private SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");

	//��������Socket
	private ServerSocket server;
	
	public ReceiveThread(int port){
		try {
			//������������Socket
			server=new ServerSocket(port);
		} catch (IOException e) {			
			System.out.println("�򿪷�������ʱ��������:"+e.getMessage());
		}
	}
	
	@Override
	public void run() {
		do{
			try {
				Socket socket=server.accept();
				
				//��ȡ�������տͻ����������ݵ�������
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br=new BufferedReader(isr);

				//��ȡ�ͻ��˷��͵���������
				String request=br.readLine();
				
				//��õ�ǰʱ��
				Date now=new Date();
				String time=sdf.format(now);
							
				//�����յ���������ʾ�ڿ���̨��
				System.out.println("["+time+"]:"+request);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
		}while(true);
		
	}

}








