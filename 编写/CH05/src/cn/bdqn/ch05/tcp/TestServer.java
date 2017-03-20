package cn.bdqn.ch05.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	//���Է�������
	public static void main(String[] args) {
		System.out.println("������������");
		try {
			//������������Socket
			ServerSocket server=new ServerSocket(8800);
			
			do{
				System.out.println("��������׼�����տͻ�������");
				//�ȴ��ͻ�������
				Socket socket=server.accept();
				
				//��ȡ�������տͻ����������ݵ�������
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"UTF-8");
				BufferedReader br=new BufferedReader(isr);
				
				//��ȡ������ͻ��˷�����Ӧ���ݵ������
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				//��ȡ�ͻ��˷��͵���������
				String request=br.readLine();
				System.out.println("�������˽��յ��ͻ���["+socket.getInetAddress().getHostAddress()+"]���͵���������:"+request);
				
				//��ͻ��˷�����Ӧ����
				bw.write("��ã������Ƿ�������");
				bw.newLine();
				bw.flush();
				
				//�ر���
				br.close();
				bw.close();
				//�ر���ͻ��˵�����
				socket.close();
			}while(true);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

}
