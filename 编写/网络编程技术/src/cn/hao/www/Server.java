package cn.hao.www;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serbversocket=null;
		InputStream is=null;
		OutputStream os=null;
		System.out.println("����������");
		try {
			serbversocket = new ServerSocket(8800);
			do{
				System.out.println("��������׼�����տͻ�������");
				
				Socket socket=serbversocket.accept();
				is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				
				os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");
				BufferedWriter bw=new BufferedWriter(osw);
				
				String request;
				while((request=br.readLine())!=null){
					System.out.println("���Ƿ������ˣ��ͻ���¼��ϢΪ"+request);
				}
				System.out.println("�������˽��ܿͻ��˷��͵�������Ӧ");
				
				bw.write("��ã������Ƿ������ˣ�");
				bw.newLine();
				bw.flush();
				
				
				br.close();
				bw.close();
				socket.close();
			}while(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
}
